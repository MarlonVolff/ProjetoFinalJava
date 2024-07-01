package views;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Livro;
import controllers.LivroController;

public class LivroView {

    public LivroController livroController;

    private Scanner scanner = new Scanner(System.in);

    public LivroView(LivroController livroController) {
        this.livroController = livroController;
    }

    public void displayLivroMenu() {
            Livro livro = new Livro();
            List<Livro> livros = new ArrayList<>();

            System.out.println("\n\nMenu de Livros:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Todos os Livros");
            System.out.println("3. Procurar Livro por ID");
            System.out.println("4. Procurar Livro por Título");
            System.out.println("5. Procurar Livro por Autor");
            System.out.println("6. Procurar Livro por ISBN");
            System.out.println("7. Gerar ListaLivros.csv");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    livroController.addLivro(getLivroDetails());
                    break;
                case 2:
                    livros= livroController.findAll();
                    displayLivros(livros);
                    break;
                case 3:
                    livro = livroController.findById(getLivroId());
                    displayLivro(livro);
                    break;
                case 4:
                    livro = livroController.findByTitle(getLivroTitle());
                    displayLivro(livro);
                    break;
                case 5:
                    livros = livroController.findByAuthor(getLivroAuthor());
                    displayLivros(livros);
                    break;
                case 6:
                    livro = livroController.findByISBN(getLivroISBN());
                    displayLivro(livro);
                    break;
                case 7:
                    try {
                        writeFile(livroController);
                    } catch (IOException e) {

                    }
                    break;
                case 8:
                    LivrariaView livrariaView = new LivrariaView();
                    livrariaView.displayMainMenu();
                    // System.out.println("Saindo...");
                    // return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        
    }

    public void displayLivro(Livro livro) {
        if (livro != null) {
            System.out.println(livro.toString());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void displayLivros(List<Livro> livros) {
        if (livros != null && !livros.isEmpty()) {
            for (Livro livro : livros) {
                displayLivro(livro);
                System.out.println();
            }
        } else {
            System.out.println("Nenhum Livro encontrado.");
        }
    }

    public Livro getLivroDetails() {
        System.out.println("\n\nInsira os detalhes do Livro:");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        return new Livro(id, titulo, autor, isbn);
    }

    public int getLivroId() {
        System.out.print("Insira o ID do Livro: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getLivroTitle() {
        System.out.print("Insira o Título do Livro: ");
        return scanner.nextLine();
    }

    public String getLivroAuthor() {
        System.out.print("Insira o Autor do Livro: ");
        return scanner.nextLine();
    }

    public String getLivroISBN() {
        System.out.print("Insira o ISBN do Livro: ");
        return scanner.nextLine();
    }

    public static void writeFile(LivroController livroController) throws IOException {

        FileWriter file = new FileWriter("../ListaLivros.csv");

        List<Livro> livros = livroController.findAll();
        for (Livro livro : livros) {
            file.write(livro.toString() + "\n");
        }

        file.close();

        System.out.println("Arquivo CSV gerado com sucesso!");
    }
}
