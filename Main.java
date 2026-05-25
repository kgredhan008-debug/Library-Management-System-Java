import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Pre-populating some data so the library isn't completely empty at start
        library.addBook(new Book("B001", "The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("B002", "1984", "George Orwell"));
        library.addBook(new Book("B003", "Clean Code", "Robert C. Martin"));

        System.out.println("\n=========================================");
        System.out.println("  WELCOME TO THE SYSTEM TUTOR LIBRARY  ");
        System.out.println("=========================================");

        while (running) {
            System.out.println("\n*** MAIN MENU ***");
            System.out.println("1. Add a New Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search for a Book");
            System.out.println("4. Issue (Borrow) a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();

                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    String searchId = scanner.nextLine();
                    library.searchBook(searchId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to borrow: ");
                    String issueId = scanner.nextLine();
                    System.out.print("Enter Student ID: ");
                    String sId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String sName = scanner.nextLine();

                    Student student = new Student(sId, sName);
                    library.issueBook(issueId, student);
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    String returnId = scanner.nextLine();
                    System.out.print("How many days late is this return? (Enter 0 if on time): ");
                    int daysLate = scanner.nextInt();

                    library.returnBook(returnId, daysLate);
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting System. Thank you for using the Library!");
                    break;

                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }
}