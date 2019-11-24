package engsoft.lib.sys;

import engsoft.lib.help.Mensagens;

public class EmprestimoDevolvido implements IEmprestimoEstado {
	
    private static EmprestimoDevolvido instance;

    private EmprestimoDevolvido() {}

    public static EmprestimoDevolvido getInstance() {
        if (instance == null) {
            instance = new EmprestimoDevolvido();
        }
        return instance;
    }

    @Override
    public boolean devolver(Emprestimo emprestimo) {
    	System.out.println(Mensagens.EMPRESTIMO_JA_DEVOLVIDO);
        return false;
    }

    @Override
    public boolean atrasado(Emprestimo emp) {
        return false;
    }

    @Override
    public String getStatus(Emprestimo emp) {
        return Mensagens.DEVOLVIDO;
    }    
    
}
