#ifndef CREDIT_CPP
#define CREDIT_CPP

#include "CreditData.h"

CreditData::CreditData(double currBal, double maxBal) {
    currentBalance = currBal;
    if(maxBal < currBal)
        maxBalance = currBal;
    else
        maxBalance = maxBal;
}

void CreditData::displayCreditData() {
    double creditLeft = maxBalance - currentBalance;
    cout << "Current balance: $" << currentBalance << "\nMaximum balance $" << maxBalance << "\nCredit left: $" << creditLeft << endl;
}

#endif