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
package GSM.Serial;

import java.util.*;

/**
 *
 * @author xolani
 */
public class SerialParser extends Thread implements parser {
    
    protected java.util.Queue<String> q;
    protected boolean runloop = true;
    
    public SerialParser()
    {
        setPriority(Thread.NORM_PRIORITY);
        this.setDaemon(true); // Thread can be a daemon as it can shut down when serial stream thread ends.
        q = new java.util.PriorityQueue<>(255);
    }
    
    @Override
    public void run()
    {
        try
        {
            parse();
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            
        }
    }
    
    public synchronized boolean IncomingDataEvent(String incoming)
    {
        boolean added = q.offer(incoming);
        if(added)
        {
            this.notify();
        }
        return added;
    }
    
    protected void parse()
    {
        while(runloop == true)
        {
            String currentCommand = q.poll();
            if(currentCommand != null)
            {
                
            }
            else
            {
                
            }
        }
    }
}
