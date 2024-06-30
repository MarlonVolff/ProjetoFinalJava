package models;

<<<<<<< HEAD:src/models/Livro.java
public class Livro {
=======
public class Livros {
>>>>>>> 4a53b838f5e8260ad3362a4ad55b732413a43f02:src/models/Livros.java
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    
    public Livro() {
    }
    public Livro(int id) {
        this.id = id;
    }
    public Livro(int id, String titulo, String autor, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Livros [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + "]";
    }
    
}
