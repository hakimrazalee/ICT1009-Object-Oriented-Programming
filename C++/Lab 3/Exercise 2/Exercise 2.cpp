#include <iostream>

using namespace std;
class Package {


private:
    struct Address {
        string name;
        string street;
        string city;
        string country;
        int postal;
    };
    Address sender;
    Address recipient;
    double costPerKg;

protected:
    double weight;
public:
    virtual double calculateCost() {
        return weight * costPerKg;
    };
    string getSenderName() const{
        return sender.name;
    }
    string getSenderAddress() const{
        return sender.street + ", " + sender.city + ", " + sender.country;
    }
    string getRecipientName() const{
        return recipient.name;
    }
    string getRecipientAddress() const{
        return recipient.street + ", " + recipient.city + ", " + recipient.country;
    }
    Package(string sname, string scity,
            string scountry, int spostal,
            string sstreet, string rname,
            string rcountry, string rcity,
            string rstreet, int rpostal, double weight, double costPerKg) {
        sender.name = sname;
        sender.city = scity;
        sender.country = scountry;
        sender.postal = spostal;
        sender.street = sstreet;

        recipient.name = rname;
        recipient.street = rstreet;
        recipient.postal = rpostal;
        recipient.country = rcountry;
        recipient.city = rcity;

        if (weight > 0.0 && costPerKg > 0.0) {
            this->weight = weight;
            this->costPerKg = costPerKg;
        }

    }
};

class TwoDayPackage : public Package{
public:
    TwoDayPackage(string sname, string scity, string scountry, int spostal, string sstreet, string rname,
                  string rcountry, string rcity, string rstreet, int rpostal, double weight, double costPerKg, double flatFee)
            : Package(sname, scity, scountry, spostal, sstreet, rname, rcountry, rcity, rstreet, rpostal, weight, costPerKg) {
        this->flatFee = flatFee;
    }
    double flatFee;
    double calculateCost() override;
};

double TwoDayPackage::calculateCost() {
    return Package::calculateCost() + flatFee;
}

class OvernightPackage : public Package{
public:

    OvernightPackage(string sname, string scity, string scountry, int spostal, string sstreet, string rname,
            string rcountry, string rcity, string rstreet, int rpostal, double weight, double costPerKg, double feePerKg)
    : Package(sname, scity, scountry, spostal, sstreet, rname, rcountry, rcity, rstreet, rpostal, weight, costPerKg) {
        this->feePerKg = feePerKg;
    }
    double feePerKg;
    double calculateCost() override;
};

double OvernightPackage::calculateCost() {
    return Package::calculateCost() + (weight * feePerKg);
}

int main() {
    Package pk1("Bruce Lee","Hong Kong",
                "China", 12345,
                "1 Fighting Rd", "Alice Wong",
                "Singapore", "Jurong",
                "Jurong Ave 1", 23456, 8.5, 0.5);

    TwoDayPackage pk2("Donald Trump","Washington",
                "USA", 34567,
                "1600 Pennsylvania Ave", "Barack Obama",
                "USA", "Washington",
                "21 Democracy St", 45678, 10.5, 0.65, 2.0);

    OvernightPackage pk3("Lee Hsien Loong","CBD",
                         "Singapore", 56789,
                         "1 Parlament Pl", "Bob Tan",
                         "Singapore", "Yishun",
                         "Yishun Ave 1", 67891, 12.25, 0.7, 0.25);

    cout << "Package 1:" << endl;
    cout << "Sender: " << pk1.getSenderName() << endl;
    cout << pk1.getSenderAddress()<<endl;
    cout << "Recipient: " << pk1.getRecipientName() << endl;
    cout <<pk1.getRecipientAddress()<<endl;
    cout << "Cost: " << pk1.calculateCost() << endl;

    cout << "\nPackage 2:" << endl;
    cout << "Sender: " << pk2.getSenderName() << endl;
    cout << pk2.getSenderAddress()<<endl;
    cout << "Recipient: " << pk2.getRecipientName() << endl;
    cout <<pk2.getRecipientAddress()<<endl;
    cout << "Cost: " << pk2.calculateCost() << endl;

    cout << "\nPackage 2:" << endl;
    cout << "Sender: " << pk3.getSenderName() << endl;
    cout << pk3.getSenderAddress()<<endl;
    cout << "Recipient: " << pk3.getRecipientName() << endl;
    cout <<pk3.getRecipientAddress()<<endl;
    cout << "Cost: " << pk3.calculateCost() << endl;
}
