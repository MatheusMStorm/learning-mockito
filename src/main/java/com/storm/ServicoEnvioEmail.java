package com.storm;

public class ServicoEnvioEmail {
    private PlataformaDeEnvio plataforma;

    void enviaEmail(String enderecoEmail, String mensagem, boolean formatoHTML) {
        Email email = null;

        if (formatoHTML) {
            email = new Email(enderecoEmail, mensagem, Formato.HTML);
        }
        else {
            email = new Email(enderecoEmail, mensagem, Formato.TEXTO);
        }

        plataforma.enviaEmail(email);
    }
}
