package engsoft.lib.sys;

import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	
    private ExemplarLivro exemplar;
    private Calendar dataEmprestimo;
    private Calendar dataDevolucao;

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

    public Calendar getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public Calendar getDataDevolucao() {
        return this.dataDevolucao;
    }
    
    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public void setEstado(IEmprestimoEstado estado) {
        this.estado = estado;
    }

    public ExemplarLivro getExemplar() {
        return this.exemplar;
    }
    
    public String getCodigoLivro() {
        return this.exemplar.getCodigoLivro();
    }
    
    public boolean devolver() {
        return estado.devolver(this);
    }
}
