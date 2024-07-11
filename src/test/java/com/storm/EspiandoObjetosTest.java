package com.storm;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

// --> Espiar é observar o comportamento de um objeto usando Mockito
@ExtendWith(MockitoExtension.class)
public class EspiandoObjetosTest {
    
    @Spy // --> Espiando um objeto
    private EnviarMensagem enviarMensagem;

    @Test
    void observarComportamentoDaClasse() {
        verifyNoInteractions(enviarMensagem); // --> Verificar se não houve interações na classe

        Mensagem mensagem = new Mensagem();
        enviarMensagem.adicionarMensagem(mensagem);
        verify(enviarMensagem).adicionarMensagem(mensagem); // --> Verificar se o objeto recebeu o comportamento esperado

        Assertions.assertFalse(enviarMensagem.getMensagem().isEmpty());
    }

    // método inOrder = observar a ordem que vão acontecer os comportamentos
    // método times = valida a quantidade de vezes que um comportamento foi chamado
}