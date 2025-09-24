package algoritimos;

import Applicattion.*;
import Applicattion.Memoria.Bloco;

public class best_fit extends first_fit { // Herda o método de alocação
    @Override
    public boolean alocar(Processo processo, Memoria memoria) {
        Bloco melhorBloco = null;
        Memoria.Bloco atual = memoria.getHead();

        while (atual != null) {
            if (atual.isLivre() && atual.tamanho >= processo.getTamanho()) {
                if (melhorBloco == null || atual.tamanho < melhorBloco.tamanho) {
                    melhorBloco = atual;
                };
            };
            atual = atual.proximo;
        };

        if (melhorBloco != null) {
            alocarNesteBloco(processo, melhorBloco);
            return true;
        };
        return false;
    };
};