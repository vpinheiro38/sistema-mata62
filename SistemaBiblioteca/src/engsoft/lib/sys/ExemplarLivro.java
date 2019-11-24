package engsoft.lib.sys;

public class ExemplarLivro {
	
	private String codigoExemplar;
	private Livro livro;
	private IExemplarEstado estado;
	private Emprestimo emprestimo;

	public ExemplarLivro(Livro livro, String codigoExemplar) {
	    this.livro = livro;
	    this.codigoExemplar = codigoExemplar;
	    this.estado = ExemplarDisponivel.getInstance();
	}
	
	public boolean emprestar(Emprestimo emp) {		
		return this.estado.emprestar(this, emp);
	}
	
	public boolean disponivel() {
		return this.estado.disponivel();
	}

	public String getTituloLivro() {
	    return this.livro.getTitulo();
	}
	
	public Livro getLivro() {
	    return livro;
	}
	
	public String getCodigoExemplar() {
	    return codigoExemplar;
	}
	
	public String getStatus() {
		return this.estado.getStatus();
	}
	
	public boolean devolver() {
	    return estado.devolver(this);
	}

	public void setEstado(IExemplarEstado estado) {
		this.estado = estado;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	
}
