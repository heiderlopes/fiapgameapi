package br.com.heiderlopes.fiapgameapi.component;

import br.com.heiderlopes.fiapgameapi.exception.UsuarioInvalidoException;
import br.com.heiderlopes.fiapgameapi.exception.UsuarioNaoInformadoException;
import br.com.heiderlopes.fiapgameapi.model.Avatar;
import br.com.heiderlopes.fiapgameapi.repository.AvatarRepository;
import br.com.heiderlopes.fiapgameapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvatarComponent {

    @Autowired
    AvatarRepository avatarRepository;

    @Autowired
    UsuarioComponent usuarioComponent;

    public void salvar(Avatar avatar) throws UsuarioNaoInformadoException, UsuarioInvalidoException{
        if(avatar.getUsername() == null ||
                avatar.getUsername().equals("")) {
            throw new UsuarioNaoInformadoException();
        } else {
            if(usuarioComponent.isUsuarioExistente(avatar.getUsername())) {
                Avatar aux = avatarRepository.findByUsername(avatar.getUsername());
                if(aux != null) {
                    avatar.setId(aux.getId());
                }
                avatarRepository.save(avatar);
            } else {
                throw new UsuarioInvalidoException();
            }
        }
    }

    public Avatar pesquisarAvatar(String username) {
        return  avatarRepository.findByUsername(username);
    }
}
