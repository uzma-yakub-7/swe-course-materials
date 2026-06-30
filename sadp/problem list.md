
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

# Problem 4
The Payment Processor Patterns Used: Strategy, Adapter, Singleton Consider an e-commerce checkout system. 

The PaymentStrategy (Strategy) interface defines a pay(amount) method. Concrete strategies are CreditCardStrategy and PayPalStrategy. 

The system needs to integrate with a new, third-party "CryptoPayment" service that uses a method sendCrypto(String currency, double amount). 

You create a CryptoPaymentAdapter (Adapter). The PaymentProcessor (Singleton) is the central class that manages and executes the selected payment strategy. 

Question: How do the three patterns work together to allow a user to pay with cryptocurrency? Name the role of each pattern.

# Problem 5
Imagine you are building a media player application. The core feature is a play button that should work with any type of audio file. 

Your player has a PlaybackStrategy interface with a single method: play(String fileName). You already have two strategies: MP3Strategy - can play .mp3 files using playMp3(fileName) WAVStrategy - can play .wav files using playWav(fileName)

 Now, you want to add support for a powerful, new AdvancedAudioEngine from a third-party library. This engine is fantastic, but it has a different method: playAdvancedFormat(String filePath, String codec). 


Question: How can you use the Adapter Pattern to make this AdvancedAudioEngine work with your existing Strategy Pattern system, so that when the user clicks the play button, it can handle the new format just like an MP3 or WAV file? What specific class would you create, and what would it do?

# Problem 6
File System Manager
You're building a file system where:
Both File and Directory can be treated as FileSystemComponent with operations like getSize() and list()
Users need simple high-level operations like backup(component) that handles the complexity of traversing the entire structure
 Design a system, write minimal pseudo-code.

