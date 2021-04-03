#ifndef DASH_ENGINE_HPP
#define DASH_ENGINE_HPP

#include <SFML/Graphics.hpp>
#include <vector>
#include "platform.hpp"
#include "player.hpp"
#include "death.hpp"
#include "audio.hpp"
#include "sound.hpp"
#include "score.hpp"

static const sf::Vector2f PlayerSpawn = sf::Vector2f(200,-100);
static const sf::Vector2f FireSpawn = sf::Vector2f(-300,-60);
static const int mapH = 10;
static const int mapW = 80;

class Engine{
private:
    sf::Clock winTimer;
    sf::RenderWindow window;
    sf::Vector2f resolution;
    sf::View camera;
    const unsigned int FPS = 60;
public:
    Engine();
    void input(bool &space, sound &sound, player &Player);
    void draw(player &Player, death &Death, score &score, std::vector<platform> &level, sf::Texture &gameBackground, int (&mapLayout)[mapH][mapW], sf::Texture &objectText);
    void update(bool &space, player &Player, death &Death, std::vector<platform> &level, sound &sound, score &score, int (&mapLayout)[mapH][mapW], sf::Texture &objectText);
    // Main loop will be in the run function
    void run(bool &space, player &Player, death &Death, std::vector<platform> &level,
             audio &audio, sound &sound, score &score, int (&mapLayout)[mapH][mapW], sf::Texture &objectTex, sf::Texture &menuBackground, sf::Texture &gameBackground);
    void defeat(player &Player, death &Death, std::vector<platform> &level, sound &sound);
    void reset(player &Player, death &Death, std::vector<platform> &level,
               int (&mapLayout)[mapH][mapW], sf::Texture &objectTex, score &Score);
    void pauseDraw(player &Player, death &Death);
    void lostInput(player &Player, death &Death, std::vector<platform> &level,
    int (&mapLayout)[mapH][mapW], sf::Texture &objectTex, score &Score, sound &sound);
    void menuInput(player &Player, death &Death, std::vector<platform> &level, sound &sound);
    void menuDraw(player &Player, sf::Texture &menuBackground);
    void initialiseMap(int (&mapLayout)[mapH][mapW], std::vector<platform> &level,
                       sf::Texture &objectTex);
    void pauseInput(sound &sound);


};
#endif //DASH_ENGINE_HPP
