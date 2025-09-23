package Applicattion;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import algoritimos.*;

public class Main {
    public static void main(String[] args) {
        Algorithm[] algoritmos = {
            new first_fit(),
            new next_fit(),
            new best_fit(),
            new worst_fit()
        };

        for (Algorithm algoritmo : algoritmos) {
            executarSimulacao(algoritmo);
        };
    };
    private static final int DURACAO_SIMULACAO_SEGUNDOS = 100;
    private static final int TAMANHO_MEMORIA = 1000;
    private static final int PROCESSOS_POR_SEGUNDO = 2;
    
    private static void executarSimulacao(Algorithm algoritmo) {
        System.out.println("\n=======================================================");
        System.out.println("INICIANDO SIMULAÇÃO COM: " + algoritmo.getClass().getSimpleName());
        System.out.println("=======================================================");

        Memoria memoria = new Memoria(TAMANHO_MEMORIA);
        GeredorProcessos gerador = new GeredorProcessos();
        Random random = new Random();

        for (int segundo = 1; segundo <= DURACAO_SIMULACAO_SEGUNDOS; segundo++) {
            System.out.println("\n--- Segundo " + segundo + " ---");

            // 1. Criação e Alocação de 2 processos
            for (int i = 0; i < PROCESSOS_POR_SEGUNDO; i++) {
                Processo novoProcesso = gerador.gerar();
                System.out.println("Tentando alocar " + novoProcesso);
                boolean alocado = algoritmo.alocar(novoProcesso, memoria);
                if (alocado) {
                    System.out.println("=> Sucesso: " + novoProcesso + " alocado.");
                } else {
                    System.out.println("=> Falha: Espaço insuficiente para " + novoProcesso + ". Processo descartado.");
                };
            };

            // 2. Sorteio para sair 1 ou 2 processos da memória
            List<Processo> processosAlocados = memoria.getProcessosAlocados();
            if (!processosAlocados.isEmpty()) {
                int processosARemover = random.nextInt(2) + 1; // Sorteia 1 ou 2
                Collections.shuffle(processosAlocados); // Embaralha para pegar aleatórios

                for (int i = 0; i < processosARemover && !processosAlocados.isEmpty(); i++) {
                    Processo processoParaRemover = processosAlocados.remove(0);
                    memoria.desalocar(processoParaRemover.getId());
                };
            };
            
            System.out.print("Estado da Memória: ");
            memoria.exibirEstado();
        };
        
        System.out.println("\n--- FIM DA SIMULAÇÃO PARA " + algoritmo.getClass().getSimpleName() + " ---");
    };
};