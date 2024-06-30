package view;

import java.util.Scanner;

public class LibraryView {
    private BookController bookController;
    private MemberController memberController;
    private LoanController loanController;
    private Scanner scanner;

    public LibraryView() {
        this.bookController = new BookController();
        this.memberController = new MemberController();
        this.loanController = new LoanController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Create Loan");
            System.out.println("4. Return Loan");
            System.out.println("5. View Loan Details");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    createLoan();
                    break;
                case 4:
                    returnLoan();
                    break;
                case 5:
                    viewLoanDetails();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);

        bookController.addBook(book);
        System.out.println("Book added successfully!");
    }

    private void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member email: ");
        String email = scanner.nextLine();

        Member member = new Member();
        member.setName(name);
        member.setEmail(email);

        memberController.addMember(member);
        System.out.println("Member added successfully!");
    }

    private void createLoan() {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();

        loanController.createLoan(bookId, memberId);
    }

    private void returnLoan() {
        System.out.print("Enter loan ID: ");
        int loanId = scanner.nextInt();

        loanController.returnLoan(loanId);
    }

    private void viewLoanDetails() {
        System.out.print("Enter loan ID: ");
        int loanId = scanner.nextInt();

        loanController.viewLoanDetails(loanId);
    }
}
