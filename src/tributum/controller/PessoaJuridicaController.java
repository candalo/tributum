/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.controller;

import tributum.model.CnpjException;
import tributum.model.Imposto;
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
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
        setPessoaJuridica(pj);
    }
    
    public static void alterarValorHoraTrabalho(double valorHoraTrabalho) throws Exception {
        try {
            pjHelper.setValorHoraTrabalho(valorHoraTrabalho);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public static Imposto[] calcularImpostos(short horasTrabalhadas) throws Exception {
        
        Imposto[] impostos;
        
        try {
            pjHelper.calcularSalarioBruto(horasTrabalhadas);
        }catch(Exception e) {
            throw new Exception("Valor de horas trabalhadas deve ser maior ou igual a 0");
        }
        
        impostos = pjHelper.calcularImpostos(horasTrabalhadas);
        
        pjHelper.setSalarioLiquido(pjHelper.getSalarioBruto() - pjHelper.valorTotalImposto(impostos));
        
        return impostos;
    }
    
    public static void setPessoaJuridica(PessoaJuridica pj) {
        PessoaJuridicaController.pjHelper = pj;
    }
    
    public static PessoaJuridica getPessoaJuridica() {
        return PessoaJuridicaController.pjHelper;
    }
}
