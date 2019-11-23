package engsoft.lib.sys;

public class ExemplarDisponivel implements IExemplarEstado {
	
	private static ExemplarDisponivel instance;
	private ExemplarDisponivel() {}
	
	public static IExemplarEstado getInstance() {
		if (instance == null) {
			instance = new ExemplarDisponivel();
		}
		return instance;
	}

	@Override
	public boolean disponivel() {
		return true;
	}

	@Override
	public boolean emprestar(ExemplarLivro exemplar, Emprestimo emprestimo) {
		emprestimo.setExemplar(exemplar);
		exemplar.setEmprestimo(emprestimo);
		exemplar.setEstado(ExemplarEmprestado.getInstance());
		return true;
	}

	@Override
	public String getStatus() {
		return "Disponível";
	}

}
