package br.com.heiderlopes.fiapgameapi.exception;

/**
 * Created by heiderlopes on 01/09/17.
 */
public class UsuarioExistenteException extends Exception {

    public UsuarioExistenteException() {
        super("Usuario ou senha inválido");
    }

}
