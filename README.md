

# File I/O Management System - Core Java

## Overview

This project demonstrates basic file management operations implemented using Java File I/O. It provides a simple command-line interface that allows users to interact with the filesystem for creating, displaying, opening, deleting, and restoring files. The system is designed to handle files in a predefined directory and supports essential file management operations, including file backup and restoration.

## Key Features

- **Create Files**: Allows the user to create new files with custom names.
- **Show All Files**: Lists all files in the predefined directory.
- **Show Files by Name**: Allows users to search for and view a specific file by its name.
- **Open File by Name**: Enables users to open and view the contents of a specific file.
- **Delete Files by Name**: Provides the functionality to delete a specific file from the directory, with a backup mechanism to restore it.
- **Restore Files**: Allows users to restore deleted files from a backup folder.
- **Delete All Files**: Deletes all files in the directory permanently.
- **Exit**: Closes the application.

---

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Setup](#setup)
3. [Usage](#usage)
4. [Code Explanation](#code-explanation)
5. [Additional Information](#additional-information)

---

## Prerequisites

To run this project, ensure that you have the following software installed:

- **Java Development Kit (JDK)**: Version 8 or later.
- **IDE** (Integrated Development Environment) such as IntelliJ IDEA, Eclipse, or any text editor like VSCode.

---

## Setup

### Clone or Download the Project:

- Clone the repository or download the source code files to your local machine.

### Directory Setup:

The project expects a folder structure similar to the following:

```plaintext
C:\Users\YourUsername\Desktop\databaseio
C:\Users\YourUsername\Desktop\databaseio\backup
```

- Replace `YourUsername` with your actual username on the system.
- Ensure that `databaseio` contains the files you want to manage, and the `backup` folder will store any files you restore.

### Compile and Run:

Open the project in your IDE or use the terminal to compile and run the Java file:

```bash
javac Launch.java
java Launch
```

---

## Usage

Upon running the program, you will be presented with a simple menu that allows you to choose an option by entering the corresponding number:

```plaintext
P1->CreateFile
P2->ShowAllFiles
P3->ShowFilesbyName
P4->OpenFilebyName
P5->DeleteFilebyName
P6->Restore
P7->DeleteAll
P8->EXIT
Enter your choice:
```

### Available Options:

- **CreateFile**: Creates a new file in the `databaseio` directory.
- **ShowAllFiles**: Displays a list of all files present in the `databaseio` directory.
- **ShowFilesbyName**: Allows you to search for a specific file by name.
- **OpenFilebyName**: Opens a file by name and displays its contents.
- **DeleteFilebyName**: Deletes a specific file after backing it up.
- **Restore**: Restores a deleted file from the `backup` directory.
- **DeleteAll**: Deletes all files in the `databaseio` directory.
- **Exit**: Exits the program.

---

## Code Explanation

### Main Logic

The application begins by initializing the `Scanner` for user input, and presents the main menu in a loop. Based on user input, the appropriate method is called for executing the chosen file operation.

### Key Methods:

1. **`createFile()`**: 
   - Creates a new file in the specified directory. If the file already exists, it informs the user.

2. **`showAllFiles()`**:
   - Returns a list of all filenames in the directory.

3. **`showFilesbyName()`**:
   - Prompts the user to enter a file name, checks if it exists, and returns the file name if found.

4. **`openFilebyName()`**:
   - Opens and displays the contents of a specified file.

5. **`deleteFilebyName()`**:
   - Deletes a file by name, after backing it up to the backup directory.

6. **`backup()`**:
   - Copies the file to the backup directory before deletion.

7. **`restore()`**:
   - Restores a file from the backup directory to the original location.

8. **`deleteAll()`**:
   - Permanently deletes all files in the directory.

---

## Example Flow

1. **Create a New File**
   - **Input**: `testFile.txt`
   - **Output**: `"File Created Successfully"`

2. **Show All Files**
   - **Output**:
     ```plaintext
     testFile.txt
     anotherFile.txt
     ```

3. **Open a File**
   - **Input**: `testFile.txt`
   - **Output**: 
     ```plaintext
     File contents:
     Hello, this is a test file.
     ```

4. **Delete a File**
   - **Input**: `testFile.txt`
   - **Output**: `"File Deleted Successfully"`

5. **Restore a File**
   - **Input**: `testFile.txt`
   - **Output**: `"File Restored Successfully"`

---

## Error Handling

- Basic exception handling is included to ensure file operations are safely executed.
- If a file operation fails, an appropriate error message is displayed to the user.

---

## Additional Information

### Customization:
- You can easily modify the directory paths and file management logic to fit your specific needs.

### Backup Directory:
- Ensure that the `backup` directory exists for file restoration operations to work properly.

### File Handling:
- The project handles **text files** and stores them in a directory on your desktop.

### Extending Functionality:
- This project serves as a basic demonstration of file I/O operations in Java and can be extended with additional features like **file encryption**, **permission management**, or **integration with a database** for a more advanced file management system.



