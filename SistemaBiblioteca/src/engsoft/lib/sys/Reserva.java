package engsoft.lib.sys;

import java.util.Date;

public class Reserva {
	
	private Usuario usuario;
	private Livro livro;
	private Date dataReserva;
	
	public Reserva(Usuario usuario) {
		this.setUsuario(usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Date getDataReserva() {
		return dataReserva;
	}
	
	public String getTituloLivro() {
		return this.livro.getTitulo();
	}
}
