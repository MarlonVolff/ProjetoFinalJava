package views;

import java.util.Scanner;
import java.time.LocalDate;
import controllers.*;
import models.*;

public class LivrariaView {
    private LivroController bookController;
    private UsuarioController usuarioController;
    private LoanController loanController;
    private Scanner scanner;

    public LivrariaView() {
        this.bookController = new LivroController();
        this.usuarioController = new UsuarioController();
        this.loanController = new LoanController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Biblioteca");
        System.out.println("1. Adicionar Livro");
        System.out.println("2. Adicionar Usuário");
        System.out.println("3. Criar Empréstimo");
        System.out.println("4. Sair");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                addUsuario();
                break;
            case 3:
                createLoan();
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Escolha inválida.");
        }
    }

    private void addBook() {
        System.out.println("Adicionar novo livro");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Título: ");
        String title = scanner.next();
        System.out.print("Autor: ");
        String author = scanner.next();
        System.out.print("ISBN: ");
        String isbn = scanner.next();

        Livro book = new Livro();
        book.setId(id);
        book.setTitulo(title);
        book.setAutor(author);
        book.setIsbn(isbn);

        bookController.addLivro(book);
        System.out.println("Livro adicionado com sucesso!");
    }

    private void addUsuario() {
        System.out.println("Adicionar novo usuário");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Nome: ");
        String name = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setName(name);
        usuario.setEmail(email);

        usuarioController.addUsuario(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    private void createLoan() {
        System.out.println("Criar novo empréstimo");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("ID do Livro: ");
        int bookId = scanner.nextInt();
        System.out.print("ID do Usuário: ");
        int usuarioId = scanner.nextInt();

        Livro book = bookController.findById(bookId);
        Usuario usuario = usuarioController.getUsuarioById(usuarioId);
        Loan loan = new Loan();
        loan.setId(id);
        loan.setBook(book);
        loan.setMember(usuario);
        loan.setLoanDate(LocalDate.now());

        loanController.addLoan(loan);
        System.out.println("Empréstimo criado com sucesso!");
    }
}
