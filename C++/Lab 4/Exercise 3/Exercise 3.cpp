#include <iostream>
using namespace std;
class Meal{
protected:
    int calories;
    string dish;
public:
    friend ostream& operator<<(ostream& out, const Meal& m);
    friend istream& operator>>(istream &in, Meal& m);
    Meal operator+(const Meal &m) const;
    Meal(int s = 0){
        this->calories = s;
    };

};
ostream& operator<<(ostream& out, const Meal& m) {
    out << m.dish << " contains " << m.calories << " calories." << endl;
    return out;
}
istream& operator>>(istream &in, Meal& m){
    cout << "Enter the dish: ";
    in >> m.dish;
    cout << "Enter the calories in kcal: ";
    in >> m.calories;
    return in;
}

Meal Meal::operator+(const Meal &m) const {
    return Meal(calories + m.calories);
}

int main() {
    int size = 3;
    Meal meal[3];
    Meal total;
    for(int i = 0 ; i < size; i++){
        cout << "Meal #"<< i+1 << endl;
        cin >> meal[i];
        total = total + meal[i];
    }
    cout << "\nSummary:"<<endl;
    for (int i = 0 ; i < size; i++){
        cout << meal[i];
    }
    cout << "Everything together" << total;
}
