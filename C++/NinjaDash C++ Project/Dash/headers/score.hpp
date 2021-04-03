#ifndef DASH_SCORE_HPP
#define DASH_SCORE_HPP
#include <SFML/System.hpp>
using namespace std;
class score{
private:
    int points = 0;
public:
    void scoreReset();
    void scoreInc();
    int getScore();
    score();
    score(int Score);
    score &operator+=(const score &Score);
    friend ostream &operator<<(ostream&, const score&);
    void setScore(score);
};

#endif //DASH_SCORE_HPP
