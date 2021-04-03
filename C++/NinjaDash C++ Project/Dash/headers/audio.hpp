#ifndef DASH_AUDIO_HPP
#define DASH_AUDIO_HPP
#include <SFML/Audio.hpp>

class audio {

public:
    audio();
    sf::Music menuMusicFile;
    sf::Music playMusicFile;
    sf::Music loseMusicFile;
    sf::Music victoryMusicFile;
    void menuMusic();
    void playMusic();
    void loseMusic();
    void menuMusicStop();
    void loseMusicStop();
    void playMusicStop();
    void playMusicPause();
    void menuMusicPause();
    void victoryMusicPlay();
    void victoryMusicStop();
};


#endif //DASH_AUDIO_HPP
