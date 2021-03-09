#include <iostream>
/* In this exercise, create a class with a constructor that sets default values that a user can override.
 * Define class Pizza to contain 3 variable fields, 3 constant fields, and 3 functions.
 * The constructor contains default values for each field within its argument list.
 * After the class definition, provide values for the 3 class constants.
 * Write the Pizza constructor, which assigns each constructor argument to the appropriate class field.
 * Note that you can avoid naming conflicts by using “this” pointer.*/
using namespace std;
class Pizza{
private:
    string topping;
    int diameter;
    double price;
    const static string STDTOP;
    const static int STDSIZE;
    const static double STDPRICE;
public:
    Pizza(const string = STDTOP, const int = STDSIZE, const double = STDPRICE);
    void setValues();
    void displayValues();
};

const string Pizza::STDTOP = "Cheese";
const int Pizza::STDSIZE = 12;
const double Pizza::STDPRICE = 8.99;

Pizza::Pizza(const string topping, const int diameter, const double price) {
    this->topping = topping;
    this->diameter = diameter;
    this->price = price;
}

void Pizza::setValues() {
    const double TOPPINGPREMIUM = 1.00;
    const double SIZEPREMIUM = 1.50;
    cout << "Enter topping: ";
    cin >> topping;
    if (topping != STDTOP)
        price = STDPRICE + TOPPINGPREMIUM;
    cout << "Enter size: ";
    cin >> diameter;
    if(diameter > STDSIZE)
        price += SIZEPREMIUM;
}

void Pizza::displayValues() {
    cout << "a " << diameter << " inch " << topping << " pizza. Price: $" << price << endl;
}

//int main(){
//    Pizza aPizza;
//    string standard;
//    cout << "The standard pizza: ";
//    aPizza.displayValues();
//    cout << "Let me take your order" << endl;
//    cout << "Do you want the standard pizza - Yes or No? ";
//    cin >> standard;
//    if(standard != "y" || standard != "Yes")
//        aPizza.setValues();
//    cout<< "Your order is ";
//    aPizza.displayValues();
//    return 0;
//
//}

int main(){
    Pizza normalPizza;
    Pizza basicPizza("Pepperoni", 10, 10);
    Pizza mystery("Orange");
    Pizza largeSpecial("Hotdog", 14);
    Pizza kingSpecial("Meatzza", 20, 59.99);


    cout << "Normally we have ";
    normalPizza.displayValues();
    cout << "But today the basic pizza is ";
    basicPizza.displayValues();
    cout << "We also have this mystery pizza which is ";
    mystery.displayValues();
    cout << "If you are not a fan of that, we do have ";
    largeSpecial.displayValues();
    cout << "We also have ";
    kingSpecial.displayValues();

    return 0;

}