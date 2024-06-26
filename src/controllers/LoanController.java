package controllers;

import java.time.LocalDate;
import java.util.List;

import dao.*;
import models.*;

public class LoanController {
    private LoanDAO loanDAO;
    private LivroDAO livroDAO;
    private UsuarioDAO usuarioDAO;

    public LoanController() {
        this.loanDAO = new LoanDAO();
        this.livroDAO = new LivroDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    public void addLoan(Loan loan){
        loanDAO.save(loan);
    }
    public List<Loan> findAll(){
        return loanDAO.findAll();
    }
    public void createLoan(int bookId, int memberId) {
        Livro book = livroDAO.findById(bookId);
        Usuario member = usuarioDAO.findById(memberId);

        if (book != null && member != null) {
            Loan loan = new Loan();
            loan.setId(generateLoanId());
            loan.setBook(book);
            loan.setMember(member);
            loan.setLoanDate(LocalDate.now());
            loan.setReturnDate(null);

            loanDAO.save(loan);
            System.out.println("Loan Criado com sucesso!");
        } else {
            System.out.println("Livro invalio");
        }
    }

    public void returnLoan(int loanId) {
        Loan loan = loanDAO.findById(loanId);
        if (loan != null && loan.getReturnDate() == null) {
            loan.setReturnDate(LocalDate.now());
            loanDAO.update(loan);
            System.out.println("Livro deu boa");
        } else {
            System.out.println("Livro ou Id não retornado");
        }
    }

    public void viewLoanDetails(int loanId) {
        Loan loan = loanDAO.findById(loanId);
        if (loan != null) {
            System.out.println(loan);
        } else {
            System.out.println("Loan not found.");
        }
    }

    private int generateLoanId() {
        return loanDAO.findAll().size() + 1;

    }
    @Override
    public String toString(){
        return loanDAO.toString();
    }
}
