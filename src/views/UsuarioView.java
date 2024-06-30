import java.io.*;
import java.util.*;

public class UsuarioMenu {

    private UsuarioController usuarioController;
    private Scanner scanner;

    public UsuarioMenu() {
        this.usuarioController = new UsuarioController(); 
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n===== Menu de Usuário =====");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Buscar Usuário por ID");
            System.out.println("3. Listar Todos os Usuários");
            System.out.println("4. Atualizar Usuário");
            System.out.println("5. Remover Usuário");
            System.out.println("6. Exportar Usuários para CSV");
            System.out.println("7. Importar Usuários de CSV");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarUsuario();
                    break;
                case 2:
                    buscarUsuarioPorId();
                    break;
                case 3:
                    listarTodosUsuarios();
                    break;
                case 4:
                    atualizarUsuario();
                    break;
                case 5:
                    removerUsuario();
                    break;
                case 6:
                    exportarUsuariosParaCSV();
                    break;
                case 7:
                    importarUsuariosDeCSV();
                    break;
                case 8:
                    sair = true;
                    System.out.println("Saindo do menu de usuários...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private void adicionarUsuario() {
        System.out.println("\nAdicionar novo usuário:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Usuario novoUsuario = new Usuario(id, nome, email);
        usuarioController.addUsuario(novoUsuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    private void buscarUsuarioPorId() {
        System.out.println("\nBuscar usuário por ID:");
        System.out.print("ID do usuário: ");
        int id = scanner.nextInt();

        Usuario usuario = usuarioController.getUsuarioById(id);
        if (usuario != null) {
            System.out.println("Usuário encontrado:");
            System.out.println(usuario);
        } else {
            System.out.println("Usuário com ID " + id + " não encontrado.");
        }
    }

    private void listarTodosUsuarios() {
        System.out.println("\nListar todos os usuários:");
        for (Usuario usuario : usuarioController.getAllUsuarios()) {
            System.out.println(usuario);
        }
    }

    private void atualizarUsuario() {
        System.out.println("\nAtualizar dados de um usuário:");
        System.out.print("ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();  

        Usuario usuarioExistente = usuarioController.getUsuarioById(id);
        if (usuarioExistente != null) {
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo email: ");
            String novoEmail = scanner.nextLine();

            usuarioExistente.setNome(novoNome);
            usuarioExistente.setEmail(novoEmail);

            usuarioController.updateUsuario(usuarioExistente);
            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Usuário com ID " + id + " não encontrado.");
        }
    }

    private void removerUsuario() {
        System.out.println("\nRemover usuário:");
        System.out.print("ID do usuário: ");
        int id = scanner.nextInt();

        usuarioController.deleteUsuario(id);
        System.out.println("Usuário removido com sucesso!");
    }

    private void exportarUsuariosParaCSV() {
        try {
            FileWriter writer = new FileWriter("Usuarios.csv");
            for (Usuario usuario : usuarioController.getAllUsuarios()) {
                writer.write(usuario.getId() + "," + usuario.getNome() + "," + usuario.getEmail() + "\n");
            }
            writer.close();
            System.out.println("Usuários exportados para 'Usuarios.csv' com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao exportar usuários para CSV: " + e.getMessage());
        }
    }

    private void importarUsuariosDeCSV() {
        try {
            List<String> linhas = readFile("Usuarios");
            for (String linha : linhas) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String email = dados[2];
                Usuario usuario = new Usuario(id, nome, email);
                usuarioController.addUsuario(usuario);
            }
            System.out.println("Usuários importados de 'Usuarios.csv' com sucesso!");
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo 'Usuarios.csv' não encontrado.");
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo 'Usuarios.csv': " + e.getMessage());
        }
    }

    public static List<String> readFile(String name) throws IOException {
        List<String> dados = new ArrayList<>();
        try (Scanner read = new Scanner(new File("C:\\Users\\Lucas\\Desktop\\Projeto\\" + name + ".csv"))) {
            while (read.hasNextLine()) {
                String line = read.nextLine();
                dados.add(line);
            }
        }
        return dados;
    }

    public static void writeFile(UsuarioController usuarioController) throws IOException {
        FileWriter writer = new FileWriter("Usuarios.csv");
        for (Usuario usuario : usuarioController.getAllUsuarios()) {
            writer.write(usuario.getId() + "," + usuario.getNome() + "," + usuario.getEmail() + "\n");
        }
        writer.close();
    }

    public static void main(String[] args) {
        UsuarioMenu menu = new UsuarioMenu();
        menu.exibirMenu();
    }
}
