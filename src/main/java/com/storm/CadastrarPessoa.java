package com.storm;

import java.time.LocalDate;

public class CadastrarPessoa {
    private ApiDosCorreios apiDosCorreios;

    public CadastrarPessoa(ApiDosCorreios apiDosCorreios) {
        this.apiDosCorreios = apiDosCorreios;
    }

    public Pessoa cadastrarPessoa(String nome, String documento, LocalDate nascimento, String cep) {
        Pessoa pessoa = new Pessoa(nome, documento, nascimento);
        Endereco dadosLocalizacao = apiDosCorreios.buscaDadosComBaseNoCep(cep);
        pessoa.adicionaDadosDeEndereco(dadosLocalizacao);
        return pessoa;
    }
}