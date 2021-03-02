#include <iostream>
#include <fstream>

using namespace std;

int main() {
    ofstream output_file;
    try{
//        throw "test run";                         //Throws a test exception (To simulate Errors)
        output_file.open("example.txt");         //Consumes a substantial amount of system resources
        output_file <<"Hello";
        output_file.close();                        //To free resources
        cout << "File opened successfully.";
    } catch (...){                                  //catch (...) handles all kinds of exception.
        cout << "File opening failed!" << endl;
    }


    return 0;
}
