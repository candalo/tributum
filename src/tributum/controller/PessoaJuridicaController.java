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
    
    public void gravarPessoaJuridica(DadosPessoaJuridicaGUI dadosPJ, PessoaJuridica pj) {
        try {
            pj = new PessoaJuridica(dadosPJ.nomePjTextField.getText(),
                                    dadosPJ.enderecoPjTextField.getText(),
                                    dadosPJ.telefonePjTextField.getText(),
                                    dadosPJ.cnpjTextField.getText(),
                                    Double.parseDouble(dadosPJ.valorGHTextField.getText()));
        } catch (Exception e) {
            
        }
        
        setPessoaJuridica(pj);
    }
    
    public static void setPessoaJuridica(PessoaJuridica pj) {
        PessoaJuridicaController.pjHelper = pj;
    }
    
    public static PessoaJuridica getPessoa() {
        return PessoaJuridicaController.pjHelper;
    }
}
