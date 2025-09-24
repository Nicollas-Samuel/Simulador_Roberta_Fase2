package algoritimos;

import Applicattion.*;
import Applicattion.Memoria.Bloco;

public class worst_fit extends first_fit {
    @Override
    public boolean alocar(Processo processo, Memoria memoria) {
        Bloco piorBloco = null;
        Bloco atual = memoria.getHead();

        while (atual != null) {
            if (atual.isLivre() && atual.tamanho >= processo.getTamanho()) {
                if (piorBloco == null || atual.tamanho > piorBloco.tamanho) {
                    piorBloco = atual;
                }
            };
            atual = atual.proximo;
        };

        if (piorBloco != null) {
            alocarNesteBloco(processo, piorBloco);
            return true;
        };

        return false;
    };
};