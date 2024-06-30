package controllers;

import dao.UsuarioDAO;
import models.Usuario;
import java.util.List;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void addUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    public Usuario getUsuarioById(int id) {
        return usuarioDAO.findById(id);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.findAll();
    }

    public void updateUsuario(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    public void deleteUsuario(int id) {
        usuarioDAO.delete(id);
    }

    @Override
    public String toString(){
        return usuarioDAO.toString();
    }
}
