# C++ Lab 5: Templates and Exceptions 
# Exercise 1:

An array is a list of same-type objects at adjacent memory locations.
There are many standard operations performed on arrays, no matter what
type is involved. For example, whether we are working with integers,
characters, or classes, we usually want to store and display array data.
Class templates offer the perfect way to create generic functions that
accomplish these tasks for any type of array. Here, let us complete the
following tasks.
1. Create a generic Array class (as shown below) with two private fields:
a pointer to the beginning of the array, and an integer representing
the size of the array. The public functions include 1) a constructor
and member functions that 2) show every element in the Array and 3)
show the first Array element only.

```C++
template<class T>
class Array {
   T* data; 
   int size;
public:
   Array(T* d, int s); 
   void showList(); 
   void showFirst(); 
   void showLast();
};
```
2. Create a Vehicle class (as shown below) which contains some private
data, a function that sets values, and an overloaded insertion
operator. (Any type of object that will be stored in the Array class
must be able to be displayed using the << operator, if the Array
functions showList() and showFirst() are used.)

```C++
class Vehicle {
   friend ostream& operator<<(ostream&, const Vehicle&);
private:
   string name;
   double price;
public:
   void setVehicle(string, double);
};
```
3. Test the program using a main function (e.g., such as the one below).
Note that, instead of hard-coding the number of array elements, you
can calculate it by dividing the size of an array in bytes by the size
of one array element in bytes using the sizeof() function.

```C++
Vehicle cars[2];
cars[0].setVehicle("McQueen", 6666);
cars[1].setVehicle("Mater", 8888);
int arrayElements = sizeof(cars) / sizeof(cars[0]);
Array<Vehicle> arrayOfVehicles(cars, arrayElements);
arrayOfVehicles.showList();
arrayOfVehicles.showFirst();
```

4. If you want, you can add own functions, i.e., showLast(), and alter
the existing ones to gain some more experience with templates.

# Exercise 2:

1. Declare a class Inventory,
where function setAllToZero
simply sets the three data
members to 0.

```
-------------------------------------------------------------------------------------
-stock: int                                                                         
-quantity: int
-price: double
-------------------------------------------------------------------------------------
+ Inventory(int, int, double)
+ setAllToZero(): void
<<friend>> operator<<(ostream&, const Inventory&): ostream&
<<friend>> opeartor>>(istream&, Inventory&): istream&
--------------------------------------------------------------------------------------
```
2. Implement an overloaded output operator (<<) to
print the data members’ values.
3. Implement an overloaded input operator (>>) to read the data member
values. Also, the overloaded input operator throws 3 exceptions:

- The error message: “Stock number out of range!”, if the stock
is less than 1 or higher than 999
-  The value of the quantity variable if it is less than 0
-  The value of the price variable if it is over 1000.0
4. Test your code in main function. An example execution is shown below.
``` c++
try { cin >> item[x]; }
catch (const string msg) {???}
catch (const int quantity) {???}
catch (const double price) {???}
```