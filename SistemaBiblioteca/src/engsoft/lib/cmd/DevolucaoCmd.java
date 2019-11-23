package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;

public class DevolucaoCmd extends Comando {

	public DevolucaoCmd(BibliotecaFachada facade) {
		super(facade);
	}
	
	@Override
	public void executar(String[] args) {
		String resposta = this.fachada.realizarDevolucao(args[0], args[1]);
		
		System.out.println(resposta);
	}

}
