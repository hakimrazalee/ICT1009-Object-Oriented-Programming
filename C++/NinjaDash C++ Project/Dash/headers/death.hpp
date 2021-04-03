#ifndef DASH_DEATH_HPP
#define DASH_DEATH_HPP

#include <SFML/Graphics.hpp>
#include "entity.hpp"
#include "sound.hpp"
#include "platform.hpp"
#include "player.hpp"


class death : public entity{
    friend class Engine;
private:
    sf::Vector2f velocity;
    float speed;
    int fireCounter, fireFrames, fireSpeed;
public:
    death(float x, float y, float width, float height, sf::Texture& texture);
    void update(player &Player);
    void collisionCheck(player &Player);
    void animate();
    sf::Vector2f getSize() override;
};

#endif //DASH_DEATH_HPP
