# Task 1: Conditional Constructs and Console I/O


## Chinese Zodiac Calculation. 
Now let us write a program to find out the Chinese Zodiac sign for a given year. The Chinese Zodiac is based on a twelve-year cycle, with each year represented by an animal- monkey, rooster, dog, pig, rat, ox, tiger, rabbit, dragon, snake, horse, or sheep—in this cycle.

Note that year **% 12** determines the Zodiac sign. 1900 is the year of the rat because **1900 % 12** is **4**. Listing **3.9** gives a program that prompts the user to enter a year and displays the animal for the year.
Read numbers from keyboard. Java provide APIs to read input from the keyboard. One of the most important API is the java.util.Scanner. 

You can use nextDouble() method in the Scanner class to read one double value and other methods to read different type of numbers.

***year % 12 = 0:monkey, 1:rooster, 2:dog, 3:pig, 4:rat, 5:ox, 6:tiger, 7:rabbit, 8:dragon, 9:snake, 10:horse, 11:sheep.***

**Test Case 1**
> Enter a year:  ***1963***

>rabbit

**Test Case 2** 

> Enter a year:  ***1877***

> ox

# Task 2: Repetition Constructs and Console I/O

# Body Mass Index (BMI)

Body Mass Index (BMI) is a measure of health based on height and weight. It can be calculated by taking your weight in kilogram and dividing it by the square of your height in meters. The interpretation of BMI for people 20 years or older is as follows:

BMI < 18.5     Underweight

18.5 <= BMI < 25.0  Normal

25.0 <= BMI < 30.0 Overweight

30.0 <= BMI    Obese

You need to implement one class called, BIM with all the properties and methods. Write a program that prompts the user to enter a weight in pounds and height in inches and displays the BMI. Note that one pound is 0.45359237 kilograms and one inch is 0.0254 meters. Please note, if your BMI is calculated to 20.95 for the following example is also correct.

**Test Case**
> Enter weight in pounds:***146***

> Enter height in inches:***70***

> The BMI is 20.95

> Normal

# Task 3: Test Ball

Output the following information on the console:
1. Print out the color of the ball
2. Print out the radius of the ball

The output looks like the following: 

```Java
The color of the ball:java.awt.Color[r=255,g=0,b=0] The radius of the ball:20.0
```