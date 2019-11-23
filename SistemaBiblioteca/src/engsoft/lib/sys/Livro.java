package engsoft.lib.sys;

import java.util.List;

public class Livro {
	
	private String codigo;
	private String titulo;
	
	private String editora;
	private List<String> autores;
	private int edicao;
	private int anoPublicado;
	
	private List<ExemplarLivro> exemplares;
	private List<Reserva> reservas;
	private List<IObserver> observers;
	
	public Livro(String codigo, String titulo, String editora, List<String> autores, int edicao, int anoPublicado) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
		this.anoPublicado = anoPublicado;
	}
	
	public ExemplarLivro exemplarDisponivel() {
		for (ExemplarLivro exemplar : exemplares) {
			if (exemplar.disponivel()) {
				return exemplar;
			}
		}
		
		return null;
	}
	
	public void registerObserver(IObserver obs) {
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

	public List<String> getAutores() {
		return autores;
	}

	public int getEdicao() {
		return edicao;
	}

	public int getAnoPublicado() {
		return anoPublicado;
	}

	public List<ExemplarLivro> getExemplares() {
		return exemplares;
	}

	public void setExemplares(List<ExemplarLivro> exemplares) {
		this.exemplares = exemplares;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
}
