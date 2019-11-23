package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;

public class ConsultarProfCmd extends Comando {

	public ConsultarProfCmd(BibliotecaFachada facade) {
		super(facade);
	}
	
	@Override
	public void executar(String[] args) {
		this.fachada.consultarProfessor(args[0]);
	}

}
