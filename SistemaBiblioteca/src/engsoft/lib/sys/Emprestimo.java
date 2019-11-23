package engsoft.lib.sys;

import java.util.Date;

public class Emprestimo {
	
	private ExemplarLivro exemplar;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
	private IEmprestimoEstado estado;
	
	public Emprestimo() {
		this.estado = EmprestimoEmAndamento.getInstance();
	}
	
	public String getStatus() {
		return this.estado.getStatus();
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
    
    public String getCodigoLivro() {
        return this.exemplar.getCodigoLivro();
    }
}
