import java.util.ArrayList;
import java.util.List;

public class LoanDAO {
    private List<Loan> loans;

    public LoanDAO() {
        this.loans = new ArrayList<>();
    }

    public void save(Loan loan) {
        loans.add(loan);
    }

    public Loan findById(int id) {
        for (Loan loan : loans) {
            if (loan.getId() == id) {
                return loan;
            }
        }
        return null;
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loans);
    }

    public void update(Loan loan) {
        int index = -1;
        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getId() == loan.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            loans.set(index, loan);
        }
    }

    public void delete(int id) {
        loans.removeIf(loan -> loan.getId() == id);
    }
}
