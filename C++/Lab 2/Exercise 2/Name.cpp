#ifndef NAME_CPP
#define NAME_CPP

#include "Name.h"

Name::Name(string first, string last) {
    this->first = first;
    this->last = last;
}

void Name::displayFullName() {
    cout << first << " " << last << endl;
}

#endif
