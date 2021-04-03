#include "platform.hpp"
#include "player.hpp"
#include <gamestate.hpp>
#include <sound.hpp>


player::player(float x, float y, float width, float height, sf::Texture& texture) {
    onGround = false;
    collision = false;
    setBuff = false;
    finish = false;
    maxGravity = 5.f;
    accelGravity = 0.5f;
    speed = 3.0f;
    jumpHeight = 10.f;
    size.x = width;
    size.y = height;

    frameSize.x = 60;
    frameSize.y = 58;
    framesAmount.x = texture.getSize().x / frameSize.x;
    framesAmount.y = texture.getSize().y / frameSize.y;
    dead = 0;
    choice = 0;
    mChoice = 1;
    attempt = 1;
    jumped = 0;
    runningCounter = 0;
    jumpingCounter = 0;
    idleCounter = 0;
    deathCounter = 0;

    // Number of frames
    runFrames = 6;
    jumpFrames = 6;
    idleFrames = 6;
    deathFrames = 6;

    // Speed. Lower = Faster
    idleSpeed = 6;
    walkSpeed = 6;
    jumpSpeed = 2;
    deathSpeed = 20;

    // Increment each row first.
    for(int y = 0; y < framesAmount.y; y++){
        for(int x = 0 ; x < framesAmount.x; x++)
        {
            sf::IntRect frame(x * frameSize.x, y * frameSize.y, frameSize.x, frameSize.y);
            frames.push_back(frame);
        }
    }
    setPosition(x, y);
    setTexture(texture);
    setTextureRect(frames[0]);
}

void player::update(bool &space, sound &sound, score &score, std::vector<platform> &level) {
    if(setBuff){
        float buffDuration = buffTimer.getElapsedTime().asSeconds();
        if(buffDuration >= 2.0f){
            setSpeed();
            setBuff = false;
        }
    }

    if(space && onGround) {
        velocity.y = jumpHeight * -1;
        sound.jumpSE();
        jumped = 1;
    }

    if(!onGround){
        velocity.y += accelGravity;
        if(velocity.y > maxGravity) velocity.y = maxGravity;
    }

    //Constantly Moving Right
    velocity.x = speed;
    onGround = false;

    //Collision Check on X & Y Axis separately; X first then Y
    move(velocity.x, 0);
    collisionCheck(velocity.x, 0, level, sound, score);

    move(0, velocity.y);
    collisionCheck(0, velocity.y, level, sound, score);
    animate();

    //Check landing sound after jump movement has occurred
    checkLand(sound);
}

void player::collisionCheck(float xMove, float yMove, std::vector<platform> &level, sound &sound, score &score) {
    for(int i = 0; i < level.size(); i++){
        if(getGlobalBounds().intersects(level[i].getGlobalBounds())){
            collision = true;
        }
        else collision = false;
        if(collision){
            //If Collision with Obstacle, Die
            if(level[i].getId() == 5){
                gamestate::setState(gamestate::GM_LOST);
            }
            //If Collision with Coin, Score++
            if(level[i].getId() == 3){
                sound.coinSE();
                class score bonus(1000);
                score += bonus;
                level.erase(level.begin() + i);
                continue;
            }
            //If Collision with Buff, Speed++ for few seconds
            if(level[i].getId() == 4){

                level.erase(level.begin() + i);
                setSpeed(4);
                sound.powerUpSE();
                setBuff = true;
                buffTimer.restart();
                continue;
            }
            //If Collision with Finishing Line, Win
            if(level[i].getId() == 9 ){
                if(!finish)
                    sound.finishSE();
                finish = true;

                gamestate::setState(gamestate::GM_WON);
                continue;
            }
            //Check for right movement collision
            if(xMove > 0){
                setPosition(level[i].getPosition().x - size.x, getPosition().y);
                velocity.x = 0;
            }
            //Check for downward movement collision
            if(yMove > 0){
                setPosition(getPosition().x, level[i].getPosition().y - size.y);
                velocity.y = 0;
                onGround = true;
            }
            //Check for upward movement collision
            if(yMove < 0){
                setPosition(getPosition().x, level[i].getPosition().y);
                velocity.y = 0;
            }
        }
    }
}

sf::Vector2f player::getSize(){
    return size;
};


void player::animate() {
    if (velocity.y < 0 || velocity.y > 0) {
        jumping();
    } else if (velocity.x > 0) {
        running();
    } else {
        idle();
    }
}

void player::running() {
    if (gamestate::getState() == gamestate::GM_GAMEPLAY || gamestate::getState() == gamestate::GM_WON){
        for(int i = 0; i < runFrames; i++)
            if (runningCounter == (i + 1) * walkSpeed)
                setTextureRect(frames[i + jumpFrames+idleFrames]);
        if(runningCounter == runFrames * walkSpeed){
            runningCounter = 0;
        }
        if(gamestate::getState() == gamestate::GM_PAUSE){
            runningCounter = 0;
        } else {
            runningCounter++;
        }
    }
}

void player::jumping() {
    if (gamestate::getState() == gamestate::GM_GAMEPLAY || gamestate::getState() == gamestate::GM_WON){
        for(int i = 0; i < jumpFrames-2; i++)
            if (jumpingCounter == (i + 1) * jumpSpeed)
                setTextureRect(frames[i + idleFrames ]);
        if(jumpingCounter == jumpFrames * jumpSpeed){
            jumpingCounter = 0;
        }
        jumpingCounter++;
    }
}

void player::idle() {
    if (gamestate::getState() == gamestate::GM_GAMEPLAY || gamestate::getState() == gamestate::GM_WON){
        for(int i = 0; i < idleFrames; i++)
            if (idleCounter == (i + 1) * idleSpeed)
                setTextureRect(frames[i]);
        if(idleCounter == idleFrames * idleSpeed){
            idleCounter = 0;
        }
        idleCounter++;
    }
}

void player::deathAnimation() {
    if(gamestate::getState() == gamestate::GM_LOST){
        for(int i = 0; i < deathFrames; i++)
            if (deathCounter == i * deathSpeed)
                setTextureRect(frames[i + runFrames + idleFrames + jumpFrames]);
        if(deathCounter == deathFrames * deathSpeed){
            dead = 1;
        }
        deathCounter++;
    }
}

void player::checkLand(sound &sound) {
    if(onGround && jumped) {
        sound.landSE();
        jumped = 0;
    }
}

void player::reset() {
    dead = 0;
    deathCounter = 0;
    setSpeed();
    onGround = false;
}

void player::setSpeed(){
    speed = 3.0f;
}

void player::setSpeed(float spd){
    this->speed = spd;
}


