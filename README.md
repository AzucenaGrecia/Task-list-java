# Task Management Application 📝

Welcome to the Task Management Application! This simple yet powerful Java application helps you manage your daily tasks efficiently. 

## Prerequisites 🛠️

Before you begin, ensure you have the following installed on your system:

- Java Development Kit (JDK) 23 or later
- Maven 3.6 or later
- Your favorite IDE (IntelliJ IDEA recommended)

## Getting Started 🚀

### 1. Clone the Repository

```bash
git clone [repository-url]
cd 09-task-app
```

### 2. Build the Project

The project uses Maven for dependency management. To build the project, run:

```bash
mvn clean install
```

This will download all necessary dependencies (including Google's Gson library) and compile the project.

### 3. Run the Application 🏃‍♂️

You can run the application directly from your IDE or using Maven:

```bash
mvn exec:java -Dexec.mainClass="dev.devtalles.proyecto.Main"
```

## Features ✨

This task management application allows you to:

- Create new tasks
- List all tasks
- Mark tasks as completed
- Delete tasks
- Save tasks to a JSON file for persistence

## Project Structure 📁

The project follows a simple structure:
- `src/main/java/` - Contains all Java source files
- `tasks.json` - Stores your tasks (created automatically when you add tasks)

## Dependencies 📚

The project uses:
- Java 23
- Maven for project management
- Gson 2.13.0 for JSON handling

## Architecture - MVC Pattern 🏗️

This application implements the Model-View-Controller (MVC) architectural pattern, which helps organize the code into three distinct components:

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│      Model      │     │   Controller    │     │      View       │
│                 │     │                 │     │                 │
│  - Task.java    │◄───►│ - TaskManager   │◄───►│ - Console UI   │
│  - tasks.json   │     │   .java         │     │   Interface    │
│                 │     │                 │     │                 │
└─────────────────┘     └─────────────────┘     └─────────────────┘
```

### 🔹 Model
- Represents the data and business logic
- Includes the `Task` class that defines the task structure
- Handles persistent storage in `tasks.json`

### 🔹 View
- Manages the console user interface
- Displays tasks and messages to the user
- Receives user input

### 🔹 Controller
- Acts as an intermediary between Model and View
- Processes user commands
- Implements business logic for task management

### Data Flow
1. User interacts with the View (CLI)
2. View sends actions to the Controller
3. Controller processes logic and updates the Model
4. Model notifies changes
5. View updates to show results

This pattern allows us to:
- Clearly separate responsibilities
- Facilitate code maintenance
- Make modifications in one layer without affecting others
- Improve code reusability

## Contributing 🤝

Feel free to fork this project and submit pull requests with improvements!

## Need Help? 💡

If you encounter any issues or have questions, please:
1. Check if your Java version matches the required version (23)
2. Ensure all dependencies are properly installed
3. Verify that you have proper read/write permissions in the project directory

## License 📄

This project is open source and available under the MIT License.

---
Happy Task Managing! 🎉 