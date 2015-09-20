/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.model;

import java.util.Arrays;
import java.util.InputMismatchException;

public class PessoaJuridica extends Colaborador{
    
    private String cnpj;
    private double valorHoraTrabalho;
    private double salarioBruto;
    private double irrf;
    private double pisCofCsll;
    private double iss;
    
    public PessoaJuridica(String nome, String endereco, String telefone,
                          String cnpj, double valorHoraTrabalho) {
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
        this.valorHoraTrabalho = valorHoraTrabalho;
    }
    
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(String cnpj) throws Exception {
        if(isCnpj(cnpj))
            this.cnpj = cnpj;
        else
           throw new Exception("Valor inválido para CNPJ"); 
    }
    
    private boolean isCnpj(String cnpj) {
        
        // Explode a string e remove os caracteres . e -
        String[] cnpjAux = cnpj.split(".|-");
        
        // Converte o array de strings em uma string
        cnpj = Arrays.toString(cnpjAux);
        
        /* - CNPJ nao pode ser formado por uma sequencia de digitos iguais
         * - CNPJ nao pode ter o comprimento diferente de 14
         */
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
            cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
            cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
            cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
            cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
           (cnpj.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            
            // Calculo do primeiro digito verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

            // Calculo do segundo digito verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
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
    
    public double calcularIrrf() {
        this.irrf = 0.015 * this.salarioBruto;
        return this.irrf;
    }
    
    public double calcularPisCofCsll() {
        if(this.salarioBruto > 5000.0) 
            this.pisCofCsll = 0.0465 * this.salarioBruto;
        else
            this.pisCofCsll = 0;
        
        return this.pisCofCsll;
    }
    
    public double calcularIss() {
        if(this.salarioBruto > 5000.0)
            this.iss = 0.04 * this.salarioBruto;
        else
            this.iss = 0;
        
        return this.iss;
    }
}
