package algoritimos;

import Applicattion.*;
import Applicattion.Memoria.Bloco;

public class next_fit extends first_fit {
    @Override
    public boolean alocar(Processo processo, Memoria memoria) {
        Bloco atual = memoria.getUltimoBlocoVerificado();
        
        // Percorre do último verificado até o fim
        while (atual != null) {
            if (atual.isLivre() && atual.tamanho >= processo.getTamanho()) {
                alocarNesteBloco(processo, atual);
                memoria.setUltimoBlocoVerificado(atual);
                return true;
            };
            atual = atual.proximo;
        };
        
        // Se não encontrou, percorre do início até o último verificado
        atual = memoria.getHead();
        while (atual != memoria.getUltimoBlocoVerificado()) {
             if (atual.isLivre() && atual.tamanho >= processo.getTamanho()) {
                alocarNesteBloco(processo, atual);
                memoria.setUltimoBlocoVerificado(atual);
                return true;
            };
            atual = atual.proximo;
        };

        return false; // Não encontrou espaço em nenhuma volta
    };
};