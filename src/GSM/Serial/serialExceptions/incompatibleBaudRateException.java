/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSM.Serial.serialExceptions;

/**
 *
 * @author xolani
 */
public class incompatibleBaudRateException extends Exception {

    /**
     * Creates a new instance of <code>incompatibleBaudRateException</code>
     * without detail message.
     */
    public incompatibleBaudRateException() {
        
    }

    /**
     * Constructs an instance of <code>incompatibleBaudRateException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public incompatibleBaudRateException(String msg) {
        super(msg);
    }
    
    public incompatibleBaudRateException(String msg, String baud)
    {
        super(msg);
    }
    
    public incompatibleBaudRateException(String msg, int baud)
    {
        super(msg);
    }
}
