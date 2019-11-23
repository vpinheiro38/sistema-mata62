package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;

public class ConsultarLivroCmd extends Comando {
	
	public ConsultarLivroCmd(BibliotecaFachada facade) {
		super(facade);
	}
	
	@Override
	public void executar(String[] args) {
		this.fachada.consultarLivro(args[0]);
	}
}
