package Aplicattion;

import java.util.LinkedList;

public class Memoria implements Comparable<Memoria> {
  private int id;
  private int tamanhoAlocacao;
  
  LinkedList<String> Lista = new LinkedList<>();

  public Memoria(int id, int tamanhoAlocacao) {
    this.id = id;
    this.tamanhoAlocacao = tamanhoAlocacao;
  };

  public void reduzirAlocacao() {
    if (tamanhoAlocacao >= 0) {
      this.tamanhoAlocacao--;
    };
  };

  public int getTamanhoAlocacao() {
    return tamanhoAlocacao;
  };

  @Override
  public String toString() {
    return "Processo{" + "id=" + id + ", quantidadeInstrucoes=" + tamanhoAlocacao + '}';
  };

  @Override
  public int compareTo(Memoria o) {
    return Integer.compare(this.tamanhoAlocacao, o.getTamanhoAlocacao());
  };
};