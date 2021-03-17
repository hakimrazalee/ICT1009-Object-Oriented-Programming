#include <iostream>
using namespace std;
class Car{
protected:
    bool isIgnitionOn{};
    int speed{};
public:
    void turnIgnitionOn();
    void turnIgnitionOff();

    virtual void setSpeed(int);
    virtual void showCar();
};
class RaceCar : virtual public Car{
public:
    void setSpeed(int) override;
};

class Convertible : virtual public Car{
public:
    bool isTopUp{};
    void putTopUp();
    void putTopDown();
    void showCar() override;

};
class ConvertibleRaceCar : public RaceCar, public Convertible{
};

void Car::showCar() {
    if(!isIgnitionOn){
        cout << "Ignition is off. Speed is " << this->speed << "mph." << endl;
    } else if (isIgnitionOn){
        cout << "Ignition is on. Speed is " << this->speed << "mph." << endl;
    }
}
void Car::setSpeed(int a) {
    if(a > 65){
        this->speed = 65;
    } else if (a < 65 && a >= 0){
        this->speed = a;
    }}
void Car::turnIgnitionOff() {
    this->isIgnitionOn = false;
    setSpeed(0);
}
void Car::turnIgnitionOn() { this->isIgnitionOn = true;}

void Convertible::putTopUp() { this->isTopUp = true;}
void Convertible::putTopDown() { this->isTopUp = false;}
void Convertible::showCar() {
    Car::showCar();
    if(isTopUp){
        cout<< "Top is up." << endl;
    } else if (!isTopUp){
        cout<< "Top is down." << endl;
    }
}

void RaceCar::setSpeed(int a) {
    if (a > 200){
        this->speed = 200;
    } else if (a >= 0 && a <= 200){
        this->speed = a;
    }
}

// First Main
//int main() {
//    Car myCar;
//    myCar.turnIgnitionOn();
//    myCar.setSpeed(35);
//    myCar.showCar();
//    myCar.setSpeed(80);
//    myCar.showCar();
//    myCar.turnIgnitionOff();
//    myCar.showCar();
//
//    return 0;
//}

//Second Main
//int main() {
//    Convertible myCar;
//    myCar.turnIgnitionOn();
//    myCar.setSpeed(35);
//    myCar.putTopDown();
//    myCar.showCar();
//    myCar.setSpeed(80);
//    myCar.showCar();
//    myCar.putTopUp();
//    myCar.turnIgnitionOff();
//    myCar.showCar();
//
//    return 0;
//}

// Third Main
//int main(){
//    Car aCar;
//    RaceCar aRaceCar;
//    aCar.turnIgnitionOn();
//    aCar.setSpeed(100);
//    cout << "A car at 100 mph: ";
//    aCar.showCar();
//    aRaceCar.turnIgnitionOn();
//    aRaceCar.setSpeed(100);
//    cout << "A race car at 100 mph: ";
//    aRaceCar.showCar();
//
//}

//Fourth Main
//int main(){
//    ConvertibleRaceCar aCar;
//    aCar.turnIgnitionOn();
//    aCar.showCar();
//}

// Last Main
int main(){
    ConvertibleRaceCar aCar;
    aCar.turnIgnitionOn();
    aCar.setSpeed(30);
    aCar.putTopUp();
    cout << "Car set to 30 mph:" << endl;
    aCar.showCar();

    aCar.setSpeed(80);
    cout << "\nCar set to 80 mph with top down:" << endl;
    aCar.putTopDown();
    aCar.showCar();

    aCar.setSpeed(250);
    cout << "\nCar set to 250 mph with top up:" <<endl;
    aCar.putTopUp();
    aCar.showCar();
}