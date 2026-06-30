
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


