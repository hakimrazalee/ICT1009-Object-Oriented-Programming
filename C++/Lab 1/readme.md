# Exercise 1: Input and Output

C++ I/O occurs in streams. The C++ iostream library provides hundreds of
I/O capabilities. To use it, you would have to include the <iostream>
which contains cin, cout, cerr, and clog objects, corresponding to the
standard input stream, standard output stream, unbuffered standard error
stream, and the buffered standard error stream, respectively.
Create a program that asks the user to enter an integer. If the integer
is less than 100, print the message “Too small.” If the integer is greater
than or equal to 100, print “Big enough.” 

Sample output is shown below.

```C++
Enter a number: 100
This number is big enough.
```

# Exercise 2: File

Generally, programs require to read and write outputs to a file. In this
section, we will learn how to do that in C++. The exercises at the end
of this section will help us better understand the topic.
C++ provides classes to perform output/input of characters to/from files:
- ofstream: stream class to write on files.
- ifstream: stream class to read from files.
- fstream: stream class to both read and write from/to files.

The following example demonstrates the typical use of ofstream. Test the
code to see what output you get. The program should create a file name
“example.txt” and inserts the word “Hello” into it.

```C++
#include <iostream>
#include <fstream>

using namespace std;

int main() {
    ofstream output_file;
    
    output_file.open("example.txt");
    output_file << "Hello";
    output_file.close();

    return 0;
}
```

(Note: File can be opened with different modes in file.open(name, mode).)
(Note: Opening a file consumes a substantial amount of system resources.
Remember to free the resources using file.close().)


**Task: Extend the above program to include error checking to verify that
the file has been opened successfully.**
