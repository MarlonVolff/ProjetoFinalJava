package dao;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<Usuario> usuario = new ArrayList<>();

    public void save(Usuario usuario) {
        usuario.add(usuario);
    }

    public Usuario findById(int id) {
        return usuario.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(usuario);
    }

    public void update(Usuario usuario) {
        Usuario existingUsuario = findById(usuario.getId());
        if (existingUsuario != null) {
            existingUsuario.setName(usuario.getName());
            existingUsuario.setEmail(usuario.getEmail());
        }
    }

    public void delete(int id) {
        usuario.removeIf(m -> m.getId() == id);
    }
}