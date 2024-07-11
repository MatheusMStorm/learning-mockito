package com.storm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CapturandoArgumentosTest {
    
    @Mock
    private PlataformaDeEnvio plataforma; // --> Mockando a plataforma

    @InjectMocks
    private ServicoEnvioEmail servico; // --> Injetando o mock no serviço de email

    @Captor // --> Captura o argumento do e-mail
    ArgumentCaptor<Email> captor;

    @Test
    void validarEnvioDeDadosParaPlataforma() {
        String enderecoDeEmail = "matheus@test.com";
        String mensagem = "Olá teste mensagem";
        boolean formatoHTML = false;

        servico.enviaEmail(enderecoDeEmail, mensagem, formatoHTML);

        Mockito.verify(plataforma).enviaEmail(captor.capture()); // --> O método capture irá capturar as infos

        Email emailCapturado = captor.getValue();

        assertEquals(enderecoDeEmail, emailCapturado.getEnderecoEmail());
        assertEquals(mensagem, emailCapturado.getMensagem());
        assertEquals(Formato.TEXTO, emailCapturado.getFormatoMensagem());
    }
}
