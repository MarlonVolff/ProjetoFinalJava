package dao;

import java.util.ArrayList;
import java.util.List;
import models.Usuario;

public class UsuarioDAO {
    private List<Usuario> usuarios = new ArrayList<>();

    public void save(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario findById(int id) {
        return usuarios.stream()
        .filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    public void update(Usuario usuario) {
        Usuario existingUsuario = findById(usuario.getId());
        if (existingUsuario != null) {
            existingUsuario.setName(usuario.getName());
            existingUsuario.setEmail(usuario.getEmail());
        }
    }

    public void delete(int id) {
        usuarios.removeIf(m -> m.getId() == id);
    }

    @Override
    public String toString(){
        String str = "";
        for(Usuario usuario : usuarios){
            str += usuario.toString();
            str += "\n";
        }
        return str;
    }
}
