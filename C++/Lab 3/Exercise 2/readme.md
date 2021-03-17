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