/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.controller;

import tributum.model.Celetista;
import tributum.model.CpfException;
import tributum.model.NomeException;
import tributum.model.TelefoneException;
import tributum.view.DadosCeletistaGUI;
import tributum.view.FolhaDePagamentoCeletistaGUI;
import tributum.view.SalarioCeletistaGUI;

/**
 *
 * @author medabot
 */
public class CeletistaController {
    private static Celetista celetistaHelper;

    public static Celetista getCeletistaHelper() {
        return celetistaHelper;
    }

    public static void setCeletistaHelper(Celetista celetistaHelper) {
        CeletistaController.celetistaHelper = celetistaHelper;
    }
    
    /**
     * Grava os dados obtidos na view DadosCeletistaGUI, instanciando model Celetista
     * @param dadosCeletista
     * @throws  TelefoneException, CpfException, Exception
     */
    public static void gravarCeletista(DadosCeletistaGUI dadosCeletista) 
    throws TelefoneException, CpfException, Exception
    {
        String salario;
        try{
            salario = dadosCeletista.salMensalTextField.getText().replace(".", "");
            salario = salario.replace(",", ".");
            setCeletistaHelper(new Celetista(dadosCeletista.nomeTextField.getText(),
                                            dadosCeletista.telefoneTextField.getText(),
                                            dadosCeletista.enderecoTextField.getText(),
                                            dadosCeletista.rgTextField.getText(),
                                            dadosCeletista.cpfTextField.getText(),
                                            Double.parseDouble(salario)));
            
/*            setCeletistaHelper(new Celetista(dadosCeletista.nomeTextField.getText(),
                                            dadosCeletista.telefoneTextField.getText(),
                                            dadosCeletista.enderecoTextField.getText(),
                                            dadosCeletista.rgTextField.getText(),
                                            dadosCeletista.cpfTextField.getText(),
                                            Double.parseDouble(dadosCeletista.salMensalTextField.getText())));*/
        }catch(NomeException n){
            throw new NomeException();
        }catch (TelefoneException t){
            throw new TelefoneException();
        }catch (CpfException c){
            throw new CpfException();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    } 
    
    /**
     * Altera o salario de acordo com o mesmo passado
     * @param novoSalario, class SalarioCeletistaGUI
     * @throws Exception
     */
    public static void alterarSalario(SalarioCeletistaGUI novoSalario) throws Exception{
        try{
            novoSalario.salarioTextField.setText(novoSalario.salarioTextField.getText().replace(".", ""));
            novoSalario.salarioTextField.setText(novoSalario.salarioTextField.getText().replace(",", "."));
            getCeletistaHelper().setSalarioMensal(Double.parseDouble(novoSalario.salarioTextField.getText()));
        }catch (Exception e){
            throw new Exception("Valor não modificado, verificá-lo.");
        }
    }
    
    /**
     * realiza os calculos dos impostos a ser descontado do colaborador e calcula salario bruto e liquido.
     * @param folhapag, class FolhaDePagamentoCeletistaGUI
     * @throws Exception
     */
    
    public static void calcularImpostos(FolhaDePagamentoCeletistaGUI folhapag) throws Exception{
        double salarioLiquido, salarioBruto, inss, irrf;
        try{
            salarioBruto = getCeletistaHelper().calcularSalarioBruto(Float.parseFloat(folhapag.horastrabTextField.getText()));
            inss = getCeletistaHelper().calcularINSS(salarioBruto);
            irrf = getCeletistaHelper().calcularIRRF(salarioBruto);
            
            salarioLiquido = salarioBruto - inss - irrf; 
            
            folhapag.valorBrutoTextField.setText(String.valueOf(salarioBruto));
            folhapag.inssTextField.setText(String.valueOf(inss));
            folhapag.irffTextField.setText(String.valueOf(irrf));
            folhapag.salLiqTextField.setText(String.valueOf(salarioLiquido));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        
    }
}
