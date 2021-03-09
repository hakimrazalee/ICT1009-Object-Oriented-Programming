//
// Created by hakim on 10/3/2021.
//

#ifndef INC_1009L2E2_NAME_H
#define INC_1009L2E2_NAME_H

#endif //INC_1009L2E2_NAME_H
// non-standard but widely supported preprocessor directive designed to cause the current source file to be included only once in a single compilation.
#pragma once

// prevents double declaration of any identifiers such as types, enums and static variables.
#include <string>
#include <iostream>

using namespace std;

class Name {
private:
    string first;
    string last;
public:
    Name(string, string);
    void displayFullName();
};

