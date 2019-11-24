package engsoft.lib.sys;

import engsoft.lib.help.Help;

public class EmprestimoEmAndamento implements IEmprestimoEstado {
	
	private static EmprestimoEmAndamento instance;
	private EmprestimoEmAndamento() {}
	
	public static EmprestimoEmAndamento getInstance() {
		if (instance == null) {
			instance = new EmprestimoEmAndamento();
		}
		return instance;
	}
	
	@Override
	public boolean devolver(Emprestimo emprestimo) {
	    if (emprestimo.getExemplar().devolver()) {
	        emprestimo.setDataDevolucao(Help.getHoje());
	        emprestimo.setEstado(EmprestimoDevolvido.getInstance());
	
	        return true;
	    } else 
	    	return false;
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
