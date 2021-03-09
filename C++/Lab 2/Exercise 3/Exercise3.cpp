#include <iostream>
using namespace std;
class Account{
private:
    int id;
    int balance;
public:
    Account(int id, int balance){
        this->id = id;
        if (balance < 0){
            this->balance = 0;
            cout << "Error: Negative Balance detected. Balance set to 0."<< endl;
        } else if (balance >= 0){
            this->balance = balance;
        }

    }
    void credit(int amount){
        if (amount < 0){
            cout << "Error: Negative Amount detected. Amount set to 0."<< endl;
            this->balance = this->balance + 0;
        } else if (amount >=0){
            this->balance = this->balance + amount;
        }
    };

    void debit(int amount){
        cout << "Attempting to subtract " << amount << " from Account "<< this->id <<" balance."<< endl;
        if(amount > this->balance){
            cout << "Error: debit amount exceeds account balance." << endl;
        } else if (this->balance >= amount){
            this->balance = this->balance - amount;
        }

    };

    void getBalance() const{
      cout << "Account " << this->id << " Balance: "<< this->balance<<endl;
    };
};
int main() {
    int input;
    cout << "Enter Account 1 Balance: ";
    cin >> input;
    Account account1 = Account(1,input);
    cout << "Enter Account 2 Balance: ";
    cin >> input;
    Account account2 = Account(2,input);
    cout << "Enter Withdraw Amount (int) from Account 1: ";
    cin >> input;
    account1.debit(input);
    account1.getBalance();
    account2.getBalance();
    cout << "Enter Withdraw Amount (int) from Account 2: ";
    cin >> input;
    account2.debit(input);
    account1.getBalance();
    account2.getBalance();
    cout << "==================================================" << endl;
    cout << "Enter Deposit Amount (int) to Account 1: ";
    cin >> input;
    account1.credit(input);
    account1.getBalance();
    account2.getBalance();
    cout << "Enter Deposit Amount (int) to Account 2: ";
    cin >> input;
    account2.credit(input);
    account1.getBalance();
    account2.getBalance();
}
