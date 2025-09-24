package Applicattion;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	// Classe interna para representar um bloco de memória
	public static class Bloco {
        public Processo processo; // null se o bloco estiver livre
        public int tamanho;
        public Bloco anterior;
        public Bloco proximo;

        public Bloco(int tamanho) {
            this.tamanho = tamanho;
            this.processo = null;
            this.anterior = null;
            this.proximo = null;
        };

        public boolean isLivre() {
            return processo == null;
        };
    };

    private Bloco head;
    private Bloco ultimoBlocoVerificado; // Para o Next Fit

    public Memoria(int tamanhoTotal) {
        this.head = new Bloco(tamanhoTotal);
        this.ultimoBlocoVerificado = head;
    };
    
    public Bloco getHead() {
        return head;
    };

    public Bloco getUltimoBlocoVerificado() {
        return ultimoBlocoVerificado;
    };

    public void setUltimoBlocoVerificado(Bloco bloco) {
        this.ultimoBlocoVerificado = bloco;
    };

    /**
     * Desaloca um processo da memória, liberando seu bloco.
     * @param processoId O ID do processo a ser removido.
     */
    public void desalocar(int processoId) {
        Bloco atual = head;
        while (atual != null) {
            if (!atual.isLivre() && atual.processo.getId() == processoId) {
                atual.processo = null;
                System.out.println("Processo " + processoId + " desalocado.");
                
                // Tenta fundir com o bloco seguinte
                if (atual.proximo != null && atual.proximo.isLivre()) {
                    atual.tamanho += atual.proximo.tamanho;
                    atual.proximo = atual.proximo.proximo;
                    if (atual.proximo != null) {
                        atual.proximo.anterior = atual;
                    };
                };
                
                // Tenta fundir com o bloco anterior
                if (atual.anterior != null && atual.anterior.isLivre()) {
                    atual.anterior.tamanho += atual.tamanho;
                    atual.anterior.proximo = atual.proximo;
                    if (atual.proximo != null) {
                        atual.proximo.anterior = atual.anterior;
                    };
                };
                return;
            };
            atual = atual.proximo;
        };
    };
    
    /**
     * Retorna uma lista de processos atualmente na memória.
     */
    public List<Processo> getProcessosAlocados() {
        List<Processo> processos = new ArrayList<>();
        Bloco atual = head;
        while (atual != null) {
            if (!atual.isLivre()) {
                processos.add(atual.processo);
            };
            atual = atual.proximo;
        };
        return processos;
    };

    /**
     * Exibe o estado atual da memória.
     */
    public void exibirEstado() {
        System.out.print("[");
        Bloco atual = head;
        while (atual != null) {
            String status = atual.isLivre() ? "Livre(" + atual.tamanho + ")" : "P" + atual.processo.getId() + "(" + atual.tamanho + ")";
            System.out.print(status);
            if (atual.proximo != null) {
                System.out.print(" | ");
            };
            atual = atual.proximo;
        };
        System.out.println("]");
    };
};