public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public Usuario Controller() {
        this.usuarioDAO = new Usuario DAO();
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
}