//
// Created by hakim on 10/3/2021.
//

#ifndef INC_1009L2E2_CREDITDATA_H
#define INC_1009L2E2_CREDITDATA_H

#endif //INC_1009L2E2_CREDITDATA_H
#pragma once

#include <iostream>

using namespace std;

class CreditData {
private:
    double currentBalance;
    double maxBalance;
public:
    CreditData(double, double = 0);
    void displayCreditData();
};