package br.com.heiderlopes.fiapgameapi.model;

/**
 * Created by heiderlopes on 01/09/17.
 */
public class MensagemException {

    private String mensagem;

    public MensagemException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
