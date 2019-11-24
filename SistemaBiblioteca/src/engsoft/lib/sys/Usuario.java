package engsoft.lib.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import engsoft.lib.help.Help;
import engsoft.lib.help.Mensagens;

public class Usuario {
	
	private String codigo;
	private String nome;
	
	private List<Reserva> reservas;
	private List<Emprestimo> emprestimos;
	
	private ITipoUsuario tipoUsuario;
	
	public Usuario(String codigo, String nome, ITipoUsuario tipoUsuario) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
        this.reservas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();    
	}
	
	public boolean criarEmprestimo(ExemplarLivro exemplar) {
		boolean podeEmprestar = this.tipoUsuario.podeEmprestimo(this, exemplar.getLivro());
		
		if (podeEmprestar) {
			Date dataEmprestimo = Help.getHoje();
			Date dataDevolucao = Help.criarData(this.tipoUsuario.getTempoLimiteEmprestimo());
			
			Emprestimo emp = new Emprestimo(this, dataEmprestimo, dataDevolucao);
			if (exemplar.emprestar(emp)) {
				emprestimos.add(emp);
				removeReserva(exemplar.getLivro());
			} else {
				return false;
			}
		}
		
		return podeEmprestar;
	}
        
	public boolean reservarLivro(Livro livro) {
	    if (this.getReserva(livro) != null) {
	        System.out.println(Mensagens.LIVRO_JA_RESERVADO);
	        return false;
	    }
	    
	    if (!tipoUsuario.podeReservar(this)) {
	        System.out.println(Mensagens.MAXIMO_RESERVAS);
	        return false;
	    }
	    
	    this.addReserva(livro);
	    
	    return true;
	}
  
	public List<Emprestimo> getEmprestimosLivro(Livro livro) {
	    List<Emprestimo> emprestimosLivro = new ArrayList<>();
            
	    for (Emprestimo emprestimo : emprestimos) {
	        // String codLivro = emprestimo.getCodigoLivro();
	        if (livro == emprestimo.getExemplar().getLivro()) {
	            emprestimosLivro.add(emprestimo);
	        }
	    }
	
	    return emprestimosLivro;
	}
	
	public boolean devolverLivro(Livro livro) {
	    List<Emprestimo> emprestimosLivro = this.getEmprestimosLivro(livro);
	
	    for (Emprestimo emprestimo: emprestimosLivro) {
	        if (emprestimo.getLivro() == livro) {
	            boolean resp = emprestimo.devolver();
	
	            if (resp)
	            	return true;
	            else {
	                System.out.println(Mensagens.LIVRO_JA_DEVOLVIDO);
	                return false;
	            }
	        }
	    }
	
	    System.out.println(Mensagens.EMPRESTIMO_INEXISTENTE);
	
	    return false;
	}
	
	public boolean removeReserva(Livro livro) {
		for (Reserva res : reservas) {
			if (res.getLivro() == livro) {
				reservas.remove(res);
				livro.removerReserva(res);
				return true;
			}
		}
		return false;
	}
	
	public ITipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
        
    public void addReserva(Livro livro) {
        Reserva novaReserva = new Reserva(this, livro, Help.getHoje());
        
        livro.reservar(novaReserva);
        
        reservas.add(novaReserva);
    }
	
	public Reserva getReserva(Livro livro) {
		for (Reserva res : reservas) {
			if (res.getLivro() == livro) {
				return res;
			}
		}
		
		return null;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
}
