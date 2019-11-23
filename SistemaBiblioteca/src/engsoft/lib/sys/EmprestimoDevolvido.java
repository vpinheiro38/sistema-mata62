package engsoft.lib.sys;

public class EmprestimoDevolvido implements IEmprestimoEstado {
	
    private static EmprestimoDevolvido instance;

    private EmprestimoDevolvido() {}

    public static IEmprestimoEstado getInstance() {
        if (instance == null) {
            instance = new EmprestimoDevolvido();
        }
        return instance;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public boolean devolver(Emprestimo emprestimo) {
        return false;
    }
    
    
}
