package com.storm;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String documento;
    private LocalDate dataNascimento;
    private Endereco endereco;
    
    public Pessoa(String nome, String documento, LocalDate dataNascimento) {
        this.nome = nome;
        this.documento = documento;
        this.dataNascimento = dataNascimento;
    }

    public void adicionaDadosDeEndereco(Endereco dadosLocalizacao) {
        this.endereco = dadosLocalizacao;
    }
    
    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
