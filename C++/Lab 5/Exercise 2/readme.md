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