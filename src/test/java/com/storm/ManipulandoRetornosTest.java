package com.storm;

import static org.mockito.ArgumentMatchers.anyString;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ManipulandoRetornosTest {
    @Mock // --> Mockando a API dos correios (com isso ele simulará o comportamento da API)
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks // --> Injetando um mock dentro da classe, porque a API está inclusa dentro dela
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        Endereco dadosLocalizacao = new Endereco("Rua 7", "Casa", "Centro", "Salvador", "BA");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao); // --> Usamos o matcher anyString para validar com qualquer string
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Matheus", "212232109", LocalDate.of(2003, 8, 19), "40050120");

        assertEquals("Matheus", pessoa.getNome());
        assertEquals("212232109", pessoa.getDocumento());
        assertEquals(LocalDate.of(2003, 8, 19), pessoa.getDataNascimento());
        assertEquals("BA", pessoa.getEndereco().getUf());
    }

    @Test
    void lancarExceptionChamandoApi() {
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class); // --> Lançamento de exceção

        assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("Matheus", "212232109", LocalDate.of(2003, 8, 19), "40050120"));
    }

    // Podemos também inverter usando o doThrow().when()
}
