
# Problem 1
/**
* GAME ENGINE FACADE PATTERN EXERCISE
*
* TASK: You are building a game engine that consists of multiple complex subsystems.
* Currently, game developers have to initialize and manage all these subsystems manually,
* which is error-prone and complicated.
*
* Your task is to create a GameEngineFacade that provides a simple interface
* for common game operations.
*
* REQUIREMENTS:
* 1. Create a GameEngineFacade class that wraps all the subsystem components
* 2. Implement startGame() method that initializes all engines in correct sequence
* 3. Implement pauseGame() method that safely pauses the game
* 4. Implement shutdownGame() method that properly cleans up all resources
* 5. Make sure the client code can use your facade with simple one-line commands


// SUBSYSTEM CLASSES
class GraphicsEngine {...}

class PhysicsEngine {...}

class AudioEngine {...}

class InputHandler {...}

class NetworkManager {...}

// TODO: CREATE YOUR GameEngineFacade CLASS BELOW
// Implement the following methods:
//
startGame()
//
pauseGame()
//
resumeGame()
//
shutdownGame()

# Problem-2
You are given two scenarios and you need to identify the design pattern for each and write a minimal code structure.

Scenario 1: Home Theater System
 You have complex classes for Projector, SoundSystem, and DvdPlayer. You want a simple interface for the client to watch a movie without dealing with these classes directly.

Scenario 2: Document Exporter
 You need different compression algorithms (ZIP, RAR, TAR) that can be switched at runtime. Also, you want a single instance of CompressionManager to handle all compression operations.

# Problem 3
Composite Pattern

You are modeling a company's organizational structure. There are two types of components:
Individual Employees (leaf nodes) which have a name and a salary.
Departments (composite nodes) which have a name and can contain any number of employees or sub-departments.
Requirements:
Define a common interface (or abstract class) for both employees and departments with the following methods:
double getSalary(); // returns the total salary of the component
void display(); // prints the details of the component
For an Employee, the getSalary() method returns the employee's salary, and display() prints the employee's name and salary.
For a Department, the getSalary() method returns the sum of the salaries of all components in the department (including sub-departments).
The display() method should print the department name and then display all the components (employees and sub-departments) within it.
The Department class should have methods to add and remove components.
Example of expected output for a department with two employees and one sub-department:
Department: Engineering
Employee: John Doe - $50000.0
Employee: Jane Smith - $60000.0
Department: QA
Employee: Bob Johnson - $40000.0
Total Engineering Department Salary: $150000.0

