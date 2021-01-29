# Task 1:

Inheritance enables you to define a general class (i.e., a superclass) and later extend it to more specialized classes (i.e., subclasses). In this task, you are going to practice how to adopt the inheritance in the program design.

Consider geometric objects. Suppose you want to design the classes to model geometric objects such as circles and rectangles

1. Geometric objects have many common properties and behaviors. They can be drawn in a certain color and be filled or unfilled. Thus, a general class GeometricObject can be used to model all geometric objects. This class contains the properties color and filled and their appropriate getter and setter methods. The class contains multiple constructors (same function name with different signatures: method overloading). The toString() method returns a string representation of the object.

2. Since a circle is a special type of geometric object, it shares common properties and methods with other geometric objects. Thus, it makes sense to define the Circle class that extends the GeometricObject class. A triangular arrow pointing to the superclass is used to denote the inheritance relationship between the two classes involved.

3. Likewise, Rectangle can also be defined as a subclass of GeometricObject. Figure 2 shows the relationship among these classes. A triangular arrow pointing to the superclass is used to denote the inheritance relationship between the two classes involved.

**In this task, you need to implement all these three classes. Additionally, create a public class, TestCircleRectangle with the main function**

The example execution is provided as follows: (there is no need to match the exact decimal point, the below example is to give an idea of the output should look like)

```Java
A circle created
The color is white
The radius is 1.0
The area is 3.141592653589793
The diameter is 2.0
A rectangle created
The area is 8.0
The perimeter is 12.0
```

# Task 2: 

You already worked with creating the Box and Ball classes in the lab exercise last week. Continuing the implementation, in this task implement the following: 

1. Like the last lab create a class for the Background which should contain three constant variables. Also define one default constructor which assigns values to all the four variables of the class (UML diagram below). The default values (640,480, Black, 30) 

2. Define class BallDisplay which inherits the Background class. Like the last lab it contains six variable attributes. The Ball class should include one default constructor which assigns default values to all the six variables of the class. The default values (10, 50, 20, White). Also, implement a parameterized constructor for the Ball class for assigning values to the variables. Use the “this” variable, to avoid any naming conflicts. The Ball class should also include two-method attributes, one for calculating ball centers and the second to calculate the ball size. 

3. Create a public class for drawing the background and ball on the screen. This class should include one BallDisplay object variable.
It should include a default constructor that includes :

```this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT))```

It should also implement the override function for paintComponent that was explained to you in the last lab. This class should include the “main” method.

4. In the main function, create three different balls golf ball (10, 50, 20, White), basket ball (50,80,180,Red) and volley ball (30,200,220,OffWhite)