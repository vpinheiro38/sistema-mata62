package engsoft.lib;

import java.util.ArrayList;
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
import engsoft.lib.sys.AlunoPosGraduacao;
import engsoft.lib.sys.BibliotecaFachada;
import engsoft.lib.sys.Livro;
import engsoft.lib.sys.Professor;

public class SistemaBiliotecaIU {

	public static void main(String[] args) {
		Scanner s = null;
		
		BibliotecaFachada facade = BibliotecaFachada.getInstance();
		inicializar(facade);
		
		ConsultarLivroCmd livCmd = new ConsultarLivroCmd(facade);
		ConsultarProfCmd ntfCmd = new ConsultarProfCmd(facade);
		ConsultarUsuarioCmd usuCmd = new ConsultarUsuarioCmd(facade);
		DevolucaoCmd devCmd = new DevolucaoCmd(facade);
		EmprestimoCmd empCmd = new EmprestimoCmd(facade);
		ObservarCmd obsCmd = new ObservarCmd(facade);
		ReservarCmd resCmd = new ReservarCmd(facade);
		SairCmd saiCmd = new SairCmd(facade);
		
		try {
            s = new Scanner(System.in);
			
			while (s.hasNext()) {
				String cmd = s.next();
				String[] arg = s.nextLine().split(" ");
				
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
	
	private static void inicializar(BibliotecaFachada fachada) {
		fachada.addUsuario("João da Silva", "123", new AlunoGraduacao());
		fachada.addUsuario("Luiz Fernando Rodrigues", "456", new AlunoPosGraduacao());
		fachada.addUsuario("Pedro Paulo", "789", new AlunoGraduacao());
		fachada.addUsuario("Carlos Lucena", "100", new Professor());		
		
		ArrayList<String> autores = new ArrayList<String>();
		
		autores.add("Ian Sommervile");
		Livro livro = fachada.addLivro("100", "Engenharia de Software", "AddisonWesley", autores, 6, 2000);
		livro.addExemplar("01");
		livro.addExemplar("02");
		autores.clear();
		
		autores.add("Grady Booch");
		autores.add("James Rumbaugh");
		autores.add("Ivar Jacobson");
		livro = fachada.addLivro("101", "UML – Guia do Usuário", "Campus", autores, 7, 2000);
		livro.addExemplar("03");
		autores.clear();
		
		autores.add("Steve McConnell");
		livro = fachada.addLivro("200", "Code Complete", "Microsoft Press", autores, 2, 2014);
		livro.addExemplar("04");
		autores.clear();
		
		autores.add("Robert Martin");
		livro = fachada.addLivro("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", autores, 1, 2002);
		livro.addExemplar("05");
		autores.clear();
		
		autores.add("Martin Fowler");
		livro = fachada.addLivro("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", autores, 1, 1999);
		livro.addExemplar("06");
		livro.addExemplar("07");
		autores.clear();
		
		autores.add("Norman Fenton");
		autores.add("James Bieman");
		livro = fachada.addLivro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", autores, 3, 2014);
		autores.clear();
		
		autores.add("Erich Gamma");
		autores.add("Richard Helm");
		autores.add("Ralph Johnson");
		autores.add("John Vlissides");
		livro = fachada.addLivro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", autores, 1, 1994);
		livro.addExemplar("08");
		livro.addExemplar("09");
		autores.clear();
		
		autores.add("Martin Fowler");
		livro = fachada.addLivro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", autores, 3, 2003);
		autores.clear();
	}

}
