#include "death.hpp"
#include <gamestate.hpp>

death::death(float x, float y, float width, float height, sf::Texture& texture) {
    speed = 3.0f;
    size.x = width;
    size.y = height;

    frameSize.x = 380;
    frameSize.y = 480;
    framesAmount.x = texture.getSize().x / frameSize.x;
    framesAmount.y = texture.getSize().y / frameSize.y;

    fireCounter = 0;
    fireSpeed = 3;
    fireFrames = 9;

    // Increment each row first.
    for(int y = 0; y < framesAmount.y; y++){
        for(int x = 0 ; x < framesAmount.x; x++)
        {
            sf::IntRect frame(x * frameSize.x, y * frameSize.y, frameSize.x, frameSize.y);
            frames.push_back(frame);
        }
    }
    setTextureRect(frames[0]);
    setPosition(x, y);
    setTexture(texture);
}

void death::update(player &Player) {
    velocity.x = speed;
    move(velocity.x, 0);
    collisionCheck(Player);
    animate();
}

void death::collisionCheck(player &Player) {
    //If Collision with Fire, Die
    if(getGlobalBounds().intersects(Player.getGlobalBounds())){
        if(gamestate::getState() == gamestate::GM_GAMEPLAY)
            gamestate::setState(gamestate::GM_LOST);

    }
}

void death::animate() {
    if (gamestate::getState() == gamestate::GM_GAMEPLAY || gamestate::getState() == gamestate::GM_WON){
        for(int i = 0; i < fireFrames; i++)
            if (fireCounter == (i + 1) * fireSpeed)
                setTextureRect(frames[i]);
        if(fireCounter == fireFrames * fireSpeed){
            fireCounter = 0;
        }

        fireCounter++;
    }
}

sf::Vector2f death::getSize(){
    return size;
};