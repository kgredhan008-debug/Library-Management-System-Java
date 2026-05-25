import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Library {
    private HashMap<String, Book> books;
    // We will map a Book ID to a Queue of Students who are waiting for it!
    private HashMap<String, Queue<Student>> waitlists;

    public Library() {
        books = new HashMap<>();
        waitlists = new HashMap<>();
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getBookId())) {
            System.out.println("Error: A book with ID " + book.getBookId() + " already exists!");
        } else {
            books.put(book.getBookId(), book);
            // Initialize an empty waitlist queue for this new book
            waitlists.put(book.getBookId(), new LinkedList<>());
            System.out.println("Success: '" + book.getTitle() + "' added to the library.");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is currently empty.");
            return;
        }
        System.out.println("\n--- Library Inventory ---");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void searchBook(String bookId) {
        if (books.containsKey(bookId)) {
            System.out.println("Found: " + books.get(bookId));
        } else {
            System.out.println("Search Error: Book with ID " + bookId + " not found.");
        }
    }

    public void issueBook(String bookId, Student student) {
        if (!books.containsKey(bookId)) {
            System.out.println("Issue Error: Book with ID " + bookId + " does not exist.");
            return;
        }

        Book book = books.get(bookId);

        if (!book.isAvailable()) {
            // Book is taken! Let's add the student to the waitlist queue instead
            waitlists.get(bookId).add(student);
            System.out.println("Waitlist: '" + book.getTitle() + "' is unavailable. " + student.getName() + " added to the waitlist.");
            return;
        }

        book.setAvailable(false);
        System.out.println("Success: '" + book.getTitle() + "' has been issued to " + student.getName() + ".");
    }

    // NEW METHOD: Return Book & Process Fine / Waitlist
    public void returnBook(String bookId, int daysLate) {
        if (!books.containsKey(bookId)) {
            System.out.println("Return Error: Invalid Book ID.");
            return;
        }

        Book book = books.get(bookId);
        System.out.println("\n--- Returning '" + book.getTitle() + "' ---");

        // 1. Calculate Fine ($2 per day late)
        if (daysLate > 0) {
            int fine = daysLate * 2;
            System.out.println("Late Fee Notice: Fine of $" + fine + " charged for " + daysLate + " days overdue.");
        } else {
            System.out.println("Thank you! Book returned on time. No fines.");
        }

        // 2. Check the Waitlist Queue
        Queue<Student> waitlist = waitlists.get(bookId);
        if (!waitlist.isEmpty()) {
            // Pull the next student out of the queue (FIFO) using poll()
            Student nextStudent = waitlist.poll();
            System.out.println("Queue Alert: Book immediately issued to next student in line: " + nextStudent.getName());
            // Keep book status as unavailable since it went straight to the next student
            book.setAvailable(false);
        } else {
            // No one is waiting, book becomes available again
            book.setAvailable(true);
            System.out.println("Status Update: '" + book.getTitle() + "' is now back on the shelves.");
        }
    }
}