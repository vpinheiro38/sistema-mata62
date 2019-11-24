package engsoft.lib.sys;

import engsoft.lib.help.Mensagens;

public class EmprestimoAtrasado implements IEmprestimoEstado {
	
	private static EmprestimoAtrasado instance;
	
	private EmprestimoAtrasado() {}

	public static EmprestimoAtrasado getInstance() {
		if (instance == null) {
			instance = new EmprestimoAtrasado();
		}
		return instance;
	}

	@Override
	public boolean atrasado(Emprestimo emp) {
		return true;
	}

	@Override
	public String getStatus(Emprestimo emp) {
		return Mensagens.ATRASADO;
	}

	@Override
	public boolean devolver(Emprestimo emprestimo) {
		return false;
	}

}
