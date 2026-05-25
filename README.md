# Library-Management-System-Java
A Java-based Library Management System using OOP, HashMaps, and Queues.
# Library Management System (Java DSA)

A terminal-based Library Management System built from scratch in Java using Object-Oriented Programming (OOP) and fundamental Data Structures.

## 🚀 Key Features
- **Add & Search Books:** Instant inventory management.
- **Duplicate Prevention:** Avoids adding identical Book IDs.
- **Automated Waitlist Queue:** Uses a FIFO (First-In, First-Out) queue to manage high-demand books when multiple students request them.
- **Late Fee Calculator:** Automatically applies fines based on overdue return days.

## 🛠️ Data Structures Used
- **HashMap:** Used for book storage and lookups to ensure $O(1)$ time complexity.
- **Queue (LinkedList implementation):** Used to handle sequential student waitlists fairly.

## 📁 Project Structure
- `Book.java` - Data model containing book details (Encapsulation).
- `Student.java` - Data model for student tracking.
- `Library.java` - Core engine managing HashMaps and Queue logic.
- `Main.java` - Interactive user CLI menu driven by a `Scanner` loop.

  ## 💻 How to Run the Project
1. Clone or download this repository.
2. Open the project root folder in an IDE like **IntelliJ IDEA** or VS Code.
3. Navigate to `src/Main.java`.
4. Click **Run** to execute the interactive console menu.
