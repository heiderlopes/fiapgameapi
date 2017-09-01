package br.com.heiderlopes.fiapgameapi.exception;

public class UsuarioInvalidoException extends Exception {

    public UsuarioInvalidoException() {
        super("Usuário não cadastrado");
    }

}

