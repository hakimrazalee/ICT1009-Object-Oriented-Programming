#include <iostream>
#include "audio.hpp"
using namespace std;
audio::audio() {
    try{
        if(!menuMusicFile.openFromFile("../assets/music/menu.wav")){
            std::cout<< "Error: ";
            throw 404;
        }
    } catch (int error) {
        if(error == 404){
            cout << "The menu.wav audio file could not be played."<<endl;
        }
    }

    try{
        if(!playMusicFile.openFromFile("../assets/music/play.wav")){
            std::cout<< "Error: ";
            throw 505;
        }
    } catch (int error) {
        if(error == 505){
            cout << "The play.wav audio file could not be played."<<endl;
        }
    }

    try{
        if(!loseMusicFile.openFromFile("../assets/music/lost.wav")){
            std::cout<< "Error: ";
            throw 605;
        }
    } catch (int error) {
        if(error == 605){
            cout << "The lost.wav audio file could not be played."<<endl;
        }
    }

    try{
        if(!victoryMusicFile.openFromFile("../assets/music/victory.wav")){
            std::cout<< "Error: ";
            throw 707;
        }
    } catch (int error) {
        if(error == 707){
            cout << "The victory.wav audio file could not be played."<<endl;
        }
    }
}
void audio::menuMusic() {
    menuMusicFile.setLoop(true);
    menuMusicFile.play();
}

void audio::menuMusicStop() {
    menuMusicFile.stop();
}

void audio::playMusic() {
    playMusicFile.play();

}

void audio::playMusicStop(){
    playMusicFile.stop();
}

void audio::playMusicPause(){
    playMusicFile.pause();
}

void audio::loseMusic() {
    loseMusicFile.play();
}

void audio::loseMusicStop() {
    loseMusicFile.stop();
}

void audio::menuMusicPause() {
    menuMusicFile.pause();
}

void audio::victoryMusicPlay() {
    victoryMusicFile.setPlayingOffset(sf::seconds(0.5f));
    victoryMusicFile.play();
}

void audio::victoryMusicStop() {
    victoryMusicFile.stop();
}





