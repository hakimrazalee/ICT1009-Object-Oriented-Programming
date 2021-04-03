#include <iostream>

using namespace std;
template<class T>
class Array{
    T* data;
    int size;
public:
    Array(T* d, int s);
    void showList();
    void showFirst();
    void showLast();
};

template<class T>
Array<T>::Array(T *d, int s) {
    this->size = s;
    this->data = d;
}

template<class T>
void Array<T>::showList() {
    for(int i = 0; i < this->size ; i++){
        cout << data[i];
    }
}

template<class T>
void Array<T>::showFirst() {
    cout << data[0];
}

template<class T>
void Array<T>::showLast() {
    cout << data[this->size-1];
}

class Vehicle {
    friend ostream& operator<<(ostream&, const Vehicle&);

private:
    string name;
    double price;
public:
    void setVehicle(string,double);
};

ostream &operator<<(ostream &out, const Vehicle &v) {
    out << "This vehicle is called: " << v.name << ". Priced at $" << v.price<<"."<<endl;
    return out;
}

void Vehicle::setVehicle(string s, double d) {
    this->name = s;
    this->price = d;
}

int main() {
    Vehicle cars[3];
    cars[0].setVehicle("Ferari", 3242);
    cars[1].setVehicle("Honda", 2223);
    cars[2].setVehicle("Lamborghini", 10000);
    int arrayElements = sizeof(cars)/sizeof(cars[0]);
    Array<Vehicle> arrayOfVehicles(cars, arrayElements);
    cout << "Show all:" << endl;
    arrayOfVehicles.showList();
    cout << "\nShow first:" << endl;
    arrayOfVehicles.showFirst();
    cout << "\nShow last:" << endl;
    arrayOfVehicles.showLast();
}
