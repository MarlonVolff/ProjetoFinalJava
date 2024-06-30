package controllers;

import java.util.List;
import models.Livro;
import dao.LivroDAO;

public class LivroController {
    private LivroDAO livroDAO;

    public LivroController() {
        this.livroDAO = new LivroDAO();
    }

    public void addLivro(Livro livro){
        livroDAO.addLivro(livro);
    }
    public List<Livro> findAll(){
        return livroDAO.findAll();
    }
    public Livro findById(int id){
        return livroDAO.findById(id);
    }

    public Livro findByTitle(String title){
        return livroDAO.findByTitle(title);
    }

    public List<Livro> findByAuthor(String author){
        return livroDAO.findByAuthor(author);
    }

    public Livro findByISBN(String ISBN){
        return livroDAO.findByISBN(ISBN);
    }

    @Override
    public String toString(){
        return livroDAO.toString();
    }
}
