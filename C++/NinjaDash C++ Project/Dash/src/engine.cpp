#include <iostream>
#include "engine.hpp"
#include "platform.hpp"
#include "player.hpp"
#include "gamestate.hpp"

const static float HEIGHT = 600;
const static float WIDTH = 1500;
bool hit_playing = false;
bool muted = false;
bool restart = false;
bool quit = false;
bool newRecord = false;
int winFlag = 0 ;
score hScore;

Engine::Engine() {
    resolution = sf::Vector2f (WIDTH, HEIGHT);
    window.create(sf::VideoMode(resolution.x, resolution.y), "Ninja Dash", sf::Style::Close);
    window.setFramerateLimit(FPS);

}
/// Game Loop
void Engine::run(bool &space, player &Player, death &Death, std::vector<platform> &level,
                 audio &audio, sound &sound, score &score, int (&mapLayout)[mapH][mapW], sf::Texture &objectTex,
                 sf::Texture &menuBackground, sf::Texture &gameBackground) {
    bool menuSongPlaying = false;
    bool playSongPlaying = false;
    bool loseSongPlaying = false;
    bool victorySongPlaying = false;

    // Main Game Loop - Runs until the window is closed
    while(window.isOpen()){
        if(gamestate::getState() == gamestate::GM_MENU){
            if(muted){
                audio.loseMusicStop();
                audio.victoryMusicStop();
                audio.menuMusicPause();
                hit_playing = false;
                menuSongPlaying = false;
                playSongPlaying = false;
                loseSongPlaying = false;
                victorySongPlaying = false;
            } else {
                if(!menuSongPlaying){
                    audio.victoryMusicStop();
                    hit_playing = false;
                    audio.loseMusicStop();
                    audio.playMusicStop();
                    audio.menuMusic();
                    menuSongPlaying = true;
                    playSongPlaying = false;
                    loseSongPlaying = false;
                    victorySongPlaying = false;
                }
            }

            menuDraw(Player, menuBackground);
            menuInput(Player, Death, level, sound);
        } else if(gamestate::getState() == gamestate::GM_GAMEPLAY){
            winFlag = 0;
            if(muted){
                hit_playing = false;
                menuSongPlaying = false;
                playSongPlaying = false;
                loseSongPlaying = false;
                victorySongPlaying = false;
            } else {
                if(!playSongPlaying){
                    hit_playing = false;
                    audio.playMusic();
                    audio.loseMusicStop();
                    audio.menuMusicStop();
                    victorySongPlaying = false;
                    menuSongPlaying = false;
                    playSongPlaying = true;
                    loseSongPlaying = false;
                }
            }
            input(space, sound, Player);
            update(space, Player, Death,level, sound, score,mapLayout, objectTex);
            draw(Player, Death, score, level, gameBackground, mapLayout, objectTex);
        } else if(gamestate::getState() == gamestate::GM_PAUSE){
            if(restart == 1){
                if(!muted){
                    audio.playMusicStop();
                    audio.playMusic();
                }
                reset(Player, Death, level, mapLayout, objectTex, score);
                gamestate::setState(gamestate::GM_GAMEPLAY);
                restart = false;
            }
            if(quit){
                gamestate::setState(gamestate::GM_MENU);
                reset(Player, Death, level, mapLayout, objectTex, score);
                quit = false;
            }
            audio.playMusicPause();
            playSongPlaying = false;
            pauseInput(sound);
            pauseDraw(Player, Death);
        } else if(gamestate::getState() == gamestate::GM_LOST){
            if(muted){
                loseSongPlaying = false;
                menuSongPlaying = false;
                playSongPlaying = false;
                victorySongPlaying = false;
            } else {
                if(!loseSongPlaying){
                    if(Player.dead == 1){
                        audio.loseMusic();
                        loseSongPlaying = true;

                    }
                    audio.playMusicStop();
                    audio.menuMusicStop();
                    victorySongPlaying = false;
                    menuSongPlaying = false;
                    playSongPlaying = false;
                }
            }
            defeat(Player, Death,level, sound);
            if(Player.dead == 1){
                lostInput(Player, Death, level, mapLayout, objectTex, score, sound);
            }
        } else if(gamestate::getState() == gamestate::GM_WON){
            if(restart == 1){
                audio.victoryMusicStop();
                reset(Player, Death, level, mapLayout, objectTex, score);
                gamestate::setState(gamestate::GM_GAMEPLAY);
                restart = false;
            }
            if(quit){
                gamestate::setState(gamestate::GM_MENU);
                reset(Player, Death, level, mapLayout, objectTex, score);
                quit = false;
            }
            if(muted){
                loseSongPlaying = false;
                menuSongPlaying = false;
                playSongPlaying = false;
            } else {
                if(!victorySongPlaying){
                    audio.loseMusicStop();
                    audio.playMusicStop();
                    audio.menuMusicStop();
                    audio.victoryMusicPlay();
                    victorySongPlaying = true;
                    loseSongPlaying = false;
                    menuSongPlaying = false;
                    playSongPlaying = false;
                }
            }
                update(space, Player, Death,level, sound, score, mapLayout, objectTex);
                draw(Player, Death, score, level, gameBackground,mapLayout, objectTex);
                pauseInput(sound);
         }
    }
}

/// Game Engine Functions
void Engine::update(bool &space, player &Player, death &Death, std::vector<platform> &level, sound &sound,
                    score &score, int (&mapLayout)[mapH][mapW], sf::Texture &objectTex) {
    Player.update(space, sound, score, level);
    Death.update(Player);
    if(gamestate::getState() != gamestate::GM_WON){
        score.scoreInc();
    }
}
void Engine::draw(player &Player, death &Death, score &score, std::vector<platform> &level,
                  sf::Texture &gameBackground,int (&mapLayout)[mapH][mapW], sf::Texture &objectTex ) {
    window.clear(sf::Color::Black);
    sf::Font font;
    sf::Text scoreDisplay, highscoreDisplay, attemptDisplay, newHscore, congratsText, qquit, rretry, time;
    sf::Sprite gameBGSprite;
    sf::RectangleShape winOverlay;

    if(!font.loadFromFile("../assets/fonts/Ninja.ttf")){
        throw ("Could not load font!");
    }


    if(gamestate::getState() == gamestate::GM_WON){
        if(winFlag == 0){
            camera.setCenter(Player.getPosition().x + Player.getSize().x / 2,
                             Player.getPosition().y + Player.getSize().y / 2);
            winTimer.restart();
            winFlag = 1;
        }
        int winTime = (int)winTimer.getElapsedTime().asSeconds();
        if( winTime >= 30){
            reset(Player, Death, level, mapLayout, objectTex, score);
            gamestate::setState(gamestate::GM_MENU);

        }



        scoreDisplay.setString("Score: " + std::to_string(score.getScore()));
        scoreDisplay.setFont(font);
        scoreDisplay.setCharacterSize(50);
        scoreDisplay.setFillColor(sf::Color::White);
        scoreDisplay.setPosition(camera.getViewport().left+580,camera.getViewport().top+330);

        congratsText.setString("You Win!");
        congratsText.setFont(font);
        congratsText.setCharacterSize(100);
        congratsText.setFillColor(sf::Color::Yellow);
        congratsText.setPosition(camera.getViewport().left + 520,camera.getViewport().top+ 120);

        qquit.setString("Q-quit");
        qquit.setFont(font);
        qquit.setCharacterSize(20);
        qquit.setFillColor(sf::Color::Yellow);
        qquit.setPosition(camera.getViewport().left + 710,camera.getViewport().top+ 400);

        rretry.setString("R-retry");
        rretry.setFont(font);
        rretry.setCharacterSize(20);
        rretry.setFillColor(sf::Color::Yellow);
        rretry.setPosition(camera.getViewport().left + 710,camera.getViewport().top+ 430);

        time.setString(std::to_string(30 - winTime));
        time.setFont(font);
        time.setCharacterSize(20);
        time.setFillColor(sf::Color::White);
        time.setPosition(camera.getViewport().left + 740,camera.getViewport().top+ 460);

        winOverlay.setSize(sf::Vector2f(500, 400));
        winOverlay.setOutlineThickness(5);
        winOverlay.setPosition(camera.getViewport().left+ 500,camera.getViewport().top+ 100);
        winOverlay.setFillColor(sf::Color::Black);
        winOverlay.setOutlineColor(sf::Color::Blue);


        if (score.getScore() > hScore.getScore()){
            hScore.setScore(score);
            std::cout << hScore;
            newRecord = true;
        }

        if(newRecord){
            newHscore.setString("New Highscore! \n\n");
            newHscore.setFont(font);
            newHscore.setCharacterSize(50);
            newHscore.setFillColor(sf::Color::Red);
            newHscore.setPosition(camera.getViewport().left + 555,camera.getViewport().top + 270);


        }





    } else {
        camera.setCenter(Player.getPosition().x + Player.getSize().x / 2,
                         Player.getPosition().y + Player.getSize().y / 2);

        scoreDisplay.setString("Score: " + std::to_string(score.getScore()));
        scoreDisplay.setFont(font);
        scoreDisplay.setOutlineColor(sf::Color::Black);
        scoreDisplay.setOutlineThickness(1);
        scoreDisplay.setCharacterSize(35);
        scoreDisplay.setFillColor(sf::Color::White);
        scoreDisplay.setPosition(camera.getViewport().left,camera.getViewport().top);

        highscoreDisplay.setString("Highscore: " + std::to_string(hScore.getScore()));
        highscoreDisplay.setFont(font);
        highscoreDisplay.setOutlineColor(sf::Color::Black);
        highscoreDisplay.setOutlineThickness(1);
        highscoreDisplay.setCharacterSize(35);
        highscoreDisplay.setFillColor(sf::Color::White);
        highscoreDisplay.setPosition(camera.getViewport().left,camera.getViewport().top+35);

    }

    attemptDisplay.setString("Attempt: " + std::to_string(Player.attempt));
    attemptDisplay.setFont(font);
    attemptDisplay.setCharacterSize(24);
    attemptDisplay.setFillColor(sf::Color::Black);
    attemptDisplay.setPosition(PlayerSpawn.x + 150,PlayerSpawn.y + 150);


    gameBGSprite.setTexture(gameBackground);
    gameBGSprite.setPosition(PlayerSpawn.x - 220, PlayerSpawn.y - 100);
    gameBGSprite.setTextureRect(sf::IntRect(0,0,3200,1280));

    //Place draw() after setView(Camera) for stuff before moving parts
    camera.setSize(resolution.x / 3, resolution.y / 3);
    window.setView(camera);
    window.draw(gameBGSprite);
    if(Player.attempt > 0 ){
        window.draw(attemptDisplay);
    }
    window.draw(Player);

    for(platform &p : level) window.draw(p);
    window.draw(Death);

    //Place draw() after setView(defaultView) for GUI-like parts
    window.setView(window.getDefaultView());
    window.draw(winOverlay);
    window.draw(scoreDisplay);
    window.draw(highscoreDisplay);
    window.draw(congratsText);
    window.draw(qquit);
    window.draw(rretry);
    window.draw(time);
    if (gamestate::getState() == gamestate::GM_WON && newRecord){
        window.draw(newHscore);
    }

    window.display();
}
void Engine::input(bool &space, sound &sound, player &Player){
    sf::Event event;
    sf::Mouse::getPosition();
    while(window.pollEvent(event)){
        //window closed
        if(event.type == sf::Event::Closed){
            window.close();
        }

        // Handle Keyboard Input
        if (event.type == sf::Event::KeyPressed){
            //Quit
            if(gamestate::getState() == gamestate::GM_GAMEPLAY){
                if(sf::Keyboard::isKeyPressed(sf::Keyboard::Escape)){
                    sound.pauseSE();
                    gamestate::setState(gamestate::GM_PAUSE);
                }
            }
        }


        space = sf::Keyboard::isKeyPressed(sf::Keyboard::Space);

    }
}
void Engine::reset(player &Player, death &Death, std::vector<platform> &level,
                   int (&mapLayout)[mapH][mapW], sf::Texture &objectTex, score &Score) {
    Player.attempt += 1;
    Player.mChoice = 4;
    Player.finish = false;
    Player.reset();
    newRecord = false;
    level.clear();
    Score.scoreReset();
    initialiseMap(mapLayout, level,objectTex);
    window.setView(window.getDefaultView());
    Death.setPosition(FireSpawn);
    Player.setPosition(PlayerSpawn);
}

/// After Game Over
void Engine::defeat(player &Player, death &Death, std::vector<platform> &level, sound &sound){
    sf::Font font;
    if(!font.loadFromFile("../assets/fonts/Ninja.ttf")){
        throw ("Could not load font!");
    }
    sf::Text GameOver;

    if(!hit_playing){
        sound.hitSE();
        hit_playing = true;
    }

    GameOver.setFont(font);
    GameOver.setString("GAME OVER!");
    GameOver.setFillColor(sf::Color::Red);
    GameOver.setCharacterSize(50);
    GameOver.setStyle(sf::Text::Bold);
    GameOver.setPosition(Player.getPosition().x - 105, Player.getPosition().y - 60);

    sf::Text cont;
    cont.setFont(font);
    cont.setString("CONTINUE?");
    cont.setFillColor(sf::Color::Green);
    cont.setCharacterSize(20);
    cont.setStyle(sf::Text::Bold);
    cont.setPosition(Player.getPosition().x - 30, Player.getPosition().y + 80);

    sf::RectangleShape yes;
    sf::RectangleShape no;

    sf::Text yesText;
    yesText.setString("Yes");
    yesText.setFont(font);
    yesText.setCharacterSize(32);
    yesText.setPosition(Player.getPosition().x - 160 , Player.getPosition().y + 25 );

    sf::Text noText;
    noText.setString("No");
    noText.setFont(font);
    noText.setCharacterSize(32);
    noText.setPosition(Player.getPosition().x + 160 , Player.getPosition().y + 25 );

    window.clear(sf::Color::Black);
    camera.setCenter(Player.getPosition().x + Player.getSize().x / 2, Player.getPosition().y + Player.getSize().y / 2);
    camera.setSize(resolution.x / 3, resolution.y / 3);
    window.setView(camera);
    Player.deathAnimation();

    if(Player.dead == 1){
        if(Player.choice == 1){
            yesText.setFillColor(sf::Color::Yellow);
            noText.setFillColor(sf::Color::White);
        } else if (Player.choice == 0){
            noText.setFillColor(sf::Color::Yellow);
            yesText.setFillColor(sf::Color::White);
        }

        window.draw(GameOver);
        window.draw(cont);
        window.draw(yesText);
        window.draw(noText);
    }
    window.draw(Player);
    window.display();
}
void Engine::lostInput(player &Player, death &Death, std::vector<platform> &level,
                       int (&mapLayout)[mapH][mapW], sf::Texture &objectTex, score &Score, sound &sound) {
    sf::Event event;
    while(window.pollEvent(event)) {
        //window closed
        if (event.type == sf::Event::Closed) {
            window.close();
        }

        // Handle Keyboard Input
        if (event.type == sf::Event::KeyPressed) {
            //Quit


            if(sf::Keyboard::isKeyPressed(sf::Keyboard::A) || sf::Keyboard::isKeyPressed(sf::Keyboard::Left)){
                sound.buttonSE();
                Player.choice = 1;
            }

            if(sf::Keyboard::isKeyPressed(sf::Keyboard::D) || sf::Keyboard::isKeyPressed(sf::Keyboard::Right)){
                sound.buttonSE();
                Player.choice = 0;
            }

            if(sf::Keyboard::isKeyPressed(sf::Keyboard::Enter) || sf::Keyboard::isKeyPressed(sf::Keyboard::Space)){
                sound.selectSE();
                if (Player.choice == 1){
                    Player.dead = 0;
                    reset(Player, Death, level, mapLayout, objectTex, Score);
                    gamestate::setState(gamestate::GM_GAMEPLAY);
                } else if (Player.choice == 0){
                    reset(Player, Death, level, mapLayout, objectTex, Score);
                    gamestate::setState(gamestate::GM_MENU);
                }
            }


        }
    }
}

/// Pause Functions
void Engine::pauseDraw(player &Player, death &Death){
//    window.clear(sf::Color::Transparent);
    window.setView(camera);
    sf::RectangleShape blackBox;
    blackBox.setSize(sf::Vector2f(480, 180));
    blackBox.setFillColor(sf::Color::White);
    blackBox.setPosition(Player.getPosition().x - 210, Player.getPosition().y - 60);
    window.draw(blackBox);

    blackBox.setSize(sf::Vector2f(460, 160));
    blackBox.setFillColor(sf::Color::Black);
    blackBox.setPosition(Player.getPosition().x - 200, Player.getPosition().y - 50);
    window.draw(blackBox);


    sf::Font font;
    if(!font.loadFromFile("../assets/fonts/Ninja.ttf")){
        throw ("Could not load font!");
    }

    sf::Text ptext;
    ptext.setString("PAUSED");
    ptext.setFont(font);
    ptext.setFillColor(sf::Color::White);
    ptext.setCharacterSize(64);
    ptext.setPosition(Player.getPosition().x - 80, Player.getPosition().y - 40);
    window.draw(ptext);

    sf::Text escText;
    escText.setString("(Press ESC to resume)");
    escText.setFont(font);
    escText.setFillColor(sf::Color::Red);
    escText.setCharacterSize(10);
    escText.setPosition(Player.getPosition().x - 20 , Player.getPosition().y + 90);
    window.draw(escText);

    sf::Text quitText;
    quitText.setString("Q - Quit to Main Menu");
    quitText.setFont(font);
    quitText.setFillColor(sf::Color::Yellow);
    quitText.setCharacterSize(14);
    quitText.setPosition(Player.getPosition().x - 45 , Player.getPosition().y + 50);
    window.draw(quitText);

    sf::Text retry;
    retry.setString("R - Restart Level");
    retry.setFont(font);
    retry.setFillColor(sf::Color::Yellow);
    retry.setCharacterSize(14);
    retry.setPosition(Player.getPosition().x - 30 , Player.getPosition().y + 30);
    window.draw(retry);

    window.display();

}
void Engine::pauseInput(sound &sound){
    sf::Event event;
    while(window.pollEvent(event)) {
        //window closed
        if (event.type == sf::Event::Closed) {
            window.close();
        }

        // Handle Keyboard Input
        if (event.type == sf::Event::KeyPressed) {
            //Quit

            if (sf::Keyboard::isKeyPressed(sf::Keyboard::Escape) && gamestate::getState() == gamestate::GM_PAUSE) {
                sound.pauseSE();
                gamestate::setState(gamestate::GM_GAMEPLAY);
            }
            if (sf::Keyboard::isKeyPressed(sf::Keyboard::R)) {
                sound.selectSE();
                restart = true;
            }
            if (sf::Keyboard::isKeyPressed(sf::Keyboard::Q)) {
                sound.selectSE();
                quit = true;
            }
        }
    }
}

/// Menu Functions
void Engine::menuInput(player &Player, death &Death, std::vector<platform> &level, sound &sound){

    sf::Event event;

    while(window.pollEvent(event)){
        //window closed
        if(event.type == sf::Event::Closed){
            window.close();
        }

        // Handle Keyboard Input
        if (event.type == sf::Event::KeyPressed){

            if(sf::Keyboard::isKeyPressed(sf::Keyboard::A) || sf::Keyboard::isKeyPressed(sf::Keyboard::Left)){
                sound.buttonSE();
                if(Player.mChoice == 1){
                    Player.mChoice = 0;
                } else if(Player.mChoice == 2){
                    Player.mChoice = 1;
                } else if(Player.mChoice == 0){
                    Player.mChoice = 0;
                } else {
                    Player.mChoice = 1;
                }

            }

            if(sf::Keyboard::isKeyPressed(sf::Keyboard::D) || sf::Keyboard::isKeyPressed(sf::Keyboard::Right)){
                sound.buttonSE();
                if(Player.mChoice == 1){
                    Player.mChoice = 2;
                } else if(Player.mChoice == 0){
                    Player.mChoice = 1;
                } else if(Player.mChoice == 2){
                    Player.mChoice = 2;
                } else {
                    Player.mChoice = 1;
                }
            }
            if(sf::Keyboard::isKeyPressed(sf::Keyboard::Enter) || sf::Keyboard::isKeyPressed(sf::Keyboard::Space) ){


                if(Player.mChoice == 0){
                    sound.selectSE();

                    if(muted){
                        cout<<"[LOG] Game Unmuted." << endl;
                        muted = false;
                    } else if (!muted){
                        cout<<"[LOG] Game Muted." << endl;
                        muted = true;
                    }

                } else if (Player.mChoice == 1){
                    sound.selectSE();
                    gamestate::setState(gamestate::GM_GAMEPLAY);
                } else if (Player.mChoice == 2){
                    sound.selectSE();
                    cout<<"[LOG] Game Closed." << endl;
                    window.close();
                }
            }


        }
    }
}
void Engine::menuDraw(player &Player, sf::Texture &menuBackground){

    window.clear(sf::Color::Black);
    window.setView(window.getDefaultView());
    sf::Font font;
    if(!font.loadFromFile("../assets/fonts/Ninja.ttf")){
        throw ("Could not load font!");
    }

    sf::Text title;
    sf::Text titleOverlay;
    sf::Text play;
    sf::Text mute;
    sf::Text quitText;

    title.setFont(font);
    titleOverlay.setFont(font);
    play.setFont(font);
    mute.setFont(font);
    quitText.setFont(font);

    title.setString("NINJA DASH!");
    titleOverlay.setString("NINJA DASH!");
    titleOverlay.setCharacterSize(110);
    title.setCharacterSize(104);

    play.setString("PLAY");
    play.setCharacterSize(90);

    if(muted){
        mute.setString("UNMUTE");
        mute.setCharacterSize(70);
        mute.setPosition((WIDTH / 2) - 630 , 330 );
    } else {
        mute.setString("MUTE");
        mute.setCharacterSize(90);
        mute.setPosition((WIDTH / 2) - 620 , 320 );
    }


    quitText.setString("QUIT");
    quitText.setCharacterSize(90);

    play.setFillColor(sf::Color::White);
    play.setStyle(sf::Text::Bold);
    play.setPosition((WIDTH/2)- 115 ,320 );

    mute.setFillColor(sf::Color::White);
    mute.setStyle(sf::Text::Bold);


    quitText.setFillColor(sf::Color::White);
    quitText.setStyle(sf::Text::Bold);
    quitText.setPosition((WIDTH/2)+380 ,320 );

    title.setFillColor(sf::Color::Black);
    title.setStyle(sf::Text::Bold);
    titleOverlay.setFillColor(sf::Color::White);
    title.setStyle(sf::Text::Bold);
    title.setPosition((WIDTH/2) - 300 ,30 );
    titleOverlay.setPosition((WIDTH/2) - 310 ,30 );

    sf::RectangleShape button1(sf::Vector2f(300.f,150.f));
    sf::RectangleShape button2(sf::Vector2f(300.f,150.f));
    sf::RectangleShape button3(sf::Vector2f(300.f,150.f));

    button1.setFillColor(sf::Color::Black);
    button1.setPosition(WIDTH/2 - 650,300);
    button2.setFillColor(sf::Color::Black);
    button2.setPosition(WIDTH/2 - 150,300);
    button3.setFillColor(sf::Color::Black);
    button3.setPosition(WIDTH/2 + 350,300);

    if(Player.mChoice == 0){
        button1.setFillColor(sf::Color::White);
        mute.setFillColor(sf::Color::Black);
    } else if (Player.mChoice == 1){
        button2.setFillColor(sf::Color::White);
        play.setFillColor(sf::Color::Black);
    } else if (Player.mChoice == 2){
        button3.setFillColor(sf::Color::White);
        quitText.setFillColor(sf::Color::Black);
    }

    // Button
    sf::Sprite backgroundSprite;

    backgroundSprite.setTexture(menuBackground);
    backgroundSprite.setTextureRect(sf::IntRect(0,0,1500,600));
    backgroundSprite.setPosition(0,0);

    window.draw(backgroundSprite);
    window.draw(button1);
    window.draw(button2);
    window.draw(button3);
    // Text
    window.draw(titleOverlay);
    window.draw(title);
    window.draw(play);
    window.draw(mute);
    window.draw(quitText);
    window.display();
}

void Engine::initialiseMap(int (&mapLayout)[mapH][mapW], std::vector<platform> &level,
                                 sf::Texture &objectTex) {
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
}


