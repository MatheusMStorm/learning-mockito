package com.storm;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // --> sempre incluir essa extensão com Mockito
public class ListaTest {
    
    @Mock // --> mockando a lista
    private List<String> letras;

    @Test
    void adicionarItemNaLista() {
        Mockito.when(letras.get(0)).thenReturn("B");
        Assertions.assertEquals("B", letras.get(0));
    }
}
