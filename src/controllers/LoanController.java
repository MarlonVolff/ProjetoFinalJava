package controllers;

import java.lang.reflect.Member;
import java.time.LocalDate;

import dao.LoanDAO;
import models.Loan;

public class LoanController {
    private LoanDAO loanDAO;
    private BookDAO bookDAO;
    private MemberDAO memberDAO;

    public LoanController() {
        this.loanDAO = new LoanDAO();
        this.bookDAO = new BookDAO();
        this.memberDAO = new MemberDAO();
    }

    public void createLoan(int bookId, int memberId) {
        Book book = bookDAO.findById(bookId);
        Member member = memberDAO.findById(memberId);

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
