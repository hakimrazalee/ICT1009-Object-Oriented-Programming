## Exercise 3: Operator Overloading 2

You (may) want to eat healthy and decide to keep a log of your meals and
calories consumed.

1. Create a Meal class with two fields: a string variable dish that holds
the name of the meal, and an integer variable calorie that holds the
kilocalorie count. Include a default constructor that initializes
calories to zero.

2. Include an overloaded output operator<<() to display a Meal’s values
as well as an overloaded input operator>>()that prompts the user to
enter the dish name and the corresponding calorie count for the dish.
(Note: These operators use built-in input/output stream objects as
drivers so they cannot be declared as member-functions.)

3. Include an overloaded operator+() to add two or more Meal objects.
Since the operator should allow chaining several objects, you must
assure that the return object is also a Meal.
(Note: May declare a temporary Meal object inside the operator.)

4. Write a main() function that declares an array meal[] for at least
three Meal objects as well as an additional Meal object called total.
Use a for-loop to initialize the array elements using the overloaded
input operator. Within the same for-loop you can also add up the array
meal objects to your total meal object using the overloaded add operator. Finally, print out all array objects as well as the total
object. An example output is shown below.

```C++
Meal #1
Enter the dish: Carrot
Enter calories in kcal: 36
Meal #2
Enter the dish: Cheesecake
Enter calories in kcal: 620
Meal #3
Enter the dish: Steak
Enter calories in kcal: 380

Summary:
Carrot contains 36 calories.
Cheesecake contains 620 calories.
Steak contains 380 calories.
Everything together contains 1036 calories.
```