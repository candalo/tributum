/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.model;


public abstract class Colaborador implements Tributaveis
{
   private String nome;
   private String endereco;
   private String telefone;
   
   public Colaborador(String nome, String endereco, String telefone) throws Exception
   {
        this.setNome(nome);
        this.endereco = endereco;
        setTelefone(telefone);
   } 
   
   public String getNome()
   {
        return this.nome;   
   }

   public void setNome(String nome)
   {
           this.nome = nome; 
   }  	

   public String getEndereco()
   {
        return this.endereco; 
   }
 
   public void setEndereco(String endereco)
   {
        this.endereco = endereco; 
   }

   public String getTelefone()
   {
        return this.telefone;
   }


   public void setTelefone(String telefone) throws Exception
   {
        if(isTelefone(telefone))
            this.telefone = telefone;
        else
            throw new TelefoneException();
   }
   
   private boolean isTelefone(String telefone) 
   {
        return telefone.matches("^\\([1-9]{2}\\)[2-9][0-9]{3,4}\\-[0-9]{4}$")||
               telefone.matches("^\\([1-9]{2}\\)\\9[2-9][0-9]{5}\\-[0-9]{4}$");
   }
   
   public abstract double calcularSalarioBruto(short horasTrabalhadas) throws Exception;
   
   public abstract Imposto[] calcularImpostos(short horasTrabalhadas) throws Exception;
   
   public double valorTotalImposto(Imposto impostos[])throws NullPointerException, EmptyException{
       double sumTributum = 0;
              
       if(impostos != null){
          for(Imposto tribut: impostos){
              if((tribut.getNomeImposto() != null)||(!tribut.getNomeImposto().isEmpty()))
                sumTributum += tribut.getValorImposto();
              else
                 throw new EmptyException();
          }
       }
       else
          throw new NullPointerException();
       return sumTributum;
   }
   
}

