package engsoft.lib.sys;

public class ExemplarLivro {
	
    private String codigoExemplar;
    private Livro livro;
    
    private IExemplarEstado estado;

    public ExemplarLivro(Livro livro, String codigoExemplar) {
        this.livro = livro;
        this.codigoExemplar = codigoExemplar;
        this.estado = ExemplarDisponivel.getInstance();
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

    public void setEstado(IExemplarEstado estado) {
        this.estado = estado;
    }

    public String getCodigoLivro() {
        return this.livro.getCodigo();
    }
    
    public boolean devolver() {
        return estado.devolver(this);
    }
}
