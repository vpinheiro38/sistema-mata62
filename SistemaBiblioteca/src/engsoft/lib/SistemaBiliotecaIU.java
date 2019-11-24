package engsoft.lib;

import java.util.Scanner;

import engsoft.lib.cmd.ConsultarLivroCmd;
import engsoft.lib.cmd.ConsultarProfCmd;
import engsoft.lib.cmd.ConsultarUsuarioCmd;
import engsoft.lib.cmd.DevolucaoCmd;
import engsoft.lib.cmd.EmprestimoCmd;
import engsoft.lib.cmd.ObservarCmd;
import engsoft.lib.cmd.ReservarCmd;
import engsoft.lib.cmd.SairCmd;
import engsoft.lib.sys.AlunoGraduacao;
import engsoft.lib.sys.BibliotecaFachada;
import engsoft.lib.sys.ITipoUsuario;
import engsoft.lib.sys.Livro;
import engsoft.lib.sys.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SistemaBiliotecaIU {

	public static void main(String[] args) {
		Scanner s = null;
		
		BibliotecaFachada facade = new BibliotecaFachada();
		
		ConsultarLivroCmd livCmd = new ConsultarLivroCmd(facade);
		ConsultarProfCmd ntfCmd = new ConsultarProfCmd(facade);
		ConsultarUsuarioCmd usuCmd = new ConsultarUsuarioCmd(facade);
		DevolucaoCmd devCmd = new DevolucaoCmd(facade);
		EmprestimoCmd empCmd = new EmprestimoCmd(facade);
		ObservarCmd obsCmd = new ObservarCmd(facade);
		ReservarCmd resCmd = new ReservarCmd(facade);
		SairCmd saiCmd = new SairCmd(facade);
		
		try {
                    Map<String, Livro> livros = new HashMap<>();
                    Map<String, Usuario> usuarios = new HashMap<>();
                    
                   
                    usuarios.put("igor", new Usuario("1234", "igor", new AlunoGraduacao()));
                    livros.put("livro1", new Livro(
                        "livro1", 
                        "As cronicas", 
                        "UFBA",
                        new ArrayList<>(),
                        1,
                        2
                    ));
                    
                    facade.setUsuarios(usuarios);
                    facade.setLivros(livros);
                    
                    s = new Scanner(System.in);
			
			while (s.hasNext()) {
				String cmd = s.next();
				String[] arg = s.next().split(" ");

                                switch(cmd) {
					case "liv":
						livCmd.executar(arg);
                                                break;
					case "ntf":
						ntfCmd.executar(arg);
                                                break;
					case "usu":
						usuCmd.executar(arg);
                                                break;
					case "dev":
						devCmd.executar(arg);
                                                break;
					case "emp":
						empCmd.executar(arg);
                                                break;
					case "obs":
						obsCmd.executar(arg);
                                                break;
					case "res":
						resCmd.executar(arg);
                                                break;
					case "sai":
						saiCmd.executar(arg);
                                                break;
				}
			}
		} finally {
			s.close();
		}
	}

}
