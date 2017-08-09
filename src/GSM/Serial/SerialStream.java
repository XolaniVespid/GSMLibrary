/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSM.Serial;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortPacketListener;
import GSM.Serial.serialExceptions.incompatibleBaudRateException;

/**
 *
 * @author xolani
 */
public class SerialStream extends Thread {
    
    int baud;
    
    public SerialStream(String baud) throws incompatibleBaudRateException
    {
        if(baud.contentEquals("9600") || baud.contentEquals("14400") || baud.contentEquals("19200")
                || baud.contentEquals("28800") || baud.contentEquals("38400") || baud.contentEquals("57600")
                || baud.contentEquals("115200"))
        {
            
        }
        else
        {
            throw new incompatibleBaudRateException("Baud rate not compatible", baud);
        }
    }
    
    public SerialStream(int baud) throws incompatibleBaudRateException
    {
        if(baud == 9600 || baud == 14400 || baud == 19200 || baud == 28800 || baud == 28800
                || baud == 38400 || baud == 57600 || baud == 115200)
        {
            
        }
        else
        {
            throw new incompatibleBaudRateException("Baud rate not compatible", baud);
        }
    }
    
    @Override
    public void run()
    {
        
    }
}
