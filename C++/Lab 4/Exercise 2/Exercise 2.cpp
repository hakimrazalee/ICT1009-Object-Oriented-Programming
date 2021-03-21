#include <iostream>
#include <utility>
using namespace std;
class SailingBoat{
private:
    friend ostream& operator<<(ostream&, const SailingBoat&);
    string boatName;
    double distance;
public:
    SailingBoat(string name,double d){
        this->boatName = name;
        this->distance = d;
    };
    string getName();
    double operator/(SailingBoat);

};

string SailingBoat::getName() {
    return boatName;
}
double SailingBoat::operator/(const SailingBoat b) {
    double ratio;
    ratio = distance / b.distance;
    return ratio;
}
ostream& operator<<(ostream& out, const SailingBoat& b) {
    out << b.boatName << " sailed " << b.distance << " miles." << endl;
    return out;
}
int main() {
    SailingBoat boat1("Mermaid", 790);
    SailingBoat boat2("Poseidon", 920);
    double ratio;
    ratio = boat1/boat2;
    // First output: Mermaid covered 85.8696% of the distance of Poseidon
    cout<< boat1.getName() << " covered ";
    cout << (ratio * 100) << "% of the distance of ";
    cout << boat2.getName() << endl;

    // Next 2 outputs Mermaid sailed 790 miles
    cout << boat1;
    // Poseidon sailed 920 miles.
    cout << boat2;
}
