#include "gamestate.hpp"


gamestate::Gamemode currentState = gamestate::GM_MENU;

gamestate::Gamemode gamestate::getState() {
    return currentState;
}

void gamestate::setState(gamestate::Gamemode state) {
    currentState = state;

}

