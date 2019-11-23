package engsoft.lib.cmd;

import engsoft.lib.sys.BibliotecaFachada;
import engsoft.lib.sys.Livro;

public class ConsultarLivroCmd extends Comando {
	
	public ConsultarLivroCmd(BibliotecaFachada facade) {
		super(facade);
	}
	
	@Override
	public void executar(String[] args) {
		String resposta = this.fachada.consultarLivro(args[0]);
		
		System.out.println(resposta);
	}
}
