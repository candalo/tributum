/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.model;

/**
 *
 * @author medabot
 */
public class SalarioException extends Exception{
    public SalarioException(){
        super("Salario inválido");
    }
}
