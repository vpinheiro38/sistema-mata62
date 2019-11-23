package engsoft.lib.sys;

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
	public String getStatus() {
		return null;
	}
}
