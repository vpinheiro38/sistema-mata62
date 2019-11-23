package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;

public class ConsultarUsuarioCmd extends Comando {

	public ConsultarUsuarioCmd(BibliotecaFachada facade) {
		super(facade);
	}
	
	@Override
	public void executar(String[] args) {
		String resposta = this.fachada.consultarUsuario(args[0]);
		
		System.out.println(resposta);
	}

}
