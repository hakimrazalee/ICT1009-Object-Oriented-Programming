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

## Exercise 2: Operator Overloading 1

We practice operator overloading in this exercise. Please overload the
division operator (/) and the output operator (<<). Try to understand
the steps, especially about the declarations and definitions of the
operator overloading functions.

1. Declare a SailingBoat class. A SailingBoat has two private data members, boatName and distance. The class has a constructor that initializes the SailingBoat data fields. Declare a getName() function to return the object name as well as an overloaded operator/() function for the division operator so that later you can easily determine the distance ratio of two SailingBoat objects.

2. Implement the constructor of SailingBoat which assigns provided values
for the two data members. Also implement the getName() function which
simply returns the boatName data member.

3. The operator/() function divides the covered distance of one
SailingBoat by the distance covered by another SailingBoat. The ratio
is of type double, so the return type for operator/() must be a double.
It is important that the distance of this object is divided by the
distance of the parameter object so that the division works as
expected. The overloaded operator function should look as follows:
```C++
double SailingBoat::operator/(SailingBoat boat) {
   double ratio;
   ratio = distance / boat.distance;
   return ratio;
}
```

4. Add a main() function which declares two SailingBoat objects, boat1
and boat2, and then compares their distances. The ratio shall be
displayed in percentage.

5. Next, overload the output operator for the SailingBoat class to print
the class data in a natural fashion. Since a built-in output stream
object will become the driving object, the corresponding overloaded
parameter function must be declared as friend. For this the prototype
below must be inserted in the SailingBoat class. The corresponding
function definition could look as follows.

```C++
class SailingBoat {
   friend ostream& operator<<(ostream&, const SailingBoat&);

.
.
.

ostream& operator<<(ostream& out, const SailingBoat& b) {
   out << b.boatName << " sailed " << b.distance << " miles." << endl;
   return out;
}
int main() {
   SailingBoat boat1("Mermaid", 790);
   SailingBoat boat2("Poseidon", 920);
   double ratio;
   ratio = boat1 / boat2;
   cout << boat1.getName() << " covered ";
   cout << (ratio * 100) << "% of the distance of ";
   cout << boat2.getName() << endl;
   cout << boat1;
   cout << boat2;
```

Sample Output:
```C++
Mermaid covered 85.8696% of the distance of Poseidon
Mermaid sailed 790 miles.
Poseidon sailed 920 miles.
```

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