/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.controller;

import tributum.model.CnpjException;
import tributum.model.PessoaJuridica;
import tributum.model.TelefoneException;
import tributum.view.DadosPessoaJuridicaGUI;

/**
 *
 * @author lucas
 */
public class PessoaJuridicaController {
    
    private static PessoaJuridica pjHelper;
    
    public static void gravarPessoaJuridica(DadosPessoaJuridicaGUI dadosPJ, PessoaJuridica pj) throws Exception {
        
        try {
            dadosPJ.valorGHTextField.setText(dadosPJ.valorGHTextField.getText().replace(".", ""));
            dadosPJ.valorGHTextField.setText(dadosPJ.valorGHTextField.getText().replace(",", "."));
            
            pj = new PessoaJuridica(dadosPJ.nomePjTextField.getText(),
                                    dadosPJ.enderecoPjTextField.getText(),
                                    dadosPJ.telefonePjTextField.getText(),
                                    dadosPJ.cnpjTextField.getText(),
                                    Double.parseDouble(dadosPJ.valorGHTextField.getText()));
        } catch (TelefoneException e) {
            throw new TelefoneException();
        } catch (CnpjException e) {
            throw new CnpjException();
        }
        
        setPessoaJuridica(pj);
    }
    
    public static void alterarValorHoraTrabalho(double valorHoraTrabalho) throws Exception {
        try {
            pjHelper.setValorHoraTrabalho(valorHoraTrabalho);
        } catch(Exception e) {
            throw new Exception("Valor/hora trabalho deve ser maior que 0");
        }
    }
    
    public static void calcularImpostos(short horasTrabalhadas) {
        try {
            pjHelper.calcularSalarioBruto(horasTrabalhadas);
        }catch(Exception e) {}
        pjHelper.calcularIrrf();
        pjHelper.calcularIss();
        pjHelper.calcularPisCofCsll();
        pjHelper.calcularSalarioLiquido();
    }
    
    public static void setPessoaJuridica(PessoaJuridica pj) {
        PessoaJuridicaController.pjHelper = pj;
    }
    
    public static PessoaJuridica getPessoaJuridica() {
        return PessoaJuridicaController.pjHelper;
    }
}
