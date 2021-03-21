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
