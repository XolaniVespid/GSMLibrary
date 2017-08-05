/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSM;

/**
 *
 * @author xolani
 */

// Import serial communication library.
import com.fazecast.jSerialComm.*;

public class GSMSession {
    
    public GSMSession()
    {
        // Initialise communication with GSM modem.
        SerialPort[] serialports = SerialPort.getCommPorts();
        // Find the modem from the serial ports available.
        for (int i = 0; i < serialports.length; i++)
        {
            
        }
    }
    
    public String[] getSMS(int index)
    {
        String[] SMS = new String[2];
        return SMS;
    }
    
    public void sendSMS(String telNumber, String SMS)
    {
        if (SMS.length() <= 160)
        {
            
        }
        else if (SMS.length() <= 39015)
        {
            
        }
        else
        {
            
        }
    }
    
    public String getClock()
    {
        String time = "";
        
        return time;
    }
}
