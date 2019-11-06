package engsoft.lib.sys;

public class AlunoGraduacao extends Usuario {
	
	private int tempoLimiteEmprestimo = 3;
	private int limiteEmprestimo = 3;
	
	public int getLimiteEmprestimo() {
		return limiteEmprestimo;
	}
	
	public int getTempoLimiteEmprestimo() {
		return tempoLimiteEmprestimo;
	}

}
