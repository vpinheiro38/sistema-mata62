package engsoft.lib.sys;

public class Professor extends Usuario {
	
	private int tempoLimiteEmprestimo = 7;
	private int limiteEmprestimo = -1; // Não possui limite para ter empréstimo
	
	public int getLimiteEmprestimo() {
		return limiteEmprestimo;
	}
	
	public int getTempoLimiteEmprestimo() {
		return tempoLimiteEmprestimo;
	}

}
