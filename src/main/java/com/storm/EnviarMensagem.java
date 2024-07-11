package com.storm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnviarMensagem {
    private List<Mensagem> mensagens = new ArrayList<>();

    public void adicionarMensagem(Mensagem mensagem) {
        this.mensagens.add(mensagem);
    }

    public List<Mensagem> getMensagem() {
        return Collections.unmodifiableList(this.mensagens);
    }
}