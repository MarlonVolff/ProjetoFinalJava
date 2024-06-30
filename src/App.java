import views.*;
import controllers.*;

public class App {
    public static void main(String[] args) throws Exception {

        LivroController controller = new LivroController();
        LivroView view = new LivroView(controller);

        view.displayLivroMenu();
    }
}
