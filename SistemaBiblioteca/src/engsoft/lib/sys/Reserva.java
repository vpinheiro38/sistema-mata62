package engsoft.lib.sys;

public class Reserva {
	private Usuario usuario;
	
	public Reserva(Usuario usuario) {
		this.setUsuario(usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
