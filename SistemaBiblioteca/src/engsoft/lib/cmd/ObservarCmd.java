package engsoft.lib.cmd;

import engsoft.lib.help.Mensagens;
import engsoft.lib.sys.BibliotecaFachada;

public class ObservarCmd extends Comando {

	public ObservarCmd(BibliotecaFachada facade) {
		super(facade);
	}
	
	@Override
	public void executar(String[] args) {
		this.fachada.criarObservador(args[0], args[1]);
		
		System.out.println(Mensagens.OBS_CRIADO);
	}

}
