package engsoft.lib.sys;

public class AlunoPosGraduacao extends Usuario {
	
	private int tempoLimiteEmprestimo = 4;
	private int limiteEmprestimo = 4;
	
	public int getLimiteEmprestimo() {
		return limiteEmprestimo;
	}
	
	public int getTempoLimiteEmprestimo() {
		return tempoLimiteEmprestimo;
	}
}
