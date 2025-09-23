package Applicattion;

import java.util.Random;

public class GeredorProcessos {
	private Random random = new Random();
	
    private int proximoId = 1;
    private static final int TAMANHO_MINIMO = 10;
    private static final int TAMANHO_MAXIMO = 50;

    public Processo gerar() {
        int tamanho = random.nextInt(TAMANHO_MAXIMO - TAMANHO_MINIMO + 1) + TAMANHO_MINIMO;
        return new Processo(proximoId++, tamanho);
    };
};