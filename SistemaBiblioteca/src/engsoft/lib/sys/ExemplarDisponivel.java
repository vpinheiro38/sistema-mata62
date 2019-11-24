package engsoft.lib.sys;

import engsoft.lib.help.Mensagens;

public class ExemplarDisponivel implements IExemplarEstado {
	
	private static ExemplarDisponivel instance;
	private ExemplarDisponivel() {}
	
	public static ExemplarDisponivel getInstance() {
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
		return "Dispon�vel";
	}

	@Override
	public boolean devolver(ExemplarLivro exemplar) {
		System.out.println(Mensagens.EXEMPLAR_JA_DEVOLVIDO);
		return false;
	}
}
