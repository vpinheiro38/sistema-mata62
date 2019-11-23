package engsoft.lib.sys;

public class EmprestimoAtrasado implements IEmprestimoEstado {
	
	private static EmprestimoAtrasado instance;
	
	private EmprestimoAtrasado() {}

	public static IEmprestimoEstado getInstance() {
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
	public String getStatus() {
		return "Atrasado";
	}

}
