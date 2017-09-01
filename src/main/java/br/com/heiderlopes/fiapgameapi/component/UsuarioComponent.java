package br.com.heiderlopes.fiapgameapi.component;

import br.com.heiderlopes.fiapgameapi.model.Usuario;
import br.com.heiderlopes.fiapgameapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioComponent {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public boolean validaUsuario(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsernameAndPassword(username, password);
        return  usuario == null ? false : true;
    }

    public boolean isUsuarioExistente(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        return  usuario == null ? false : true;
    }

    public void salvar(Usuario usuario) throws Exception {
        Usuario user = usuarioRepository.findByUsername(usuario.getUsername());
        if(user == null) {
            usuarioRepository.save(usuario);
        } else {
            throw new Exception("Usuario já cadastrado");
        }
    }
}
