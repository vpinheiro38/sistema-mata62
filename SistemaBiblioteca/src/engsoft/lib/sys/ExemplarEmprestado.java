package engsoft.lib.sys;

import engsoft.lib.help.Mensagens;

public class ExemplarEmprestado implements IExemplarEstado {

	private static ExemplarEmprestado instance;
	private ExemplarEmprestado() {}
	
	public static IExemplarEstado getInstance() {
		if (instance == null) {
			instance = new ExemplarEmprestado();
		}
		return instance;
	}
	
	@Override
	public boolean disponivel() {
		return false;
	}

	@Override
	public boolean emprestar(ExemplarLivro exemplar, Emprestimo emprestimo) {
		System.out.println(Mensagens.EXEMPLAR_EMPRESTADO);
		return false;
	}

	@Override
	public String getStatus() {
		return Mensagens.EMPRESTADO;
	}
	  
	@Override
	public boolean devolver(ExemplarLivro exemplar) {
	    exemplar.setEstado(ExemplarDisponivel.getInstance());
	    exemplar.setEmprestimo(null);
	
	    return true;
	}

}
