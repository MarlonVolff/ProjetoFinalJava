package models;

import java.time.LocalDate;

public class Loan {
    private int id;
    private Livro book;
    private Usuario member;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getBook() {
        return book;
    }

    public void setBook(Livro book) {
        this.book = book;
    }

    public Usuario getMember() {
        return member;
    }

    public void setMember(Usuario member) {
        this.member = member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                ", member=" + member +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
