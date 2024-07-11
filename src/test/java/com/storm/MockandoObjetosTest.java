package com.storm;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockandoObjetosTest {
    @Mock // --> Mockando a API dos correios (com isso ele simulará o comportamento da API)
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks // --> Injetando um mock dentro da classe, porque a API está inclusa dentro dela
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        Endereco dadosLocalizacao = new Endereco("Rua 7", "Casa", "Centro", "Salvador", "BA");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("40050120")).thenReturn(dadosLocalizacao); // --> Função para quando ele entrar com um dado, ele retornar um objeto 
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Matheus", "212232109", LocalDate.of(2003, 8, 19), "40050120");

        Assertions.assertEquals("Matheus", pessoa.getNome());
        Assertions.assertEquals("212232109", pessoa.getDocumento());
        Assertions.assertEquals(LocalDate.of(2003, 8, 19), pessoa.getDataNascimento());
        Assertions.assertEquals("BA", pessoa.getEndereco().getUf());
    }
}
