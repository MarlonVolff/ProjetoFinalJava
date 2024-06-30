package controllers;

import java.util.List;
import dao.UsuarioDAO;
import models.Usuario;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void addUsuario(Usuario usuario){
        usuarioDAO.addUsuario(usuario);
    }
    public List<Usuario> findAll(){
        return usuarioDAO.findAll();
    }
    public Usuario findById(int id){
        return usuarioDAO.findById(id);
    }

    public Usuario findByName(String name){
        return usuarioDAO.findByName(name);
    }

    public List<Usuario> findByEmail(String email){
        return usuarioDAO.findByEmail(email);
    }

    @Override
    public String toString(){
        return usuarioDAO.toString();
    }
}
