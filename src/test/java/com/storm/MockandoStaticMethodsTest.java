package com.storm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

// Ela já não é muito usada atualmente
@ExtendWith(MockitoExtension.class)
public class MockandoStaticMethodsTest {
    
    @Test
    void testaGeracaoComTamanhoDefinido() {
        Mockito.mockStatic(GeradorDeNumeros.class);
    }
}
