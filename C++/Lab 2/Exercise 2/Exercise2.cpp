#include <iostream>
#include "Name.h"
#include "CreditData.h"
using namespace std;

/* In this exercise, we learn how to implement compositions.
 * We make use of two existing classes Name and CreditData to build a Customer class that contains objects
 * of type Name and CreditData. You can find the class definition headers (.h files) and
 * implementation (.cpp files) for Name and CreditData in the lab folder.
*/


class Customer {
private:
    Name name;
    CreditData credit;
    string phoneNumber;
public:
    Customer(string, string, double, double, string);
    void showCustomer();
};

Customer::Customer(string firstName, string lastName,double bal, double max, string phoneNumber): name(firstName, lastName), credit(bal,max)
{
    this->phoneNumber = phoneNumber;
}

void Customer::showCustomer() {
    cout << "\nCustomer data:" << endl;
    name.displayFullName();
    cout << phoneNumber << endl;
    credit.displayCreditData();
}

int main() {
    int x;
//    const int TIMES = 2;
    int times;
    string first, middle, last, phone;
    double bal, lim;
    cout<< "\nHow many customers are there?";
    cin >> times;
    for (x = 0; x < times; x++){
        cout << "\nEnter first name for customer #" << (x + 1) << ": ";
        cin >> first;
        cout << "Enter customer's last name: ";
        cin >> last;
        cout << "Enter customer's current balance: ";
        cin >> bal;
        cout << "Enter customer's credit limit: ";
        cin >> lim;
        cout << "Enter customer's phone number: ";
        cin >> phone;
        Customer cust(first, last, bal, lim, phone);
        cust.showCustomer();
    }
    return 0;
}
