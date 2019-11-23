package engsoft.lib.sys;

public interface ITipoUsuario {
	
	public int getLimiteEmprestimo();
	public int getTempoLimiteEmprestimo();
	public int getLimiteReserva();
	public int getQntNotificacoes();

	public boolean podeEmprestimo(Usuario usuario, Livro livro);
}
