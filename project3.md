Project 3
=========

### Due Friday, November 4, 2016 - 5:00pm

The goal of this project is to implement a program that maintains a searchable database of cars. You will use the following features:

- Interfaces
- Inheritance
- Arrays

### Overview

For this assignment, you will build a database using the following CSV file: [cars.csv](cars.csv). You will then implement a driver class that invokes methods to retrieve required information from the database.

Your grade will depend heavily on the *design* of your solution. Make sure that all of the requirements are followed and that the remaining components are well-designed and efficient.

### Requirements

For full credit, your solution **must** use the following design elements.

1. You must implement a base class `Car`. The `Car` class cannot be instantiated. 
2. A `Car` must have at least the following properties: `model` (column Model), `vehicleClass` (column Veh Class), and `pollutionScore` (column Air Pollution Score). 
3. `Car` must also be `Comparable`. `Car` objects are sorted first by pollution score. If two `Car` objects have the same pollution score then they will be sorted by model.
4. `Car` must have two subclasses: `GasCar` and `GreenCar`.  
5. A `GasCar` is any car that does not have a Fuel of Hydrogen or Electricity. Hybrid cars (e.g., Fuel Gasoline/Electricity) are considered type `GasCar`. `GasCar` must have at least the following properties: `numberCylinders` (column Cyl) and `mpg` (column Cmb MPG). For cars with two values for Cmb MPG the value used should be the first value (to the left of the "/").
6. A `GreenCar` is a car with Fuel either Hydrogen or Electricity. `GreenCar` will have the property `fuelType` (column Fuel). This will either be "Hydrogen" or "Electricity".
7. You must have a `CarList` that maintains a *sorted array* of `Car` objects. Use the `compareTo` method to sort `Car` objects.
8. **You may not use `ArrayList` for *any* portion of this program.**
9. `CarList` will have, at minimum, the following methods. You may add additional helper methods as appropriate.
  - `addCar` - this method takes as input a `Car` and inserts it into the array *in sorted order*. If the array is full it will be resized to accommodate a new item. 
  - `toString` - returns a `String` representation of the entire database. The representation of a `GasCar` will look as follows: Model: VOLVO XC 90 Class: standard SUV Pollution Score: 9 MPG: 25 Cylinders: 4 The representation of a `GreenCar` will look as follows: Model: FIAT 500e Class: small car Pollution Score: 10 Fuel Type: Electricity
  - `toStringGreenCars` - returns a `String` representation of the `GreenCar` objects in the list where the representation for each `Car` is of the following format: Model: BMW i3 BEV Fuel Type: Electricity. Note, the format for this method is different than that of the `toString` method.
  - `avgMpg` - takes no parameters and returns the average MPG across all `GasCar` objects.
  - `avgMpgByPartialModel` - takes as input a `String` with a partial model (for example, "Subaru") and returns the average MPG for all cars with a model *containing* the partial model query `String`. You may use the `String` `contains` method in your solution for this method.
  - `findClassesByCylinders` - takes as input an `int` specifying number of cylinders and returns a `String[]` containing the vehicle classes with models that have the specified number of cylinders. For full credit, the `String[]` will have no repeated elements (each class will only appear once) and the length must be large enough to accommodate only the number of valid elements.
  - `findModelsByClassAndMpg` - takes as input a target vehicle class and a minimum MPG and returns a `String[]` containing the models of all vehicles of the specified class that have *at least* the specified combined MPG. The `String[]` may have repeated elements if the same model appears twice in the dataset, but the the length must be large enough to accommodate only the number of valid elements.
10. The `main` method will be in a class called `CarDBDriver`. The suggested algorithm for this method is as follows:
  - Build a `CarList` object from the file [cars.csv](cars.csv).
  - Print "All Cars:" followed by a newline.
  - Print the result of calling `toString` on the `CarList`.
  - Print "Green Cars - Fuel Type:" followed by a newline.
  - Print the result of calling `toStringGreenCars` on the `CarList`.
  - Print "Average MPG All:" followed by the result of calling `avgMpg` on the `CarList` followed by a newline. The result should be displayed with exactly two digits after the decimal point.
  - Print "Average MPG Subaru:" followed by the result of calling `avgMpgByPartialModel("SUBARU")` on the `CarList` followed by a newline. The result should be displayed with exactly two digits after the decimal point.
  - Print "Average MPG Toyota:" followed by the result of calling `avgMpgByPartialModel("TOYOTA")` on the `CarList` followed by a newline. The result should be displayed with exactly two digits after the decimal point.
  - Print "Average MPG Ferrari:" followed by the result of calling `avgMpgByPartialModel("FERRARI")` on the `CarList` followed by a newline. The result should be displayed with exactly two digits after the decimal point.
  - Print "Vehicle Classes with 4-Cylinder Cars:" followed by a newline followed by the result of calling `findClassesByCylinders(4)` on the `CarList`. For each item in the list returned, print a tab followed by the item followed by a newline.
  - Print "Vehicle Classes with 6-Cylinder Cars:" followed by a newline followed by the result of calling `findClassesByCylinders(6)` on the `CarList`. For each item in the list returned, print a tab followed by the item followed by a newline.
  - Print "Small SUVs with MPG > 22:" followed by a newline followed by the result of calling `findModelsByClassAndMpg("small SUV", 22)` on the `CarList`. For each item in the list returned, print a tab followed by the item followed by a newline.
  - Print "Small Cars with MPG > 35:" followed by a newline followed by the result of calling `findModelsByClassAndMpg("small car", 35)` on the `CarList`. For each item in the list returned, print a tab followed by the item followed by a newline.
11. Your output must **exactly** match the following: [p3output.txt](p3output.txt) All spacing, indentation, and ordering must exactly match the result.
12. You *may* implement classes in addition to those specified.


### Submission Requirements

1. For this assignment, you will submit all Java files you implemented for this program. Your `main` method **must** be in a file `CarDBDriver.java`. You must also submit `Car.java`, `GreenCar.java`, and `GasCar.java`. It is expected you will have at least one additional Java file.
 
2. Make sure your code follows all requirements in the [Style Guidelines](https://github.com/CS112-F16/notes/blob/master/style.md).

3. Follow the instructions in the [SVN Guide](https://github.com/CS112-F16/notes/blob/master/svn_guide.md) for submitting your solution by the deadline.

4. Make sure you have submitted your work in an SVN directory: `https://www.cs.usfca.edu/svn/<username>/cs112/project3`
