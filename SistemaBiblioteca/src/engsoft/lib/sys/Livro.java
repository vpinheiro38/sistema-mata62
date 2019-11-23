package engsoft.lib.sys;

import java.util.ArrayList;

public class Livro {
	
	private String codigo;
	private String titulo;
	
	private String editora;
	private ArrayList<String> autores;
	private int edicao;
	private int anoPublicado;
	
	private ArrayList<ExemplarLivro> exemplares;
	private ArrayList<Observer> observers;
	
	public Livro(String codigo, String titulo, String editora, ArrayList<String> autores, int edicao, int anoPublicado) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
		this.anoPublicado = anoPublicado;
	}
	
	public void registerObserver(Observer obs) {
		observers.add(obs);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditora() {
		return editora;
	}

	public ArrayList<String> getAutores() {
		return autores;
	}

	public int getEdicao() {
		return edicao;
	}

	public int getAnoPublicado() {
		return anoPublicado;
	}

	public ArrayList<ExemplarLivro> getExemplares() {
		return exemplares;
	}

	public void setExemplares(ArrayList<ExemplarLivro> exemplares) {
		this.exemplares = exemplares;
	}
	
}
