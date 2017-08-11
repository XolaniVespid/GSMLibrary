/*
 * Copyright (C) 2017 xolani
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
import GSM.Serial.SerialParser;
import GSM.Serial.SerialStream;

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
    
    private void startSerialStream(String baud)
    {
        
    }
    
    protected void startCommandQueue()
    {
        
    }
    
    protected void stopCommandQueue()
    {
        
    }
    
    protected void restartCommandQueue()
    {
        
    }
    
    public void manualATCmd(String cmd)
    {
        
    }
}
