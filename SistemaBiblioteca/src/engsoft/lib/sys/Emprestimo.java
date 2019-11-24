package engsoft.lib.sys;

import java.util.Date;

public class Emprestimo {
    
	private Usuario usuario;
	private ExemplarLivro exemplar;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
	private IEmprestimoEstado estado;
	  
	public Emprestimo(Usuario usuario, Date dataEmprestimo, Date dataDevolucao) {
		this.usuario = usuario;
		this.dataDevolucao = dataDevolucao;
		this.dataEmprestimo = dataEmprestimo;
		this.estado = EmprestimoEmAndamento.getInstance();
	}
        
    public Usuario getUsuario() {
        return usuario;
    }
    
	public void setDataDevolucao(Date dataDevolucao) {
	    this.dataDevolucao = dataDevolucao;
	}
	
	public ExemplarLivro getExemplar() {
	    return this.exemplar;
	}
	
	public Livro getLivro() {
		return this.exemplar.getLivro();
	}
	    
	public boolean devolver() {
	    return estado.devolver(this);
	}
	
	public void setEstado(IEmprestimoEstado estado) {
		this.estado = estado;
	}
	
	public boolean atrasado() {
		return this.estado.atrasado(this);
	}
	
	public String getStatus() {
		return this.estado.getStatus(this);
	}
	
	public String getTituloLivro() {
		return exemplar.getTituloLivro();
	}
	
	public Date getDataEmprestimo() {
		return this.dataEmprestimo;
	}
	
	public Date getDataDevolucao() {
		return this.dataDevolucao;
	}	

	public void setExemplar(ExemplarLivro exemplar) {
		this.exemplar = exemplar;
	}
}
