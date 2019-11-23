package engsoft.lib.sys;

public class Professor implements TipoUsuario, Observer {
	
	private int tempoLimiteEmprestimo = 7;
	private int limiteEmprestimo = -1; // N�o possui limite para ter empr�stimo
	
	public int getLimiteEmprestimo() {
		return limiteEmprestimo;
	}
	
	public int getTempoLimiteEmprestimo() {
		return tempoLimiteEmprestimo;
	}

	@Override
	public int getQntNotificacoes() {
		return 0;
	}

}
