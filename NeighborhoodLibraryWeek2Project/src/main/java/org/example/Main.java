package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[20];

        books[0] = new Book(1, "9780593593806", "Spare", false, "");
        books[1] = new Book(2, "9781668001226", "It Starts with Us", false, "");
        books[2] = new Book(3, "9781501110368", "It Ends with Us", false, "");
        books[3] = new Book(4, "9783442178581", "Atomic Habits", false, "");
        books[4] = new Book(5, "9783423230124", "Verity", false, "");
        books[5] = new Book(6, "9780593862407", "Lessons in Chemistry", false, "");
        books[6] = new Book(7, "9783548066738","The Seven Husbands of Evelyn Hugo", false, "");
        books[7] = new Book(8, "9788727012858", "Heart Bones", false, "");
        books[8] = new Book(9, "9781476753188", "Ugly Love", false, "");
        books[9] = new Book(10, "9780593740149", "Happy Place", false, "");
        books[10] = new Book(11, "9781506107158", "Never Never", false, "");
        books[11] = new Book(12, "9781408857878", "A Court of Thorns and Roses", false, "");
        books[12] = new Book(13, "9782368124178", "Daisy Jones and The Six", false, "");
        books[13] = new Book(14, "9783958187443", "Thins We Never Got Over", false, "");
        books[14] = new Book(15, "9783944476131", "The Body Keeps the Score: Brain, Mind, and Body, in the Healing of Trauma", false, "");
        books[15] = new Book(16, "9781250230782", "The Silent Patient", false, "");
        books[16] = new Book(17, "9788467039054", "The 48 Laws of Power", false, "");
        books[17] = new Book(18, "9783736320550", "IceBreaker", false, "");
        books[18] = new Book(19, "9788727013879", "Reminders of Him", false, "");
        books[19] = new Book(20, "9798212262088", "Twisted Love", false, "");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to The Neighborhood Library Home Screen!");
            System.out.println("Please select an option:");
            System.out.println("1- Show available books.");
            System.out.println("2- Show checked out books.");
            System.out.println("3- Exit");
            int userSelection = scanner.nextInt();

            switch (userSelection) {
                case 1:
                    displayAvailableBooks(books);
                    break;
                case 2:
                    displayCheckedOutBooks(books);
                    break;
                case 3:
                    System.out.println("Thank you, have a great day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Im sorry, that is not a valid response. Please choose either 1, 2 or 3.");
                    break;


            }
        }

    }
    public static void displayAvailableBooks(Book[] books) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        boolean availBooks = false;

        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle());
                availBooks = true;
            }
        }
        if (!availBooks) {
            System.out.println("Sorry, this book is not available at the moment.");
            break;
        }
            System.out.println("Please make your selection by typing the title of the book desired: ");
            System.out.println("Or enter 0 to go back to The Neighborhood Library Home Screen.");
            String titleOfBook = scanner.nextLine();

            if (titleOfBook.equals("0")) {
                break;
            }
            boolean bookFound = false;
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(titleOfBook) && !book.isCheckedOut()) {
                    System.out.println("If you would like to check out this book, please enter your name:");
                    String readersName = scanner.nextLine();

                    book.checkOut(readersName);
                    System.out.println("Thank you " + readersName + ", you have checked out your book.");
                    bookFound = true;
                    break;
                }
            }
            if (!bookFound) {
                System.out.println("Book not found.");
            }
    }
}
    public static void displayCheckedOutBooks(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            boolean checkedOutBooks = false;

            for (Book book : books) {
                if (book.isCheckedOut()) {
                    System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", is checked out by: " + book.getCheckedOutTo());
                    checkedOutBooks = true;
                }
            }
            if (!checkedOutBooks) {
                System.out.println("Books have not been checked out.");
               break;
            }

            System.out.println("If you'd like to check in a book, please enter the book ID. Or enter 0 to return back to The Neighborhood Library Home Screen");
            int bookID = scanner.nextInt();
            scanner.nextLine();

            if (bookID == 0) {
                exit = true;
            } else {
                boolean bookFound = false;
                for (Book book : books) {
                    if (book.getId() == bookID && book.isCheckedOut()) {
                        book.checkIn();

                        System.out.println("Thank you, book has been checked in.");
                        bookFound = true;
                        break;
                    }
                }
                if (!bookFound) {
                    System.out.println("No book found.");
                }

            }
        }
    }

}