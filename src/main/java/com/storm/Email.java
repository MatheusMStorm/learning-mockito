package com.storm;

public class Email {
    private String enderecoEmail;
    private String mensagem;
    private Formato formatoMensagem;
    
    public Email(String enderecoEmail, String mensagem, Formato formatoMensagem) {
        this.enderecoEmail = enderecoEmail;
        this.mensagem = mensagem;
        this.formatoMensagem = formatoMensagem;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Formato getFormatoMensagem() {
        return formatoMensagem;
    }

    
}
