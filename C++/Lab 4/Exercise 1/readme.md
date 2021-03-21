# Lab 4: Polymorphism

## Exercise 1: Friend Functions

1. Create both classes Box and Product with their data members as well as the setVolume and setDimensions functions. You don’t need to implement constructor.

2. Create a friend function checkSize which gets both a Box and a Product object as argument and returns a bool value. The function
shall return true if a product fits into the box (i.e., length * width * depth < volume) and false otherwise. (Hint: Forward declare 1 class.)

3. Write a main() function instantiates an object box and an object product and asks the user the input the box volume and product dimensions length, width, and depth, respectively. Use the function checkSize to test if the product fits into the box. The screenshots below show two possible outputs.

Output: 
```C++
Enter box volume: 100
Enter product lenght, width and depth: 5 5 5
Does the product fit in the box? (1 - yes, 0 - no): 0
PS C:\Users\xxx\desktop> ./lab
Enter box volume: 1000
Enter product lenght, width and depth: 5 5 5
Does the product fit in the box? (1 - yes, 0 - no): 1

```