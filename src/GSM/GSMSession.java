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
import java.io.InputStream;
import java.io.OutputStream;

public class GSMSession implements GSMInterface {
    
    InputStream input;
    OutputStream output;
    String descriptivename;
    CommandQueue queue;
    
    public GSMSession()
    {
        // Initialise communication with GSM modem.
        try
        {
            SerialPort serialport = SerialPort.getCommPort("COM4");
            serialport.setBaudRate(9600);
            descriptivename = serialport.getDescriptivePortName();
            input = serialport.getInputStream();
            output = serialport.getOutputStream();
            serialport.setNumDataBits(8);
            serialport.setNumStopBits(1);
            serialport.openPort();
            // Test CPIN command.
            
        }   
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        //SerialPort serial = SerialPort.getCommPorts()[0];
        //serial.getDescriptivePortName();
    }
    
    public GSMSession(Configuration config)
    {
        
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
    
    public boolean testCPIN()
    {
        
        return false;
    }
    
    private void startSerialStreams(String baud)
    {
        
    }
    
    private void startCommandQueue()
    {
        
    }
    
    public void manualATCmd(String cmd)
    {
        
    }
}
