/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.model;

/**
 *
 * @author Gilberto Gaspar
 */
public class NomeException extends Exception{
    public NomeException(){
        super("Nome inválido ou em branco");
    }
    
    public NomeException(String mensagem){
        super(mensagem);
    }
}
