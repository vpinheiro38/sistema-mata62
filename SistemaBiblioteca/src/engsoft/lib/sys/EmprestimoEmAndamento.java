package engsoft.lib.sys;

import engsoft.lib.help.Help;

public class EmprestimoEmAndamento implements IEmprestimoEstado {
	
	private static EmprestimoEmAndamento instance;
	
	private EmprestimoEmAndamento() {}

	public static IEmprestimoEstado getInstance() {
		if (instance == null) {
			instance = new EmprestimoEmAndamento();
		}
		return instance;
	}
	
	@Override
	public String getStatus(Emprestimo emp) {
		if (emp.getDataDevolucao().after(Help.getHoje())) {
			return "Em Andamento";
		} else {
			emp.setEstado(EmprestimoAtrasado.getInstance());
			return emp.getStatus();
		}
	}

	@Override
	public boolean atrasado(Emprestimo emp) {
		if (emp.getDataDevolucao().after(Help.getHoje())) {
			return false;
		} else {
			emp.setEstado(EmprestimoAtrasado.getInstance());
			return emp.atrasado();
		}
	}
}
