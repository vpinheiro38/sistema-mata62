package engsoft.lib.sys;

import java.util.Date;

public class Emprestimo {
	
	private ExemplarLivro exemplar;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
	private IEmprestimoEstado estado;
	
	public Emprestimo(Date dataEmprestimo, Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
		this.dataEmprestimo = dataEmprestimo;
		this.estado = EmprestimoEmAndamento.getInstance();
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
	
	public ExemplarLivro getExemplar() {
		return exemplar;
	}

	public void setExemplar(ExemplarLivro exemplar) {
		this.exemplar = exemplar;
	}

}
