#ifndef DASH_ENTITY_HPP
#define DASH_ENTITY_HPP

#include <SFML/Graphics.hpp>


class entity : public sf::Sprite{
protected:
    sf::Vector2f size;
    sf::Vector2f frameSize, framesAmount;
    std::vector<sf::IntRect> frames;
public:
    virtual sf::Vector2f getSize() = 0;

};

#endif //DASH_ENTITY_HPP
