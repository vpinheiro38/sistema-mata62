package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;

public class EmprestimoCmd extends Comando {
	
	public EmprestimoCmd(BibliotecaFachada facade) {
		super(facade);
	}

	@Override
	public void executar(String[] args) {
		this.fachada.realizarEmprestimo(args[0], args[1]);
	}

}
