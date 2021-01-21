# Task 1: Loan Assignment

Consider getting a loan. A specific loan can be viewed as an object of a Loan class. The interest rate, loan amount, and loan period are its data properties, and computing the monthly payment and total payment are its methods. For example, when you buy a car, a loan object is created by instantiating the class with your loan interest rate, loan amount and loan period. You can then use the methods to find the monthly payment and total payment of your loan. Figure below indicates the Loan class UML for the Loan class.

For this task implement a Loan class with three variable attributes. The class also includes one default constructor and one parameterized constructor. Also define two method attributes for calculating the monthly and annual payment. Input the interest rate, the payment period (in years), and the loan amount. Create an object of the loan class using parameterized constructor in the main method. Use the “this” variable, to avoid any naming conflicts. Then obtain the monthly payment
ICT1009 Object-Oriented Programming AY2020/2021 P a g e | 2
and the total payment using the instance methods in the Loan class. The following formula can assistant to calculate the monthlyPayment and totalPayment:


>*monthlyPayment = (loanAmount x monthlyInterestRate)/(1-(1/((1+monthlyInterestRate)^numberOfYears x 12))*

>*totalPayment = monthlyPayment x numberOfYears x 12*

Please note that the annual interest rate is for the whole year and for monthly you will have to divide it by 12.

The running example is provided as follows:

```java
Enter annual interest rate, for example, 8.25:2.5
Enter number of years as an integer:5
Enter loan amount, for example, 120000. 95:1000
The loan was created:
The monthly payment is 17.75
The total payment is 1064.84

```

# Task 2: 

You already worked with creating a simple Ball in the lab exercise last week. Continuing the implementation, in this task implement the following:

1. Create a class for the Background which should contain three constant variables, one variable. Also define one default constructor which assigns values to all the four variables of the class (UML diagram below). The default values (640,480, Black, 30) 

2. Define class Ball with six variable attributes. The Ball class should include one default constructor which assigns default values to all the six variables of the class (UML diagram below). The default values (20, 50, 20, Cyan,). Also implement a parametrized constructor for the Ball class for assigning values to the variables. Use the “this” variable, to avoid any naming conflicts. The Ball class should also include a two method attributes, one for calculating ball centers and the second to calculate the ball size. 
3. Create a public class for drawing the Background and Ball on the screen. This class should include one Ball object variable and one Background object variable. It should include a default constructor which include

```java
this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT))
```

It should also implement the override function for paintComponent that was explained to you in the last lab. This class should include the “main” method.