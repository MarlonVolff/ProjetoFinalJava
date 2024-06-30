package views;

import java.util.List;
import java.util.Scanner;
import models.Livro;

public class LivroView {

    private Scanner scanner = new Scanner(System.in);

    public void displayLivro(Livro livro) {
        if (livro != null) {
            System.out.println("ID: " + livro.getId());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Author: " + livro.getAutor());
            System.out.println("ISBN: " + livro.getIsbn());
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
        System.out.println("Insira os detalhes do Livro:");
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
}
