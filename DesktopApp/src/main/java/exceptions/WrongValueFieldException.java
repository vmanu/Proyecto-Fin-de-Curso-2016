/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Victor
 */
public class WrongValueFieldException extends Exception{

    public WrongValueFieldException() {
        super();
    }

    public WrongValueFieldException(String message) {
        super(message);
    }
    
}
