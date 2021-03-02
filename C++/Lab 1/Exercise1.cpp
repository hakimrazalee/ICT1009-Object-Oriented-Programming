#include <iostream>
using namespace std;
int main() {
    int x;
    std::cout << "Enter a number: ";
    std::cin >> x;

    if(x < 100){
        std::cout << "This number is too small." << std::endl;
    } else if (x >= 100){
        std::cout << "This number is big enough." << std::endl;
    }
    return 0;
}



