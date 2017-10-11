/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.model;

/**
 *
 * @author medabot
 */
public class Imposto {
    private String nomeImposto;
    private double valorImposto;

    public Imposto(String nomeImposto) throws NomeException {
        this.setNomeImposto(nomeImposto);
    }

    public Imposto(String nomeImposto, double valorImposto) throws NomeException, Exception{
        this.setNomeImposto(nomeImposto);
        this.setValorImposto(valorImposto);
    }

    public Imposto() {
    }

    public String getNomeImposto() {
        return nomeImposto;
    }

    public void setNomeImposto(String nomeImposto) throws NomeException{
        if(!nomeImposto.isEmpty())
            this.nomeImposto = nomeImposto;
        else
            throw new NomeException();
    }

    public double getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(double valorImposto) throws Exception{
        if(valorImposto >= 0)
            this.valorImposto = valorImposto;
        else
            throw new Exception("Valor imposto inválido");
    }
    
    
    
}
