#include <gamestate.hpp>
#include "platform.hpp"

platform::platform(int id, float x, float y, float width, float height, sf::Texture &texture) {

    this->id = id;
    size.x = width;
    size.y = height;

    setPosition(x, y);
    setTexture(texture);


    if(id == 1){
        setTextureRect( sf::IntRect(0,0,40,40));
    }
    else if(id == 2){
        setTextureRect( sf::IntRect(40,0,40,40));
    }
    else if(id == 3){
        setTextureRect( sf::IntRect(0,72,22,22));
    }
    else if(id == 4){
        setTextureRect( sf::IntRect(0,42,32,30));
    }
    else if(id == 5){
        setTextureRect(sf::IntRect(32,42,30,10));
    }
    else if(id == 9){
        setTextureRect(sf::IntRect(80,0,91,48));
    }
}

int platform::getId() {
    return id;
}

sf::Vector2f platform::getSize(){
    return size;
};