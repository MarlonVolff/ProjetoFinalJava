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
        usuarioDAO.save(usuario);
    }
    public void removeUsuario(int id){
        usuarioDAO.delete(id);
    }
    public List<Usuario> findAll(){
        return usuarioDAO.findAll();
    }
    public Usuario findById(int id){
        return usuarioDAO.findById(id);
    }

    public List<Usuario> findByName(String name){
        return usuarioDAO.findByNome(name);
    }

    public List<Usuario> findByEmail(String email){
        return usuarioDAO.findByEmail(email);
    }

    @Override
    public String toString(){
        return usuarioDAO.toString();
    }
}
