package Aplicattion;

import java.util.Random;

public class GeredorProcessos {
    private Random random = new Random();
	public int tamanhoAlocacao;
	
	public int memory = 1000;

    public Memoria gerarProcesso(){
    	for (int i = 0; i < 100; i++) {
    		int id = i;
            int tamanhoAlocacao = 10 + random.nextInt(51);
            
            Memoria memoria = new Memoria(id, memory, tamanhoAlocacao);
            memoria.a();
            
            memory -= tamanhoAlocacao;
    	};

        int id = 0;
		return new Memoria(id, memory, tamanhoAlocacao);
	};
};