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
public class EmptyException extends Exception{
    public EmptyException(){
        super("Calcule novamente os impostos");
    }    

    public EmptyException(String msg){
        super(msg);
    }    
}
