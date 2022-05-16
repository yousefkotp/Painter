# Painter
Graphical paint program which allows the user to draw with different colors and strokes, it also allows the user to draw diffrent types of shapes and manipulate them by resizing, filling, moving and cloning them. It also supports undo and redo operations. 

## Project Functionalities
1. Draw using brush
2. Draw different shapes as: line, rectangle, square, circle and triangle
3. Erase
4. Clear the screen
5. Undo & Redo operations are supported
6. Changing paint color
7. Changing stroke of each paint/shape
8. Filling shapes with vairious colors
9. Moving shapes
10. Resizing shapes
11. Copying & Pasting shapes
12. Automatic & Manual screenshot
## Tools
1. IntelliJ IDEA (IDE)
2. Java 
3. Java.swing
4. Creately for UMLs diagrams
5. LaTeX for writing documentation
## Deployment
To run the program, you have to run the class named "FinalProjectPaint_V1" as your main class with Java SDK 16
## Design Patterns
**1. Factory Design Pattern**
We have used Factory design patter in order to create new Objects
without need of construction and to avoid coupling and dependency
between Classes. So we constructed new instances of classes through
this factory and returning it in needed methods or classes

**2. Prototype Design Pattern**
We have used Prototype design pattern by implementing “Cloneable”
interface and implementing “clone()”method in each and every Shape
class and also Cloning instances of “Point” class. It helped us making
copies of our Objects using values not references that helped us in
copy method.

**3. Singleton Design Pattern**
We have used Singleton design pattern to assure the creation of only
one object of “ScreenShotter” class which has main aim to take
screenshot of the painting board and it is the only instance that is
allowed to do such task.

**4. Façade Design Pattern**
We have used façade design pattern as it offers a simple interface to
more complex underlying objects. So we could use draw methods
using objects of “ShapeMakerFacade” class and not by accessing the
shapes classes itself.

**5. Iterator Design Pattern**
Iterator design Pattern facilitates looping across the array list of
Geometric shapes needed to be drawn by only using 2 basic methods
which are : “hasNext()” and “next()” avoiding looping with varying
conditions.

**6. Iterator Design Pattern**
Observer design pattern helped us with automatic
screenshotting(update method) while drawing (auto-documentation) as
it takes screenshot each and every time we release the mouse by only
changing the state in the PaintBoard class.

## S.O.L.I.D Principles

## Documentation
[Project Documentation](ProjectDocumentation.pdf)
## Contributers
1. [Yousef Kotp](https://github.com/yousefkotp)
2. [Mohamed Farid](https://github.com/MohamedFarid612)
3. [Adham Mohamed](https://github.com/adhammohamed1)
# Screenshots
![image](https://user-images.githubusercontent.com/41492875/132782674-2f777635-4ae4-45be-b560-2b5a1dc1cde0.png)

![screen](https://user-images.githubusercontent.com/41492875/132788122-ab423bb7-a12c-46c9-a90c-c8a78626e492.png)
