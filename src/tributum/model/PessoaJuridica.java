/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.model;

public class PessoaJuridica extends Colaborador{
    
    private String cnpj;
    private double valorHoraTrabalho;
    private double salarioBruto;
    private double irrf;
    private double pisCofCsll;
    private double iss;
    private double salarioLiquido;
    
    public PessoaJuridica(String nome, String endereco, String telefone,
                          String cnpj, double valorHoraTrabalho) throws Exception{
        super(nome, endereco, telefone);
        setCnpj(cnpj);
        this.valorHoraTrabalho = valorHoraTrabalho;
    }
    
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(String cnpj) throws Exception {
        if(isCnpj(cnpj))
            this.cnpj = cnpj;
        else
           throw new CnpjException(); 
    }
    
    private boolean isCnpj(String cnpj) {
        
        if (!cnpj.substring(0, 1).equals("")) {  
            try {  
                cnpj = cnpj.replace('.', ' ');//onde há ponto coloca espaço  
                cnpj = cnpj.replace('/', ' ');//onde há barra coloca espaço  
                cnpj = cnpj.replace('-', ' ');//onde há traço coloca espaço  
                cnpj = cnpj.replaceAll(" ", "");//retira espaço  
                int soma = 0, dig;  
                String cnpj_calc = cnpj.substring(0, 12);  
  
                if (cnpj.length() != 14) {  
                    return false;  
                }  
                char[] chr_cnpj = cnpj.toCharArray();  
                /* Primeira parte */  
                for (int i = 0; i < 4; i++) {  
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {  
                        soma += (chr_cnpj[i] - 48) * (6 - (i + 1));  
                    }  
                }  
                for (int i = 0; i < 8; i++) {  
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {  
                        soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));  
                    }  
                }  
                dig = 11 - (soma % 11);  
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(  
                        dig);  
                /* Segunda parte */  
                soma = 0;  
                for (int i = 0; i < 5; i++) {  
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {  
                        soma += (chr_cnpj[i] - 48) * (7 - (i + 1));  
                    }  
                }  
                for (int i = 0; i < 8; i++) {  
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {  
                        soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));  
                    }  
                }  
                dig = 11 - (soma % 11);  
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(  
                        dig);  
                return cnpj.equals(cnpj_calc);  
            }  
            catch (Exception e) {  
                return false;  
            }  
        }  
        else {  
            return false;  
        }  
    }
    
    public double getValorHoraTrabalho() {
        return this.valorHoraTrabalho;
    }
    
    public void setValorHoraTrabalho(double valorHoraTrabalho) {
        this.valorHoraTrabalho = valorHoraTrabalho;
    }
    
    public double calcularSalarioBruto(short horasTrabalhadas) throws Exception {
        if(horasTrabalhadas >= 0) {
            this.salarioBruto = this.valorHoraTrabalho * horasTrabalhadas;
            return this.salarioBruto;
        }
        else {
            throw new Exception("Valor de horas trabalhadas deve ser maior ou igual a 0");
        }
    }
    
    public double getSalarioBruto() {
        return this.salarioBruto;
    }
    
    public double calcularIrrf() {
        this.irrf = 0.015 * this.salarioBruto;
        return this.irrf;
    }
    
    public double getIrrf() {
        return this.irrf;
    }
    
    public double calcularPisCofCsll() {
        if(this.salarioBruto > 5000.0) 
            this.pisCofCsll = 0.0465 * this.salarioBruto;
        else
            this.pisCofCsll = 0;
        
        return this.pisCofCsll;
    }
    
    public double getPisCofCsll() {
        return this.pisCofCsll;
    }
    
    public double calcularIss() {
        if(this.salarioBruto > 5000.0)
            this.iss = 0.04 * this.salarioBruto;
        else
            this.iss = 0;
        
        return this.iss;
    }
    
    public double getIss() {
        return this.iss;
    }
    
    public void calcularSalarioLiquido() {
        this.salarioLiquido = this.salarioBruto -
                              this.irrf -
                              this.pisCofCsll -
                              this.iss;
    }
    
    public double getSalarioLiquido() {
        return this.salarioLiquido;
    }
}
