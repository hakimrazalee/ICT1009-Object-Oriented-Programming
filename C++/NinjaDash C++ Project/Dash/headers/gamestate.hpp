#ifndef DASH_GAMESTATE_HPP
#define DASH_GAMESTATE_HPP


#include <SFML/Window.hpp>
#include <SFML/Graphics/RenderWindow.hpp>

class gamestate {
public:

    enum Gamemode{
        GM_MENU,
        GM_GAMEPLAY,
        GM_PAUSE,
        GM_LOST,
        GM_WON
    };
    static Gamemode getState();
    static void setState(Gamemode state);
};


#endif //DASH_GAMESTATE_HPP
