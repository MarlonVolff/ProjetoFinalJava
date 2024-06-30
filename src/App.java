import models.Livro;
import views.LivroView;
import controllers.LivroController;

public class App {
    public static void main(String[] args) throws Exception {

        LivroController controller = new LivroController();
        LivroView view = new LivroView();

        // Add Livro
        Livro newLivro = view.getLivroDetails();
        controller.addLivro(newLivro);

        // Display Livros
        view.displayLivros(controller.findAll());

        // Find Livro pelo ID
        int id = view.getLivroId();
        view.displayLivro(controller.findById(id));

        // Find Livro pelo Title
        String title = view.getLivroTitle();
        view.displayLivro(controller.findByTitle(title));

        // Find Livro pelo Author
        String author = view.getLivroAuthor();
        view.displayLivros(controller.findByAuthor(author));

        // Find Livro pelo ISBN
        String isbn = view.getLivroISBN();
        view.displayLivro(controller.findByISBN(isbn));
    }
}
