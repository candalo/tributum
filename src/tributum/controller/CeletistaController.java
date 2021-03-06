/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.controller;

import tributum.model.Celetista;
import tributum.model.CpfException;
import tributum.model.Imposto;
import tributum.model.SalarioException;
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
    public static void alterarSalario(SalarioCeletistaGUI novoSalario) throws SalarioException{
        String newSalario;
        try{
            newSalario = novoSalario.salarioTextField.getText().replace(".", "");
            newSalario = newSalario.replace(",", ".");
            getCeletistaHelper().setSalarioMensal(Double.parseDouble(newSalario));
        }catch (SalarioException s){
            throw new SalarioException();
        }
    }
    
    /**
     * realiza os calculos dos impostos a ser descontado do colaborador e calcula salario bruto e liquido.
     * @param folhapag, class FolhaDePagamentoCeletistaGUI
     * @throws Exception
     */
    
    public static void calcularImpostos(FolhaDePagamentoCeletistaGUI folhapag) throws Exception{
        Imposto[] impostos;
        double salarioLiquido, salarioBruto, inss, irrf;
        try{
            salarioBruto = getCeletistaHelper().calcularSalarioBruto(Short.valueOf(folhapag.horastrabTextField.getText()));
            impostos = getCeletistaHelper().calcularImpostos(Short.valueOf(folhapag.horastrabTextField.getText()));
            
            salarioLiquido = salarioBruto - getCeletistaHelper().valorTotalImposto(impostos); 
            
            folhapag.totalImpostoTextField.setText(String.valueOf(getCeletistaHelper().valorTotalImposto(impostos)));
            folhapag.valorBrutoTextField.setText(String.valueOf(salarioBruto));
            folhapag.inssTextField.setText(String.valueOf(impostos[0].getValorImposto()));
            folhapag.irffTextField.setText(String.valueOf(impostos[1].getValorImposto()));
            folhapag.salLiqTextField.setText(String.valueOf(salarioLiquido));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        
    }
}
