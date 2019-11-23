package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;

public class ConsultarProfCmd extends Comando {

	public ConsultarProfCmd(BibliotecaFachada facade) {
		super(facade);
	}
	
	@Override
	public void executar(String[] args) {
		String resposta = this.fachada.consultarProfessor(args[0]);
		
		System.out.println(resposta);
	}

}
