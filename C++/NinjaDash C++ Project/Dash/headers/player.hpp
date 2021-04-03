#ifndef DASH_PLAYER_HPP
#define DASH_PLAYER_HPP


#include <SFML/Graphics.hpp>
#include "entity.hpp"
#include "sound.hpp"
#include "score.hpp"
#include <vector>

class player : public entity{
    friend class Engine;
private:
    sf::Vector2f velocity;
    sf::Clock buffTimer;
    bool onGround;
    bool collision;
    bool setBuff;
    float speed;
    float jumpHeight;
    float accelGravity;
    float maxGravity;
    int attempt;
    int runningCounter, jumpingCounter, idleCounter, idleFrames, runFrames, jumpFrames, walkSpeed, jumpSpeed, idleSpeed;
    int deathCounter, deathFrames, deathSpeed;
    int dead, choice, mChoice, jumped;
    bool finish;

public:
    player(float x, float y, float width, float height, sf::Texture& texture);
    void update(bool &space, sound &sound, score &score, std::vector<platform> &level);
    void collisionCheck(float xMove, float yMove, std::vector<platform> &level, sound &sound, score &score);
    sf::Vector2f getSize() override;
    void running();
    void jumping();
    void idle();
    void animate();
    void deathAnimation();
    void reset();
    void checkLand(sound &sound);
    void setSpeed();
    void setSpeed(float speed);
};


#endif //DASH_PLAYER_HPP
