# Exercise 2

In this exercise, we learn how to implement compositions. We make use of two existing classes Name and CreditData to build a Customer class that contains objects of type Name and CreditData. You can find the class definition headers (.h files) and implementation (.cpp files) for Name and CreditData in the lab folder. You need to download all the files and include them when creating the new Customer class.

Add a main() function to demonstrate the correct class implementation. The main() function loops TIMES (where you can adjust the value of TIMES constant). At each iteration, the function prompts you for customer data, creates a Customer object, and displays it.

Compile and execute the program. Your output should look similar to the following. Test out the values and see the difference when the maximum is greater than the balance.

Sample:
```C++
Please enter first name for Customer #1 Wei
Please enter last name Zheng
Enter current balance 666
Enter credit limit 888
Enter phone number 65921111
Customer data:
Wei Zhang
65921111
Current balance: $666
Maximum balance $888
Credit left: $222

Please enter first name for Customer #2 Tony
Please enter last name Stark
Enter current balance 666666666
Enter credit limit 888888888
Customer data:
Tony Stark
11116592
Current balance: $6.66667e+08
Maximum balance $8.88889e+08
Credit left: $2.22222e+08
```