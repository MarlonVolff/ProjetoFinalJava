package views;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import controllers.LoanController;
import models.Loan;

public class LoanView {
    private LoanController loanController;
    private Scanner scanner;

    public LoanView() {
        this.loanController = new LoanController();
        this.scanner = new Scanner(System.in);
    }

    public void displayLoanMenu() {
        while (true) {
            System.out.println("Gerenciamento de Locações");
            System.out.println("1. Criar Locação");
            System.out.println("2. Retornar Livro");
            System.out.println("3. Visualizar Detalhes da Locação");
            System.out.println("4. Salvar CSV");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Selecione uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createLoan();
                    break;
                case 2:
                    returnLoan();
                    break;
                case 3:
                    viewLoanDetails();
                    break;
                case 4:
                    try {
                        writeFile(loanController);
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar o arquivo CSV: " + e.getMessage());
                    }
                    break;
                case 5:
                    LivrariaView livrariaView = new LivrariaView();
                    livrariaView.displayMainMenu();
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    private void createLoan() {
        System.out.print("Insira o ID do livro: ");
        int bookId = scanner.nextInt();
        System.out.print("Insira o ID do membro: ");
        int memberId = scanner.nextInt();

        loanController.createLoan(bookId, memberId);
    }

    private void returnLoan() {
        System.out.print("Insira o ID da locação: ");
        int loanId = scanner.nextInt();

        loanController.returnLoan(loanId);
    }

    private void viewLoanDetails() {
        System.out.print("Insira o ID da locação: ");
        int loanId = scanner.nextInt();

        loanController.viewLoanDetails(loanId);
    }

    public static void writeFile(LoanController loanController) throws IOException {
        FileWriter file = new FileWriter("ListaLoan.csv");

        List<Loan> loans = loanController.findAll();
        for (Loan loan : loans) {
            file.write(loan.toString() + "\n");
        }

        file.close();

        System.out.println("Arquivo CSV gerado com sucesso!");
    }
}
