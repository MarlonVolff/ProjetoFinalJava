package dao;
<<<<<<< HEAD

=======
>>>>>>> 4a53b838f5e8260ad3362a4ad55b732413a43f02
import java.util.ArrayList;
import java.util.List;
import models.Livro;

public class LivroDAO {
    public List<Livro> livros = new ArrayList<>();

    public void addLivro(Livro sLivro){
        livros.add(sLivro);
    }

    public List<Livro> findAll(){
        return new ArrayList<>(livros);
    }

    public Livro findById(int id){
        for (Livro livro : livros) {
            if (livro.getId() == id) return livro;
        }
        return null;
    }

    public Livro findByTitle(String title){
        for (Livro livro : livros){
            if(livro.getTitulo().equals(title)) return livro;
        }
        return null;
    }

    public List<Livro> findByAuthor(String author){
        List<Livro> livrosByAuthor = new ArrayList<>();
        for(Livro livro : livros){
            if(livro.getAutor().equals(author)) livrosByAuthor.add(livro);
        }
        return livrosByAuthor;
    }

    public Livro findByISBN(String ISBN){
        for (Livro livro : livros) {
            if(livro.getIsbn().equals(ISBN)) return livro;
        }
        return null;
    }
}
