package engsoft.lib.sys;

public class ExemplarLivro {
	
	private String codigoExemplar;
	private Livro livro;
	private boolean emprestado = false;

	public ExemplarLivro(Livro livro, String codigoExemplar) {
		this.livro = livro;
		this.codigoExemplar = codigoExemplar;
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

	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	
	public String getCodigoLivro() {
		return this.livro.getCodigo();
	}
}
