#ifndef DASH_SOUND_HPP
#define DASH_SOUND_HPP
#include <SFML/Audio.hpp>

class sound {
private:
    sf::SoundBuffer buttonNavSoundBuffer;
    sf::SoundBuffer selectSoundBuffer;
    sf::SoundBuffer jumpSoundBuffer;
    sf::SoundBuffer landSoundBuffer;
    sf::SoundBuffer hitSoundBuffer;
    sf::SoundBuffer pauseSoundBuffer;
    sf::SoundBuffer powerUpSoundBuffer;
    sf::SoundBuffer coinSoundBuffer;
    sf::SoundBuffer finishSoundBuffer;
public:
    sf::Sound buttonNavSound;
    sf::Sound selectSound;
    sf::Sound jumpSound;
    sf::Sound landSound;
    sf::Sound hitSound;
    sf::Sound pauseSound;
    sf::Sound powerUpSound;
    sf::Sound coinSound;
    sf::Sound finishSound;

    void buttonSE();
    void selectSE();
    void jumpSE();
    void landSE();
    void hitSE();
    void pauseSE();
    void powerUpSE();
    void coinSE();
    void finishSE();

public:
    sound();

};


#endif //DASH_SOUND_HPP
