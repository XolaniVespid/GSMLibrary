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
package GSM.SMS;

import GSM.SMS.Exceptions.incorrectSMSModeUsedException;

/**
 *
 * @author xolani
 */
public class SMSMessage implements SMS{
    
    protected smsType Type;
    protected String sender;
    protected byte[] byteSender;
    protected boolean sendertype; // False if not string (byte array)
    protected String receiver;
    protected byte[] byteReceiver;
    protected boolean receivertype; // False if not string (byte array)
    protected String message;
    protected byte[] byteMessage;
    protected boolean messagetype; // False if not string (byte array)
    protected byte[] encoding;
    protected boolean concat; // Is the message a concatenated message?
    protected String[] concatElements;
    protected byte[][] concatHeaders;
    
    public SMSMessage(smsType type, String sender, String receiver, String message)
    {
        this.sender = sender;
        sendertype = true;
        this.receiver = receiver;
        receivertype = true;
        this.message = message;
        messagetype = true;
        Type = type;
        if (type == smsType.PDU)
        {
            
        }
        else if (type == smsType.TEXT)
        {
            
        }
    }
    
    public SMSMessage(smsType type, String sender, String receiver, String message, byte[] header)
    {
        
    }
    
    public SMSMessage(smsType type, byte[] sender, byte[] receiver, byte[] message, byte[] header)
    {
        
    }
    
    public SMSMessage(smsType type, byte[] sender, byte[] receiver, byte[] message, byte[] header, byte[] encoding)
    {
        
    }
    
    public String getMessageText() throws incorrectSMSModeUsedException
    {
        if(message != null)
        {
            return message;
        }
        else
        {
            throw new incorrectSMSModeUsedException(Type);
        }
    }
    
    public void setMessageText(byte[] message)
    {
        
    }
    
    public void setMessageText(String message)
    {
        this.message = message;
        messagetype = true;
    }
    
    public void setMessageText(byte[] message, byte[] encoding)
    {
        
    }
    
    public void setMessageText(String message, byte[] encoding)
    {
        
    }
    
    public void setSenderNumber(String sender)
    {
        
    }
    
    public void setSenderNumber(byte[] sender)
    {
        
    }
    
    public void setReceiverNumber(String receiver)
    {
        
    }
    
    public String getSenderAsString() throws incorrectSMSModeUsedException
    {
        if (sendertype == true)
        {
            return sender;
        }
        else
        {
            throw new incorrectSMSModeUsedException(Type);
        }
    }
    
    public byte[] getSenderAsBytes() throws incorrectSMSModeUsedException
    {
        if (sendertype == false)
        {
            return byteSender;
        }
        else
        {
            throw new incorrectSMSModeUsedException(Type);
        }
    }
    
    public String getReceiverAsString() throws incorrectSMSModeUsedException
    {
        if(receivertype == true)
        {
            return receiver;
        }
        else
        {
            throw new incorrectSMSModeUsedException(Type);
        }
    }
    
    public byte[] getReceiverAsBytes() throws incorrectSMSModeUsedException
    {
        if(receivertype == false)
        {
            return byteReceiver;
        }
        else
        {
            throw new incorrectSMSModeUsedException(Type);
        }
    }
    
    public smsType getMessageMode()
    {
        return Type;
    }
    
    public boolean isConcat()
    {
        return concat;
    }
    
    public void setConcat()
    {
        concat = true;
    }
    
    protected static String[] PDUtoText(String PDU)
    {
        String[] sms = new String[11];
        
        return sms;
    }
}
