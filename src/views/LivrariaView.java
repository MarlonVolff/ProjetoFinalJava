package views;

import java.util.Scanner;
import java.time.LocalDate;
import controllers.*;
import models.*;

public class LivrariaView {
    private LivroController livroController;
    public LivroView livroView;
    private UsuarioController usuarioController;
    public UsuarioView usuarioView;
    private LoanController loanController;
    private Scanner scanner;

    public LivrariaView() {
        this.livroController = new LivroController();
        this.livroView = new LivroView(livroController);
        this.usuarioController = new UsuarioController();
        this.usuarioView = new UsuarioView();
        this.loanController = new LoanController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Biblioteca");
        System.out.println("1. Livro Menu");
        System.out.println("2. Usuário Menu");
        System.out.println("3. Loan Menu");
        System.out.println("4. Sair");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                livroView.displayLivroMenu();
                break;
            case 2:
                usuarioView.exibirMenu();
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

    private void createLoan() {
        System.out.println("Criar novo empréstimo");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("ID do Livro: ");
        int bookId = scanner.nextInt();
        System.out.print("ID do Usuário: ");
        int usuarioId = scanner.nextInt();

        Livro book = livroController.findById(bookId);
        Usuario usuario = usuarioController.findById(usuarioId);
        Loan loan = new Loan();
        loan.setId(id);
        loan.setBook(book);
        loan.setMember(usuario);
        loan.setLoanDate(LocalDate.now());

        loanController.addLoan(loan);
        System.out.println("Empréstimo criado com sucesso!");
    }
}
