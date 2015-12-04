/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.model;

/**
 *
 * @author lucas
 */
public class Produto implements Tributaveis
{
    private String nome;
    private double preco;

    public Produto(String nome, double preco) throws NomeException{
        this.setNome(nome);
        this.preco = preco;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) throws NomeException
    {
        if(nome.length() >= 3)
            this.nome = nome;
        else
            throw new NomeException();
    }

    public double getPreco() 
    {
        return preco;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    @Override
    public double valorTotalImposto(Imposto[] impostos) throws NullPointerException, EmptyException 
    {
        if(impostos.length == 0 || impostos == null) {
            throw new EmptyException("Valor não calculado, favor recalcular");
        }
        
        double valorTotalImposto = 0;
        
        for(Imposto imposto : impostos) {
            valorTotalImposto += imposto.getValorImposto();
        }
        
        return valorTotalImposto;
    }
    
}
