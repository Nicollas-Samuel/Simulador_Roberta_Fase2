package Applicattion;

public class Processo {
	private int id;
	private int tamanho;

	public Processo(int id, int tamanho) {
	    this.id = id;
		this.tamanho = tamanho;
	};

	public Processo() {
	};

	public int getTamanho() {
		return tamanho;
	};
	
	public int getId() {
		return id;
	};

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	};

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", tamanho=" + tamanho + "]";
	};
};