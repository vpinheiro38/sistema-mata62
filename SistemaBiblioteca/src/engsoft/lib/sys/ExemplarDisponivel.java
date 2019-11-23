/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.lib.sys;

/**
 *
 * @author igor
 */
public class ExemplarDisponivel implements IExemplarEstado {
    
    private static ExemplarDisponivel instance;

    private ExemplarDisponivel() {}

    public static IExemplarEstado getInstance() {
        if (instance == null) {
            instance = new ExemplarDisponivel();
        }
        
        return instance;
    }

    @Override
    public boolean disponivel() {
        
    }

    @Override
    public boolean emprestar(Emprestimo emprestimo) {

    }

    @Override
    public String getStatus() {

    }

    @Override
    public Emprestimo getEmprestimo(ExemplarLivro exemplar) {

    }

    @Override
    public boolean devolver(ExemplarLivro exemplar) {
        exemplar.setEstado( ExemplarDisponivel.getInstance() );
        
        return true;
    }
    
}
