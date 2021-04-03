#include "score.hpp"


int score::getScore() {
    return points;
}

void score::scoreInc() {
    points++;
}

score &score::operator+=(const score &Score) {
    this->points = (this->points + Score.points);
    return *this;
}

score::score() { };

score::score(int Score) {
    points = Score;
}

void score::scoreReset() {
    points = 0;
}

void score::setScore(score a) {
    points = a.getScore();
}

ostream &operator<<(ostream &out, const score &s) {
    out << "[LOG] New highscore saved in session: " << s.points << "." << endl;
    return out;
}


