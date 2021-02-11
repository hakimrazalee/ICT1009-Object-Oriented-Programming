# Task : Exception Handling

In this task, you are going to practice the exception handling. Assume that you need to write one class (i.e. named CircleWithException) to describe the circle object. In CircleWithException, you have to declare the variables and methods to fulfill the bellowing functionalities.

1. Design the method to set the radius of the circle.
2. Design the method to get the radius of the circle.
3. Design the method to get the area of the circle.
4. Design the method to get the diameter of the circle.

In the class, you need to check the validation of the data. If the data is not valid, you shall throw the corresponding exception. For example, if the radius is not a positive number, an IllegalArgumentException should be thrown. If the area is bigger than 1000, a general exception “Exception” should be thrown.

In the main function, you need to conduct the exception handling to catch the exceptions to secure your program when you input different radius values.

Create a circle for radius 5
Create a circle for radius 1000
Create a circle for radius -5

```Java
java.lang.Exception: area cannot be bigger than 1000
this is from finally
java.lang.IllegalArgumentException: Radius cannot be negative
this is from finally
```