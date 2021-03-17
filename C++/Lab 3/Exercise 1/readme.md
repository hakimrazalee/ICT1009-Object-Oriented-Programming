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