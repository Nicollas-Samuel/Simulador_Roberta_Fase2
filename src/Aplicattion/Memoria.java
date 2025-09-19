package Aplicattion;

import java.util.LinkedList;

public class Memoria implements Comparable<Memoria> {
  private int id;
  private int memory;
  private int tamanhoAlocacao;
  
  LinkedList<String> Lista = new LinkedList<>();

  public Memoria(int id, int memory, int tamanhoAlocacao) {
    this.id = id;
    this.memory = memory;
    this.tamanhoAlocacao = tamanhoAlocacao;
  };

  public Memoria() {
  };
  
  public int getId() {
	return id;
  };

  public int getTamanhoAlocacao() {
    return tamanhoAlocacao;
  };
  
  public int getMemory() {
	return memory;
  };
  
  public void setMemory(int memory) {
	this.memory = memory;
  };
  
  public void setId(int id) {
	this.id = id;
  };
  
  public void a() {
	  System.out.println("id: " + id);
	  System.out.println("memory: " + memory);
	  System.out.println("tamanhoAlocacao: " + tamanhoAlocacao);
	  memory = memory - tamanhoAlocacao;
	  System.out.println("restante: " + memory);
	  System.out.println();
  };

  @Override
  public String toString() {
    return "Processo{" + "id=" + id + ", memory=" + memory + ", quantidadeInstrucoes=" + tamanhoAlocacao + '}';
  };

  @Override
  public int compareTo(Memoria o) {
    return Integer.compare(this.tamanhoAlocacao, o.getTamanhoAlocacao());
  };
};