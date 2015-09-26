/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.controller;

import tributum.model.PessoaJuridica;
import tributum.view.DadosPessoaJuridicaGUI;

/**
 *
 * @author lucas
 */
public class PessoaJuridicaController {
    
    private static PessoaJuridica pjHelper;
    
    public static void gravarPessoaJuridica(DadosPessoaJuridicaGUI dadosPJ, PessoaJuridica pj) {
        
        try {
            dadosPJ.valorGHTextField.setText(dadosPJ.valorGHTextField.getText().replace(".", ""));
            dadosPJ.valorGHTextField.setText(dadosPJ.valorGHTextField.getText().replace(",", "."));
            
            pj = new PessoaJuridica(dadosPJ.nomePjTextField.getText(),
                                    dadosPJ.enderecoPjTextField.getText(),
                                    dadosPJ.telefonePjTextField.getText(),
                                    dadosPJ.cnpjTextField.getText(),
                                    Double.parseDouble(dadosPJ.valorGHTextField.getText()));
        } catch (Exception e) {
            
        }
        
        setPessoaJuridica(pj);
    }
    
    public static void alterarValorHoraTrabalho(double valorHoraTrabalho) {
        pjHelper.setValorHoraTrabalho(valorHoraTrabalho);
    }
    
    public static void setHorasTrabalhadas(short horasTrabalhadas) {
        pjHelper.setValorHoraTrabalho(horasTrabalhadas);
    }
    
    public static void setPessoaJuridica(PessoaJuridica pj) {
        PessoaJuridicaController.pjHelper = pj;
    }
    
    public static PessoaJuridica getPessoa() {
        return PessoaJuridicaController.pjHelper;
    }
}
