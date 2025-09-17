package Aplicattion;

import java.util.Random;

public class GeredorProcessos {
    private Random random = new Random();
	public String tamanhoAlocacao;

    public Memoria gerarProcesso() {
        int id = random.nextInt(41);
        int tamanhoAlocacao = 10 + random.nextInt(41);

        return new Memoria(id, tamanhoAlocacao);
	};

	@Override
	public String toString() {
		return "GeredorProcessos [random=" + random + "]";
	};
};