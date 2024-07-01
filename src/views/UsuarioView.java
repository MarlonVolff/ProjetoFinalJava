package views;

import controllers.*;
import models.*;
import java.io.*;
import java.util.*;

public class UsuarioView {

    private UsuarioController usuarioController;
    private Scanner scanner;

    public UsuarioView(UsuarioController usuarioController) {
        this.usuarioController = usuarioController; 
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n===== Menu de Usuário =====");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Buscar Usuário por ID");
            System.out.println("3. Listar Todos os Usuários");
            System.out.println("4. Exportar Usuários para CSV");
            System.out.println("5. Remover Usuário");
            System.out.println("6. Sair");
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
                        try {
                            writeFile(usuarioController);
                        } catch (IOException e) {
                            System.out.println("Erro ao gerar arquivo CSV: " + e.getMessage());
                        }
                        break;
                case 5:
                    removerUsuario();
                    break;
                case 8:
                    System.out.println("Saindo do menu de usuários...");
                    return;
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

        Usuario usuario = usuarioController.findById(id);
        if (usuario != null) {
            System.out.println("Usuário encontrado:");
            System.out.println(usuario.toString());
        } else {
            System.out.println("Usuário com ID " + id + " não encontrado.");
        }
    }

    private void listarTodosUsuarios() {
        System.out.println("\nListar todos os usuários:");
        for (Usuario usuario : usuarioController.findAll()) {
            System.out.println(usuario.toString());
        }
    }

    private void removerUsuario() {
        System.out.println("\nRemover usuário:");
        System.out.print("ID do usuário: ");
        int id = scanner.nextInt();

        usuarioController.removeUsuario(id);
        System.out.println("Usuário removido com sucesso!");
    }

    public static void writeFile(UsuarioController usuarioController) throws IOException {

        FileWriter file = new FileWriter("../ListaUsuarios.csv");

        List<Usuario> usuarios = usuarioController.findAll();
        for (Usuario usuario : usuarios) {
            file.write(usuario.toString() + "\n");
        }

        file.close();

        System.out.println("Arquivo CSV gerado com sucesso!");
    }
}
