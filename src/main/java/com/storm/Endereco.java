package com.storm;

public class Endereco {
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    
    public Endereco(String logradouro, String complemento, String bairro, String cidade, String uf) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return "Endereco [logradouro=" + logradouro + ", complemento=" + complemento + ", bairro=" + bairro
                + ", cidade=" + cidade + ", uf=" + uf + "]";
    }
}
