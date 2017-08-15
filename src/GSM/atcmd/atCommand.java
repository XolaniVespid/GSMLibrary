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
package GSM.atcmd;

import GSM.atcmd.cmd;
import GSM.atcmd.exceptions.AtCommandException;

/**
 *
 * @author xolani
 */
public class atCommand implements cmd {
    
    protected String cmd;
    protected String[] args;
    protected commandType type;
    
    public atCommand(String command) throws AtCommandException
    {
        if (CommandNameTest(command))
        {
            cmd = command;
            type = commandType.READ;
            args = new String[1];
            args[0] = "";
        }
        else
        {
            throw new AtCommandException();
        }
    }
    
    public atCommand(String command, commandType type) throws AtCommandException
    {
        if(CommandNameTest(command))
        {
            cmd = command;
            this.type = type;
            args = new String[1];
            args[0] = "";
        }
        else
        {
            throw new AtCommandException();
        }
    }
    
    public atCommand(String command, commandType type, String argument) throws AtCommandException
    {
        if(CommandNameTest(command) && ArgumentTest(argument))
        {
            cmd = command;
            this.type = type;
            args = new String[1];
            args[0] = argument;
        }
        else
        {
            throw new AtCommandException();
        }
    }
    
    public atCommand(String command, commandType type, String[] arguments) throws AtCommandException
    {
        if(CommandNameTest(command))
        {
            cmd = command;
            this.type = type;
            for (int i = 0; i < arguments.length; i++)
            {
                if(!ArgumentTest(arguments[i]))
                {
                    throw new AtCommandException();
                }
            }
            args = arguments;
        }
        else
        {
            throw new AtCommandException();
        }
    }
    
    /*
    * This method tests against the full range of compatible at commands for the GSM modem.
    * Early versions may not implement the full command set.
    * Please note that this method ONLY does basic validity testing of function names and nothing else.
    */
    protected static boolean CommandNameTest(String command)
    {
        boolean valid = false;
        
        //First, convert the command to a single case to ensure fidelity.
        String c = command.toUpperCase();
        
        // Test against signal strength command.
        // This command is at the head of the list due to its frequency of use,
        // computationally it makes more sense to have it here.
        if(c.contentEquals("CSQ"))
        {
            valid = true;
        }
        // Test against SMS commands.
        if(c.contentEquals("CMGR") || c.contentEquals("CMGS") || c.contentEquals("CMGL")
                || c.contentEquals("CMGD") || c.contentEquals("CMGW") || c.contentEquals("CMGF")
                || c.contentEquals("CMSS") || c.contentEquals("CNMI") || c.contentEquals("CPMS")
                || c.contentEquals("CRES") || c.contentEquals("CSAS") || c.contentEquals("CSCA")
                || c.contentEquals("CSCB") || c.contentEquals("CSDH") || c.contentEquals("CSMP")
                || c.contentEquals("CSMS"))
        {
            valid = true;
        }
        // Test against phonebook commands.
        else if(c.contentEquals("CPBR") || c.contentEquals("CPBF") ||c.contentEquals("CPBS")
                || c.contentEquals("CPBW"))
        {
            valid = true;
        }
        // Test against CPIN command.
        else if(c.contentEquals("CPIN"))
        {
            valid = true;
        }
        // Test against other GSM07.07 commands. (currently incomplete)
        else if(c.contentEquals("CACM") || c.contentEquals("CAMM") || c.contentEquals("CAOC")
                || c.contentEquals("CBST") || c.contentEquals("CCFC") || c.contentEquals("CCWA")
                || c.contentEquals("CEER") || c.contentEquals("CGMI") || c.contentEquals("CGMM")
                || c.contentEquals("CGMR") || c.contentEquals("CGSN") || c.contentEquals("CSCS")
                || c.contentEquals("CSTA") || c.contentEquals("CHLD") || c.contentEquals("CIMI")
                || c.contentEquals("CLCC") || c.contentEquals("CLCK") || c.contentEquals("CLIP")
                || c.contentEquals("CLIR") || c.contentEquals("CMEE") || c.contentEquals("COLP")
                || c.contentEquals("COPS") || c.contentEquals("CPAS") || c.contentEquals("CPWD")
                || c.contentEquals("CR") || c.contentEquals("CRC") || c.contentEquals("CREG")
                || c.contentEquals("CRLP") || c.contentEquals("CRSM") /*|| c.contentEquals("CSQ")*/
                || c.contentEquals("FCLASS") || c.contentEquals("FMI") || c.contentEquals("FMM")
                || c.contentEquals("FMR") || c.contentEquals("VTD") || c.contentEquals("VTS")
                || c.contentEquals("CMUX") || c.contentEquals("CNUM") || c.contentEquals("CPOL")
                || c.contentEquals("COPN") || c.contentEquals("CFUN") || c.contentEquals("CCLK")
                || c.contentEquals("CSIM") || c.contentEquals("CALM") || c.contentEquals("CALS")
                || c.contentEquals("CRSL") || c.contentEquals("CLVL") || c.contentEquals("CMUT")
                || c.contentEquals("CPUC") || c.contentEquals("CCWE") || c.contentEquals("CBC")
                || c.contentEquals("CUSD") || c.contentEquals("CSSN"))
        {
            valid = true;
        }
        // Test against V.25TER commands. (currently incomplete)
        
        // Test against GSM07.05 commands. (currently incomplete)
        
        // Test against GPRS commands. (currently incomplete)
        return valid;
    }
    
    protected static boolean ArgumentTest(String argument)
    {
        return true;
    }
    
    protected static boolean ArgumentTest(String[] argument)
    {
        return true;
    }
    
    public String getCommand()
    {
        return cmd;
    }
    
    public String[] getArgs()
    {
        return args;
    }
    
    public void setArgs(String[] args)
    {
        
    }
    
    public void setArg(int index, String arg)
    {
        
    }
}
