package algoritimos;

import Applicattion.*;
import Applicattion.Memoria.Bloco;

public class first_fit implements Algorithm {
    @Override
    public boolean alocar(Processo processo, Memoria memoria) {
        Memoria.Bloco atual = memoria.getHead();
        while (atual != null) {
            if (atual.isLivre() && atual.tamanho >= processo.getTamanho()) {
                alocarNesteBloco(processo, atual);
                return true;
            };
            atual = atual.proximo;
        };
        return false; // Não encontrou espaço
    };

	protected void alocarNesteBloco(Processo processo, Bloco atual) {
        if (atual.tamanho > processo.getTamanho()) {
            // Divide o bloco
            Memoria.Bloco novoBloco = new Memoria.Bloco(atual.tamanho - processo.getTamanho());
            novoBloco.proximo = atual.proximo;
            if (atual.proximo != null) {
                atual.proximo.anterior = novoBloco;
            };
            atual.proximo = novoBloco;
            novoBloco.anterior = atual;
        };
        atual.tamanho = processo.getTamanho();
        atual.processo = processo;
    };
};