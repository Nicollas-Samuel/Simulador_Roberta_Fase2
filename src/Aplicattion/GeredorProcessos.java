package Aplicattion;

import java.util.Random;

public class GeredorProcessos {
    private Random random = new Random();
	public int tamanhoAlocacao;
	
	public int memory = 1000;

    public Memoria gerarProcesso(){
    	for (int i = 0; i < 4; i++) {
    		int id = random.nextInt(51);
            int tamanhoAlocacao = 10 + random.nextInt(51);

            memory -= tamanhoAlocacao;
    	};

        int id = 0;
		return new Memoria(id, memory, tamanhoAlocacao);
	};
};