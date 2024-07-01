package views;

import java.util.Scanner;
import controllers.*;

public class LivrariaView {
    private LivroController livroController;
    public LivroView livroView;
    private UsuarioController usuarioController;
    public UsuarioView usuarioView;
    private LoanController loanController;
    // public LoanView loanView;
    private Scanner scanner;

    public LivrariaView() {
        this.livroController = new LivroController();
        this.livroView = new LivroView(livroController);
        this.usuarioController = new UsuarioController();
        this.usuarioView = new UsuarioView(usuarioController);
        this.loanController = new LoanController();
        //this.loanview = new LoanView();
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
                //loanView.displayLoanMenu();
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Escolha inválida.");
        }
    }
}
