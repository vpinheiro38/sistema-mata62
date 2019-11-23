package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;

public class EmprestimoCmd extends Comando {
	
	public EmprestimoCmd(BibliotecaFachada facade) {
		super(facade);
	}

	@Override
	public void executar(String[] args) {
		String resposta = this.fachada.realizarEmprestimo(args[0], args[1]);
		
		System.out.println(resposta);
	}

}
