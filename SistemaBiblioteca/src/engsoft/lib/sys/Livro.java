package engsoft.lib.sys;

import java.util.ArrayList;
import java.util.List;

public class Livro implements ISubject {
	
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
                
        this.reservas = new ArrayList<Reserva>();
        this.exemplares = new ArrayList<ExemplarLivro>(); 
        this.observers = new ArrayList<IObserver>();
	}
	
	public ExemplarLivro exemplarDisponivel() {
		for (ExemplarLivro exemplar : exemplares) {
			if (exemplar.disponivel()) {
				return exemplar;
			}
		}
		
		return null;
	}
	
	public List<ExemplarLivro> getExemplaresDisponiveis() {
		ArrayList<ExemplarLivro> disponiveis = new ArrayList<>();
		
		for (ExemplarLivro exemplar : exemplares) {
			if (exemplar.disponivel()) {
				disponiveis.add(exemplar);
			}
		}
		
		return disponiveis;
	}
	
	@Override
	public boolean registerObserver(IObserver obs) {
		observers.add(obs);
		return true;
	}

	@Override
	public boolean removeObserver(IObserver obs) {
		int index = observers.indexOf(obs);
		observers.remove(index);
		return true;
	}

	@Override
	public void notifyObservers() {
		for (IObserver obs : observers) {
			obs.update();
		}
	}
	
	public void reservasChanged() {
		if (reservas.size() >= 2)
			notifyObservers();
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
		return this.exemplares;
	}
	
	public ExemplarLivro addExemplar(String codigo) {
		ExemplarLivro exemplar = new ExemplarLivro(this, codigo);
		this.exemplares.add(exemplar);
		return exemplar;
	}
        
    public boolean reservar(Reserva reserva) {
        this.reservas.add(reserva);
        reservasChanged();
        
        return true;
    }

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void removerReserva(Reserva reserva) {
		int index = reservas.indexOf(reserva);
		reservas.remove(index);
	}
	
}
