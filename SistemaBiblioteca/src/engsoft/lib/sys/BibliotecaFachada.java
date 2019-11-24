package engsoft.lib.sys;

import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import engsoft.lib.help.Mensagens;

public class BibliotecaFachada {
	
	private static BibliotecaFachada instance;
	
	private Map<String, Livro> livros;
	private Map<String, Usuario> usuarios;
	
	private BibliotecaFachada () {
        livros = new HashMap<>();
        usuarios = new HashMap<>();
	}
	
	public static BibliotecaFachada getInstance() {
		if (instance == null) {
			instance = new BibliotecaFachada();
		}
		return instance;
	}
	
	public void realizarEmprestimo(String codUsuario, String codLivro) {
		Usuario usuario = getUsuario(codUsuario);
		Livro livro = getLivro(codLivro);
		ExemplarLivro exemplar = livro.exemplarDisponivel();
				
		if (exemplar != null) {
			if (usuario.criarEmprestimo(exemplar))
				System.out.println(String.format(Mensagens.EMPRESTIMO_SUCESSO, livro.getTitulo(), usuario.getNome()));
		} else {
			System.out.println(Mensagens.LIVRO_INDISPONIVEL);
		}
	}
	
	public void realizarDevolucao(String codUsuario, String codLivro) {
		Usuario usuario = getUsuario(codUsuario);
		Livro livro = getLivro(codLivro);

		boolean resp = usuario.devolverLivro(livro);

		if (resp) {
			System.out.println(Mensagens.DEVOLUCAO_SUCESSO);
		}
	}
	
	public void realizarReserva(String codUsuario, String codLivro) {
            Usuario usuario = getUsuario(codUsuario);
            Livro livro = getLivro(codLivro);
            
            if (usuario.reservarLivro(livro)) {
                System.out.println(Mensagens.RESERVAR_LIVRO_SUCESSO);
            }
	}
	
	public void consultarLivro(String codLivro) {
            Livro livro = getLivro(codLivro);
            
            System.out.println("Livro " + livro.getCodigo());
            System.out.println("Título: " + livro.getTitulo());
            
            System.out.println(Mensagens.RESERVAS + ": " + livro.getReservas().size());
            for (Reserva reserva: livro.getReservas()) {
                Usuario usuario = reserva.getUsuario();
                System.out.println("- " + usuario.getNome() + " reservado em " + reserva.getDataReserva());
            }

            System.out.println("Exemplares:");
            if (livro.getExemplares().size() > 0) {            	
            	for (ExemplarLivro exemplar: livro.getExemplares()) {
            		System.out.print("- Código: " + exemplar.getCodigoExemplar() 
            		+ " | Status: " + exemplar.getStatus()
            				);
            		
            		if (exemplar.getStatus().equals(Mensagens.EMPRESTADO)) {
            			Emprestimo emp = exemplar.getEmprestimo();
            			System.out.print(
            					" | Usuário: " + emp.getUsuario().getNome()
            					+ " | Data do empréstimo: " + emp.getDataEmprestimo()
            					+ " | Data de devolução: " + emp.getDataDevolucao()
            					);
            		}
            		
            		System.out.println("");
            	}
            } else {
            	System.out.println(Mensagens.LIVRO_SEM_EXEMPLARES);
            }
	}
	
	public void consultarUsuario(String codUsuario) {
		Usuario usuario = getUsuario(codUsuario);
		List<Emprestimo> emprestimos = usuario.getEmprestimos();
		List<Reserva> reservas = usuario.getReservas();
	
		String resposta = String.format(Mensagens.CONSULTA_USUARIO, usuario.getNome()) + "\n" + Mensagens.EMPRESTIMOS + ": \n";
		
		if (emprestimos.size() > 0) {
			for (Emprestimo emp : emprestimos) {
				String livro = emp.getTituloLivro();
				Date dataEmp = emp.getDataEmprestimo();
				
				String status = emp.getStatus();
				String respEmp = "- Livro " + livro + " emprestado em " + dataEmp.toString() + ". Status: " + status + ". ";
				if (status == Mensagens.DEVOLVIDO) {
					respEmp += String.format(Mensagens.DEVOLVIDO_DATA, emp.getDataDevolucao().toString());
				} else {
					respEmp += String.format(Mensagens.DEVOLUCAO_PREVISTA, emp.getDataDevolucao().toString());
				}
				
				resposta += respEmp + "\n";
			}
		} else {
			resposta += Mensagens.SEM_EMPRESTIMO + "\n";
		}
		
		resposta += Mensagens.RESERVAS + ": \n";
		
		if (reservas.size() > 0) {			
			for (Reserva res : reservas) {
				String livro = res.getTituloLivro();
				Date solicitacao = res.getDataReserva();
				
				resposta += String.format(Mensagens.LIVRO_RESERVAS, livro, solicitacao.toString());
			}			
		} else {
			resposta += Mensagens.SEM_RESERVA + "\n";
		}
		
		System.out.println(resposta);
	}
	
	public void consultarProfessor(String codUsuario) {
		Usuario professor = getUsuario(codUsuario);
		int notificacoes = professor.getTipoUsuario().getQntNotificacoes();
		
		String resposta = String.format(Mensagens.PROF_NOTIFICADO, notificacoes);
		System.out.println(resposta);
	}
	
	public void criarObservador(String codUsuario, String codLivro) {
		Livro livro = getLivro(codLivro);
		Usuario professor = getUsuario(codUsuario);
		
		livro.registerObserver((IObserver) professor.getTipoUsuario());
	}

	public Map<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Map<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Usuario addUsuario(String nome, String codigo, ITipoUsuario tipoUsuario) {
		Usuario usuario = new Usuario(codigo, nome, tipoUsuario);
		this.usuarios.put(codigo, usuario);
		return usuario;
	}
	
	public Usuario getUsuario(String codigo) {
		return this.usuarios.get(codigo);
	}

	public Map<String, Livro> getLivros() {		
		return livros;
	}

	public void setLivros(Map<String, Livro> livros) {
		this.livros = livros;
	}
	
	public Livro getLivro(String codigo) {
		return this.livros.get(codigo);
	}
	
	public Livro addLivro(String codigo, String titulo, String editora, List<String> autores, int edicao, int anoPublicado) {
		Livro livro = new Livro(codigo, titulo, editora, autores, edicao, anoPublicado);
		this.livros.put(codigo, livro);
		return livro;
	}
}
