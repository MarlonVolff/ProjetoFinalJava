package models;

import java.util.Date;
import java.util.List;

public class Library {
    private int id;
    private Usuario customer;
    private List<Livro> books;
    private Date saleDate;
    private double totalAmount;

    public Library() {}

    public Library(int id, Usuario customer, List<Livro> books, Date saleDate, double totalAmount) {
        this.id = id;
        this.customer = customer;
        this.books = books;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getCustomer() {
        return customer;
    }

    public void setCustomer(Usuario customer) {
        this.customer = customer;
    }

    public List<Livro> getBooks() {
        return books;
    }

    public void setBooks(List<Livro> books) {
        this.books = books;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return id + ";" + customer.getName() + ";" + books.size() + ";" + saleDate + ";" + totalAmount;
    }
}