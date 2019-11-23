package engsoft.lib.sys;

import java.util.Calendar;

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

    @Override
    public boolean devolver(Emprestimo emprestimo) {
        if (emprestimo.getExemplar().devolver()) {
            emprestimo.setDataDevolucao( Calendar.getInstance() );
            emprestimo.setEstado( EmprestimoDevolvido.getInstance() );
            
            return true;
        } else return false;
    }
    
    
}
