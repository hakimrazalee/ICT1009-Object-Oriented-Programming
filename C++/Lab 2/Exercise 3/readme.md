Exercise 3

Create an Account class that uses a data member of type int to represent the account balance. Provide a constructor that receives an initial balance to initialize the data member. The constructor should validate the initial balance to ensure that it is greater than or equal to 0. If not, it should set the balance to 0 and display an error message indicating that the initial balance was invalid. 

The class should also include 3 member functions:
- The member function credit() is used to add an amount to the current balance.
- The member function debit() is used to deduct money from Account and ensure that the debit amount does not exceed the Account’s balance. If the debit amount is greater than the Account balance, the balance should be left unchanged and the function should print an error message indicating that the debit amount exceeds the account balance.
- The member function getBalance() should return the current balance.

Write a main function that creates two different Account objects and test the different member functions.

Sample execution outputs are as follows. Notice the error prompt when the withdrawal amount is greater than the account balance in the second printout.

```C++
Account 1 Balance: 600
Account 2 Balance: 100
Enter withdraw amount (int) from Account 1: 100
Attempting to subtract 100 from Account 1 balance
Account 1 Balance: 500
Account 2 Balance: 100
Enter withdraw amount (int) from Account 2: 100
Attempting to subtract 100 from Account 2 balance
Account 1 Balance: 500
Account 2 Balance: 0



Account 1 Balance: 600
Account 2 Balance: 100
Enter withdraw amount (int) from Account 1: 1
Attempting to subtract 100 from Account 1 balance
Account 1 Balance: 599
Account 2 Balance: 100
Enter withdraw amount (int) from Account 2: 200
Attempting to subtract 100 from Account 2 balance
Error: debit amount exceeds account balance.
Account 1 Balance: 599
Account 2 Balance: 100
```