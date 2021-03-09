# Exercise 1

In this exercise, create a class with a constructor that sets default values that a user can override. Define class Pizza to contain 3 variable fields, 3 constant fields, and 3 functions. The constructor contains default values for each field within its argument list. After the class definition, provide values for the 3 class constants. Write the Pizza constructor, which assigns each constructor argument to the appropriate class field. Note that you can avoid naming conflicts by using “this” pointer.

Write functions displayValues() and setValues(). Write a main() function that tests the Pizza class.

Below are sample output screenshots depend on whether you use the default values for the constructor or change the values.

```C++
The standard pizza is: a 12 inch cheese pizza. Price $8.99
Let me take your order
Do you want the standard pizza - y or n? y
Your order is a 12 inch cheese pizza. Price $8.99

The standard pizza is: a 12 inch cheese pizza. Price $8.99
Let me take your order
Do you want the standard pizza - y or n? n
Enter topping banana
Enter size 14
Your order is a 14 inch banana pizza. Price $11.49
```

In a separate main() function, try to create Pizza objects that use all, some, or none of the constructor default values. Declare the different objects and display the different values.
