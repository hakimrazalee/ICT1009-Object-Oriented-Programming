#include "engine.hpp"

int main(){
    audio audio;
    sound sound;
    score score;
    sf::Texture playerTex;
    sf::Texture objectTex;
    sf::Texture deathTex;
    sf::Texture menuBackground;
    sf::Texture gameBackground;
    std::vector<platform> level;
    bool space;
    playerTex.loadFromFile("../rsrc/images/player.png");
    objectTex.loadFromFile("../rsrc/images/objectSprites.png");
    deathTex.loadFromFile("../rsrc/images/fire.png");
    menuBackground.loadFromFile("../rsrc/backgrounds/background.png");
    gameBackground.loadFromFile("../rsrc/backgrounds/gameBackground.png");

    player Player(PlayerSpawn.x,PlayerSpawn.y,60,58,playerTex);
    death Death(FireSpawn.x,FireSpawn.y,375,480,deathTex);

    int mapLayout[mapH][mapW] = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,3,0,0,0,4,0,0,5,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,2,0,0,0,2,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,3,1,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,2,2,0,5,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,1,2,2,2,1,3,0,0,0,5,0,0,0,0,1,0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,9,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,1,1,1,1,0,0,0,3,0,0,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,5,5,5,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
    };

    for(int y = 0; y < mapH; y++){
        for(int x = 0; x < mapW; x++){
            //Grassy Platform
            if(mapLayout[y][x] == 1){
                platform p(1,x * 40, y * 40, 40, 40, objectTex);
                level.push_back(p);
            }
            //Dirt Platform
            if(mapLayout[y][x] == 2){
                platform p(2,x * 40, y * 40, 40, 40, objectTex);
                level.push_back(p);
            }
            //Coin Object
            if(mapLayout[y][x] == 3){
                platform p(3,x * 40 + 10, y * 40 + 10, 20, 20, objectTex);
                level.push_back(p);
            }
            //Ramen Object
            if(mapLayout[y][x] == 4){
                platform p(4,x * 40 + 5, y * 40 + 5, 30, 30, objectTex);
                level.push_back(p);
            }
            //Spike Object
            if(mapLayout[y][x] == 5){
                platform p(5,x * 40 + 5, y * 40 + 15, 30, 10, objectTex);
                level.push_back(p);
            }
            //Finish Line
            if(mapLayout[y][x] == 9){
                platform p(9,x * 40, y * 40, 90, 40, objectTex);
                level.push_back(p);
            }
        }
    }

    Engine engine;
    engine.run(space, Player, Death, level, audio, sound, score, mapLayout, objectTex, menuBackground, gameBackground);

    return 0;
}