/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSM.Serial;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortPacketListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import GSM.Serial.serialExceptions.incompatibleBaudRateException;

/**
 *
 * @author xolani
 */
public class SerialStream extends Thread {
    
    protected int baud;
    protected SerialPort serialport;
    protected String writeback;
    
    public SerialStream(String baud, String portDescriptor) throws incompatibleBaudRateException
    {
        if(baud.contentEquals("9600") || baud.contentEquals("14400") || baud.contentEquals("19200")
                || baud.contentEquals("28800") || baud.contentEquals("38400") || baud.contentEquals("57600")
                || baud.contentEquals("115200"))
        {
            try
            {
                serialport = SerialPort.getCommPort(portDescriptor);
                serialport.setBaudRate(Integer.parseInt(baud));
                serialport.setNumDataBits(8);
                serialport.setNumStopBits(1);
            }
            catch(Exception e)
            {
                
            }
            finally
            {
                
            }
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
                serialport = SerialPort.getCommPort("COM4"); //Use default.
                serialport.setBaudRate(baud);
                serialport.setNumDataBits(8); //Default.
                serialport.setNumStopBits(1); //Default.
                //serialport.setParity(parity);
        }
        else
        {
            throw new incompatibleBaudRateException("Baud rate not compatible", baud);
        }
    }
    
    public SerialStream(String baud, String portDescriptor, byte databits, byte stopbits, byte parity) throws incompatibleBaudRateException
    {
        if(baud.contentEquals("9600") || baud.contentEquals("14400") || baud.contentEquals("19200")
                || baud.contentEquals("28800") || baud.contentEquals("38400") || baud.contentEquals("57600")
                || baud.contentEquals("115200"))
        {
            try
            {
                serialport = SerialPort.getCommPort(portDescriptor);
                serialport.setBaudRate(Integer.parseInt(baud));
                serialport.setNumDataBits(databits);
                serialport.setNumStopBits(stopbits);
                serialport.setParity(parity);
            }
            catch(Exception e)
            {
                
            }
            finally
            {
                
            }
        }
        else
        {
            throw new incompatibleBaudRateException("Baud rate not compatible", baud);
        }
    }
    
    @Override
    public void run()
    {
        try
        {
            watchStream();
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            
        }
    }
    
    public void watchStream()
    {
                serialport.openPort();
                serialport.addDataListener(new SerialPortDataListener() 
                        {
                            @Override
                            public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_AVAILABLE; }
                            @Override
                            public void serialEvent(SerialPortEvent event)
                            {
                               if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
                               {
                                    int bytesavailable = serialport.bytesAvailable();
                                    byte[] buffer = new byte[bytesavailable];
                                    int maxIndex = serialport.readBytes(buffer, bytesavailable);
                                    
                               }
                               else if(event.getEventType() == SerialPort.LISTENING_EVENT_DATA_WRITTEN)
                               {
                                   
                               }
                            }
                });
    }
}
