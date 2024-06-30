package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.Usuario;

public class UsuarioDAO {
    private List<Usuario> usuarios = new ArrayList<>();

    public void save(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario findById(int id) {
        return usuarios.stream() .filter(usuario -> usuario.getId() == id).findFirst().orElse(null);
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    public void update(Usuario usuario) {
        Usuario existingUsuario = findById(usuario.getId());
        if (existingUsuario != null) {
            existingUsuario.setNome(usuario.getNome());
            existingUsuario.setEmail(usuario.getEmail());
        }
    }

    public void delete(int id) {
        usuarios.removeIf(usuario -> usuario.getId() == id);
    }

    public List<Usuario> findByEmail(String email) {
        return usuarios.stream().filter(usuario -> usuario.getEmail().equalsIgnoreCase(email))
        .collect(Collectors.toList());
    }

    public List<Usuario> findByNome(String nome) {
        return usuarios.stream().filter(usuario -> usuario.getNome().equalsIgnoreCase(nome))
        .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Usuario usuario : usuarios) {
            str.append(usuario.toString()).append("\n");
        }
        return str.toString();
    }
}
