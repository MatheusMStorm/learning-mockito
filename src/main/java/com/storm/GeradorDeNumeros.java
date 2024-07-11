package com.storm;

import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

public final class GeradorDeNumeros {
    private static SplittableRandom random = new SplittableRandom();

    private GeradorDeNumeros(){}
    
    public static List<Integer> gerarNumerosAleatorios(int tamanhoLista) {
        return random.ints().boxed().limit(tamanhoLista).collect(Collectors.toList());
    }

    public static List<Integer> gerarNumerosAleatorios() {
        return random.ints().boxed().limit(10).collect(Collectors.toList());
    }
}
