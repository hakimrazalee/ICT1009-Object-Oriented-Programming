#include <iostream>
using namespace std;
class Inventory{
private:
    int stock;
    int quantity;
    double price;
public:
    Inventory(int, int, double);
    void setAllToZero();
    friend ostream& operator<<(ostream&, const Inventory&);
    friend istream& operator>>(istream&, Inventory&);
};

Inventory::Inventory(int s, int q, double d ) {
    this->stock = s;
    this->quantity = q;
    this->price = d;
}

void Inventory::setAllToZero() {
    this->price = 0;
    this->quantity = 0;
    this->stock = 0;
}

ostream &operator<<(ostream &out, const Inventory &inv) {
    out << "Stock:"<<inv.stock << ". Quantity:" << inv.quantity << ". Price:$"<<inv.price<<endl;
    return out;
}

istream &operator>>(istream &in, Inventory &inv) {

    cout << "Enter stock amount:";
    try {
        string error = "Stock number out of range!";
        in >> inv.stock;
        if (inv.stock < 1 || inv.stock > 9999){
            throw(error);
        }
    }
    catch (const string msg) {
        cout<< msg << endl;
    }

    cout << "Enter quantity:";
    try{
        in >> inv.quantity;
        if(inv.quantity < 0){
            throw(inv.quantity);
        }

    }
    catch (const int quantity){
        cout << "The quantity is "<<quantity<<endl;
    }

    cout << "Enter price:";
    try{
        in >> inv.price;
        if(inv.price > 1000.0){
            throw (inv.price);
        }
    }
    catch(const double price){
        cout << "The price is $" << price << endl;
    }

    return in;
}


int main() {
    Inventory inv(0,0,0);
    inv.setAllToZero();
    cin >> inv;
    cout << endl;
    cout << inv;
    return 0;
}
