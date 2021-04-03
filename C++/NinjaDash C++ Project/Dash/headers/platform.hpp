#ifndef DASH_PLATFORM_HPP
#define DASH_PLATFORM_HPP

#include <SFML/Graphics.hpp>
#include <entity.hpp>

class platform : public entity{
private:
    int id;
public:
    platform(int id, float x, float y, float width, float height, sf::Texture& t);
    int getId();
    sf::Vector2f getSize() override;
};

#endif //DASH_PLATFORM_HPP
