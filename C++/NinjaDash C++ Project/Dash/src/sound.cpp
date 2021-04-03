#include <iostream>
#include "sound.hpp"

sound::sound() {

    try{
        if(!buttonNavSoundBuffer.loadFromFile("../assets/sounds/button.wav")){
            std::cout<< "Error: ";
            throw 222;
        } else {
            buttonNavSound.setBuffer(buttonNavSoundBuffer);
        }
    } catch (int error) {
        if(error == 222){
            std::cout << "The button.wav audio file could not be played."<<std::endl;
        }
    }

    try{
        if(!selectSoundBuffer.loadFromFile("../assets/sounds/select.wav")){
            std::cout<< "Error: ";
            throw 222;
        } else {
            selectSound.setBuffer(selectSoundBuffer);
        }
    } catch (int error) {
        if(error == 222){
            std::cout << "The button.wav audio file could not be played."<<std::endl;
        }
    }

    try{
        if(!jumpSoundBuffer.loadFromFile("../assets/sounds/jump.wav")){
            std::cout<< "Error: ";
            throw 222;
        } else {
            jumpSound.setBuffer(jumpSoundBuffer);
        }
    } catch (int error) {
        if(error == 222){
            std::cout << "The button.wav audio file could not be played."<<std::endl;
        }
    }

    try{
        if(!landSoundBuffer.loadFromFile("../assets/sounds/land.wav")){
            std::cout<< "Error: ";
            throw 222;
        } else {
            landSound.setBuffer(landSoundBuffer);
        }
    } catch (int error) {
        if(error == 222){
            std::cout << "The button.wav audio file could not be played."<<std::endl;
        }
    }

    try{
        if(!hitSoundBuffer.loadFromFile("../assets/sounds/hit.wav")){
            std::cout<< "Error: ";
            throw 222;
        } else {
            hitSound.setBuffer(hitSoundBuffer);
        }
    } catch (int error) {
        if(error == 222){
            std::cout << "The button.wav audio file could not be played."<<std::endl;
        }
    }

    try{
        if(!pauseSoundBuffer.loadFromFile("../assets/sounds/pause.wav")){
            std::cout<< "Error: ";
            throw 222;
        } else {
            pauseSound.setBuffer(pauseSoundBuffer);
        }
    } catch (int error) {
        if(error == 222){
            std::cout << "The button.wav audio file could not be played."<<std::endl;
        }
    }

    try{
        if(!powerUpSoundBuffer.loadFromFile("../assets/sounds/powerup.wav")){
            std::cout<< "Error: ";
            throw 222;
        } else {
            powerUpSound.setBuffer(powerUpSoundBuffer);
        }
    } catch (int error) {
        if(error == 222){
            std::cout << "The button.wav audio file could not be played."<<std::endl;
        }
    }

    try{
        if(!coinSoundBuffer.loadFromFile("../assets/sounds/coin.wav")){
            std::cout<< "Error: ";
            throw 222;
        } else {
            coinSound.setBuffer(coinSoundBuffer);
        }
    } catch (int error) {
        if(error == 222){
            std::cout << "The button.wav audio file could not be played."<<std::endl;
        }
    }

    try{
        if(!finishSoundBuffer.loadFromFile("../assets/sounds/finish.wav")){
            std::cout<< "Error: ";
            throw 222;
        }else {
            finishSound.setBuffer(finishSoundBuffer);
        }
    } catch (int error) {
        if(error == 222){
            std::cout << "The button.wav audio file could not be played."<<std::endl;
        }
    }
}

void sound::selectSE() {
    selectSound.play();
}

void sound::buttonSE() {
    buttonNavSound.play();
}

void sound::jumpSE() {
    jumpSound.play();
}

void sound::landSE() {
    landSound.play();
}

void sound::hitSE() {
    hitSound.play();
}

void sound::pauseSE() {
    pauseSound.play();
}

void sound::powerUpSE() {
    powerUpSound.play();
}

void sound::coinSE() {
    coinSound.play();
}

void sound::finishSE() {
    finishSound.play();
}

