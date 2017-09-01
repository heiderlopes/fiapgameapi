package br.com.heiderlopes.fiapgameapi.controller;

import br.com.heiderlopes.fiapgameapi.component.AvatarComponent;
import br.com.heiderlopes.fiapgameapi.exception.UsuarioNaoInformadoException;
import br.com.heiderlopes.fiapgameapi.model.Avatar;
import br.com.heiderlopes.fiapgameapi.model.MensagemException;
import br.com.heiderlopes.fiapgameapi.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/avatar")
public class AvatarController {

    @Autowired
    AvatarComponent avatarComponent;

    @PostMapping
    public ResponseEntity salvar(@RequestBody Avatar avatar) throws UsuarioNaoInformadoException {
        try{
            avatarComponent.salvar(avatar);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new MensagemException(ex.getMessage()));
        }

    }

    @GetMapping("/{username}")
    public Avatar pesquisarAvatar(@PathVariable(value = "username") String username) {
        return avatarComponent.pesquisarAvatar(username);
    }
}
