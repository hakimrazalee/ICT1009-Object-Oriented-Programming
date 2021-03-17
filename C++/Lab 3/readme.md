# Lab 3 : Inheritance

## Exercise 1:
1. Create a class Car. The Car class serves as the base class and includes features common to all cars: ignition on/off the flag and current speed.
ICT1009: Object-Oriented Programming Page 2 of 4

2. Create a function that displays whether the Car is running and its
current speed, based on the value of the isIgnitionOn flag.

3. Create two functions: turnIgnitionOn() and turnIgnitionOff() to set
the value of isIgnitionOn flag to either true or false. Make sure
that when the ignition is off, the Car’s speed is set to 0.

4. Create a function setSpeed() that takes an integer argument and uses
it to set the value of the speed field. Include a condition where no
Car is allowed to speed greater than 65 mph and no car is allowed
any speed other than 0 if the ignition is off.

5. Create a main() function to test your base class. You should get a
similar output as the figure below. Notice that when we attempt to
set the Car’s speed to 70 miles/hour, the setSpeed() function
enforces a limit of 65 miles/hour.

Output:
```C++
Ignition is on. Speed is 35mph.
Ignition is on. Speed is 65mph.
Ignition is off. Speed is 0mph.
```

The Convertible class extends the Car class so that a Convertible
possesses the added feature of a top that lowers and raises. The data
member isTopUp holds the status of the Convertible’s Top.

6. Include three functions to work with this data field: one puts the
top up; another puts it down and the third displays the Convertible’s
status. The putTopUp() and putTopDown() set the isTopUp field to
true and false respectively. The showCar() function overrides the
parent class function with the same name. It calls the parent class
function to display the status of the ignition and speed, then also
displays the status of the isTopUp field.

7. Create a main() function to declare a Convertible object and test
the functions to start the Convertible, set the speed, put the top
down, up, and show the status. Your output should look as follows.

Output
```C++
Ignition is on. Speed is 35mph.
Top is down.
Ignition is on. Speed is 65mph.
Top is down.
Ignition is off. Speed is 0mph.
Top is up.

```

Another child class is called RaceCar. The class RaceCar has all the
attributes of a Car, but its maximum allowed speed is higher.

8. Create class RaceCar and change the Car class private access
specifier to protected so that when you extend the Car class, its
child can use the Car data fields directly.

9. Implement the RaceCar::setSpeed() function to set the RaceCar speed
to the value passed into the function, as long as the speed is below
200 mph. Remember that the Car speed limit is at most 65 mph.

10. Write a main() function to instantiate a Car and a RaceCar and test
out your setSpeed() function by attempting to set the speed of each
object to 80 mph. When you attempt to set the Car speed to 80, it is
reduced to 65, however, 80 is an acceptable speed for RaceCar. Check
that you get similar output as follows.

Output
```C++
A car at 100 mph: Ignition is on. Speed is 65mph.
A race car at 100 mph: Ignition is on. Speed is 100mph.
```

The final class ConvertibleRaceCar is a child of both the Convertible
class and the RaceCar class (compare the class diagram above) and hence
applies multiple-inheritance.

11. Create the ConvertibleRaceCar class which contains no new data
members or functions of its own (empty body) but inherits from
Convertible and RaceCar using the public access specifier.

12. Now, add a main() function that instantiates a ConvertibleRaceCar
with the name aCar and turns on its ignition: aCar.turnIgnitionOn();
Note: Your code should not compile and you should receive an error
message! Try to understand what is happening (Hint: dreaded diamond).

13. Recall the lecture notes and add the virtual keyword at the correct
location. Without the keyword virtual, there is an ambiguity for
function turnIgnitionOn() because it exists in both parent classes.
Adding the keyword virtual ensures that members of the original base
class, Car, are inherited only once.

14. Finally, tests all the functions that originated with the parent
classes.
Your output should look as follows:

```C++
Car set to 30 mph:
Ignition is on. Speed is 30mph.
Top is up.

Car set to 80 mph with top down:
Ignition is on. Speed is 80mph.
Top is down.

Car set to 250 mph with top up:
Ignition is on. Speed is 200mph.
Top is up.
```

## Exercise 2:

Package delivery services such as FedEx, DHL, and UPS, offer a number of
different shipping options, each with specific costs associated. In this
exercise, you will create an inheritance hierarchy to represent various
types of packages. Use Package as the base class of the hierarchy, then
include classes TwoDayPackage and OvernightPackage that derive from
Package.

1. Write a base class Package which should include data members
representing the name, street, city, country, and postal code for both
the sender and recipient of the package, as well as weight and
costPerKg to ship the package. Package’s constructor should initialize
these data members, ensuring that the weight and costPerKg contain
positive values.
Base class Package should additionally consist of a public member
function calculateCost that returns a double indicating the cost
associated with shipping the package. The function calculateCost
determines the cost by multiplying the weight by the cost per kg.

2. Write a derived class TwoDayPackage which should inherit the
functionality of the base class Package. In addition, it should also
include a data member that represents a flatFee that the shipping
company charges for two-day delivery service. The constructor should
receive a value to initialize the flatFee. TwoDayPackage should
redefine (override) the member function calculateCost so that it
computes the shipping cost by adding the flatFee to the weight-based
cost calculated by the base class Package.

3. Write a class OvernightPackage which inherits directly from class
Package and contains an additional data member representing an
additional feePerKg charged for overnight delivery service.
OvernightPackage redefines member function calculateCost so that it
adds the additional fee per kg to the standard cost.

4. Finally, write a main() function that creates objects of each type of
Package. You should test the member function calculateCost() and print
out the details of each Package.
Below is shown an example instantiation of the three class-objects and
the corresponding output.

Below is shown an example instantiation of the three class-objects and
the corresponding output.

```C++
Package 1:
Sender: Bruce Lee
1 Fighting Rd, Hong Kong, China
Recipient: Alice Wong
Jurong Ave 1, Jurong, Singapore
Cost: 4.25

Package 2:
Sender: Donald Trump
1600 Pennsylvania Ave, Washington, USA
Recipient: Barack Obama
21 Democracy St, Washington, USA
Cost: 8.825

Package 2:
Sender: Lee Hsien Loong
1 Parlament Pl, CBD, Singapore
Recipient: Bob Tan
Yishun Ave 1, Yishun, Singapore
Cost: 11.6375
```