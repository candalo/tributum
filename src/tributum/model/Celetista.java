/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.model;

/**
 *
 * @author fec.6453355881
 */
public class Celetista extends Colaborador implements IConstants {
    private String rg;
    private String cpf;
    private double salarioMensal;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception{
        if(this.validarCpf(cpf))
            this.cpf = cpf;
        else
            throw new CpfException();
       
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) throws SalarioException {
        if(salarioMensal > 0)
            this.salarioMensal = salarioMensal;
        else
            throw new SalarioException();
    }

    public Celetista(String nome, String telefone, String endereco, String rg, String cpf, double salarioMensal)
    throws Exception{
        super(nome, endereco, telefone);
        this.setRg(rg);
        this.setCpf(cpf);
        this.setSalarioMensal(salarioMensal);
    }
    
    /**
     * Método que retorna o valor do salário bruto a ser recebido pelo Celetista
     * @param hoursWork Trabalhadas
     * @return  float salario bruto
     */
    public double calcularSalarioBruto(float hoursWork){
        if(hoursWork < 161){
            return this.getSalarioMensal();
        }
        else{
            return (this.getSalarioMensal()/hoursWorking) * hoursWork;
        }
    }
    
    /**
     * Método que calcula o valor que será descontado do salário bruto
     * @param salarioBruto
     * @return float, valor descontado do imposto
     */
    public double calcularIRRF(double salarioBruto){
        if(salarioBruto < 1499.16){
            return 0;
        }
        else{
            if(salarioBruto < 2246.76){
                return (112.43 + (salarioBruto * 0.075));
            }
            else{
                if(salarioBruto < 2995.71){
                    return (280.94 + salarioBruto * 0.15);
                }
                else{
                    if(salarioBruto < 3743.20){
                        return (505.62 + salarioBruto * 0.225);
                    }
                    else{
                        return (692.78 + salarioBruto * 0.275);
                    }
                }
            
            }
           
        }
    }
    
    /**
     * Método que calcula o valor a ser descontado de INSS
     * @param salarioBruto
     * @return double, o valor descontado
     */
    public double calcularINSS(double salarioBruto){
        if(salarioBruto < 965.68){
            return (salarioBruto * 0.08);
        }
        else{
            if(salarioBruto < 1609.46){
                return (salarioBruto * 0.09);
            }
            else{
                double descontoINSS;
                //Recebe o resultado do calculo para teste posterior,
                //O desconto não pode passar do valor 354.08
                descontoINSS = (salarioBruto * 0.11);
                
                if(descontoINSS > 354.08){
                    return 354.08;
                }
                return descontoINSS;
            }
        }
    }
    
    
    /**
     * Metodo que velida Cpf, calculando e comparando o resultado com os digitos
     * @param cpf
     * @return booleano, se é valido ou não.
     * throws NumberFormatException
     */
    public boolean validarCpf(String cpf) throws NumberFormatException{
        String noneToken;
        int[] computeCpf = new int[CpfLenght];
        int[] digCpf = new int[2];
        int auxSumCpf;
        noneToken = cpf;
        
        //Retirar os simbolos da string
        noneToken = noneToken.replace(".", "");
        noneToken = noneToken.replace("-", "");
        noneToken = noneToken.replace("/", "");
        noneToken = noneToken.trim();
        
        //Convert as substring em valores inteiros
        for(int count = 0; count < CpfLenght;count++){
            computeCpf[count] = Integer.parseInt(noneToken.substring(count, count+1));
        }
        
        //variável para auxiliar no calculo
        auxSumCpf =0;
        
        /*Método do calculo de verificação
         *  1) Multiplica cada valor do array, pelos valores regressivos de 10 ate 2
         * e armazenar o resultado de cada, somando-os;
         *  2) Depois, dividir o resultado das somas por 11, obtendo o resto da divisão.
         *          - Se o resto for MAIOR que 1.
         *               Subtrair 11 pelo valor obtido.
         *          - Senão, o resto é zero.
         *      Está o primeiro digito.
         *  3) Retornar ao passo 1, com uma resalva,os valores regressivos iniciam por onze.
        **/
        for(int count = 0, indexCpf = 10; indexCpf >= 2 && count <= 8;count++, indexCpf--){
            auxSumCpf += computeCpf[count] * indexCpf;
        }
        
        digCpf[0] = auxSumCpf % 11;
        
        if(digCpf[0] > 1){
            digCpf[0] = 11 - digCpf[0];
        }
        else{
            digCpf[0] = 0;
        }

        //Verifica o primeiro digito
        if(digCpf[0] != computeCpf[9]){    
            return false;
        }
        
        //Retorno do passo 1, inicia aqui.
        auxSumCpf =0;
        
        for(int count = 0, indexCpf = 11; indexCpf >= 2 && count <= 9;count++, indexCpf--){
            auxSumCpf += computeCpf[count] * indexCpf;
        }
        
        digCpf[1] = auxSumCpf % 11;
        
        if(digCpf[1] > 1){
            digCpf[1] = 11 - digCpf[1];
        }
        else{
            digCpf[1] = 0;
        }

       //Verifica o primeiro digito
        if(digCpf[1] != computeCpf[10]){    
            return false;
        }

        return true;
    }
    
    
}
