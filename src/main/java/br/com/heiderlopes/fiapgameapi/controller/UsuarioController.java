package br.com.heiderlopes.fiapgameapi.controller;

import br.com.heiderlopes.fiapgameapi.component.UsuarioComponent;
import br.com.heiderlopes.fiapgameapi.model.MensagemException;
import br.com.heiderlopes.fiapgameapi.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioComponent usuarioComponent;

    @PostMapping
    public ResponseEntity salvar(@RequestBody Usuario usuario){
        try{
            usuarioComponent.salvar(usuario);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception ex) {
            MensagemException me = new MensagemException(ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(me);
        }
    }

    @GetMapping("/{username}/{password}")
    public ResponseEntity validarUsuario(@PathVariable(value = "username") String username,
                                  @PathVariable(value = "password") String password) {
        boolean valido = usuarioComponent.validaUsuario(username, password);
        if(valido) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            MensagemException me = new MensagemException("Usuário ou senha inválido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(me);
        }
    }
}
