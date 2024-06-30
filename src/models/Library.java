import java.util.Date;
import java.util.List;

public class Library {
    private int id;
    private Customer customer;
    private List<Book> books;
    private Date saleDate;
    private double totalAmount;

    // Construtores
    public Sale() {}

    public Sale(int id, Customer customer, List<Book> books, Date saleDate, double totalAmount) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
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