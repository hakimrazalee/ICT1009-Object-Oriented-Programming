# Task 1

1. Create a class with the name Animal 
2. Create a constructor with arguments and declare variables name. age and color (for testing put names given in sample output). 
3. Declare a method greetings() inside the class. 
4. Declare a method printInfo() inside the class for printing out the name, age and color for an animal. 
5. Create the classes Dog, Cat, Duck, and Pig which inherit from Animal. 
6. Define constructors for all the subclasses and call the constructor of class Animal using super keyword in each of them.
7. Define greetings() method for each of the subclasses. Note that the greetings function will print out the sound variable for that animal. (sound like Meow Meow for cat and Quak Quak for duck) 
8. Create a public class Test, in its main(), create an Array list of supertype variable of class animal and refer to subtype object. (like in Human example in lectures) 
9. Using reference variable of class Animal, call the method greetings() of all subclasses. 
10. Print the info for all animals (For this you will have to override printInfo() in all subclasses. 11. Stop the program.

*Sample Output*
```Java
In animal constructor
In dog constructor
In animal constructor
In cat constructor
In animal constructor
In duck constructor
In animal constructor
In pig constructor
Dog Milo is 2 years old and is of Brown color Woof woof
Cat Whiskey is 3 years old and is of Brown color Meow
Duck Do is 1 years old and is of White color Quack
Pig Po is 10 years old and is of Pink color Oink

```

# Task 2

1. Start the program.
2. Create an abstract class with class name Shape.
3. Create a constructor with arguments and declare variables dim1, dim2 and PI.
4. Declare an abstract method getArea() inside the class.
5. Create the classes Rectangle, Triangle, Circle, and Ellipse to find the area. (You can implement the classes Square and Rectangle similar to the one shown in UML). Note that the formula to calculate the area of Ellipse is: PI*A*B where A and B are the semi-major axis of length and semi-minor axis of length (Use the value PI = 3.14).
6. Define abstract method getArea() inside the subclasses and call the constructor of class Shape using super keyword
7. In main(), create the objects for all classes and pass values to fields of constructors. (Rectangle:9,5 Triangle:10,8 Circle:5,5 Elipse:7,7 Square:6,6)
8. Create a reference variable figref for abstract class.
9. Using reference variable of class Shape, call the method getArea() of all subclasses
10. Print the areas for all shapes.
11. Stop the program.

*Sample Output*
```Java
Inside Area for Rectangle.
Area is 45.0
Inside Area for Triangle.
Area is 40.0
Inside Area for Circle.
Area is 78.5
Inside Area for Ellipse.
Area is 153.86
Inside Area for Square.
Area is 36.0
```

# Task 3

In this task, you will practice the use of abstract classes and interfaces together in one application. You will be creating your own Pizza with your choice of toppings. You need to implement the following steps:

1. Declare an interface Pizza, which will include one method to calculate the final cost of the Pizza. 
2. Next create an Abstract Class for Pizza Topping. A Pizza Topping will include a variable for storing the number of toppings. The class will include an abstract method for assigning toppings. It should also include a method for adding toppings 
3. Create a class Order Pizza which will include the Pizza interface and Pizza Topping Abstract class for completing your order. It will include a variable for number of slices. It will include a default constructor with default values (toppings:3, slices: 6). It will also include a parametrized constructor for assigning values to number of toppings and number of slices. It will include a method for placing the order 
4. Implement a Test public class to create your Pizza. See below for the expected sample output. 
5. Cost of pizza can be calculated by multiplying the number of slices with the number of toppings. Eg. If in the execution below, a pizza is being ordered with 3 slices and 4 toppings, the cost for it is 12. 
6. The assignToppings() is just printing out how many toppings will be put on the Pizza. 
7. The addToppings is just process of adding toppings on the Pizza (just printing +++++) 
8. The placeOrder(), calls the assignToppings() and calcualtePizzaCost() followed by baking the slices. Baking slices include adding topping one by one per slice.

*Sample Output*
```Java
Enter number of slices
3
Enter number of toppings
4
Placing Order
Putting 4 toppings
Processing Order
Cost of order:12
Baking slices
Adding topping on slice 1
----+++++----
Adding topping on slice 2
----+++++----
Adding topping on slice 3
----+++++----
Order Completed
```