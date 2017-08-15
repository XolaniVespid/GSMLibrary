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
    
    public atCommand(String command, commandType type)
    {
        
    }
    
    public atCommand(String command, commandType type, String arguments)
    {
        
    }
    
    public atCommand(String command, commandType type, String[] arguments)
    {
        
    }
    
    protected static boolean CommandNameTest(String command)
    {
        return true;
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
