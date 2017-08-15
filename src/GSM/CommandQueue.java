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

import GSM.atcmd.cmd;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;

/**
 *
 * @author xolani
 */
public class CommandQueue extends Thread implements AtQueue {
    
    protected volatile Queue<cmd> queue;
    protected int Limit = 0; // If 0 (default), then no limit applies.
    protected String Name;
    protected int currentLength = 0;
    
    public CommandQueue()
    {
        // Initialise the queue for 255 commands.
        queue = new PriorityQueue<>(255);
    }
    
    public CommandQueue(int LengthLimit)
    {
        Limit = LengthLimit;
        queue = new PriorityQueue<>(Limit);
    }
    
    public CommandQueue(int LengthLimit, String name)
    {
        Limit = LengthLimit;
        Name = name;
        queue = new PriorityQueue<>(Limit);
    }
    
    public synchronized void addCommand(cmd command) throws IllegalStateException
    {
        queue.add(command);
        if (this.getState() == State.WAITING)
        {
            this.notify();
        }
    }
    
    public synchronized void addCommandList(List<cmd> commands) throws IllegalStateException
    {
        queue.addAll(commands);
        if (this.getState() == State.WAITING)
        {
            this.notify();
        }
    }
    
    public synchronized int getQueueLength()
    {
        return queue.size();
    }
    
    public synchronized cmd pollQueue()
    {
        return queue.poll();
    }
    
    public synchronized cmd peekQueue()
    {
        return queue.peek();
    }
    
    public synchronized void offerQueue(cmd command)
    {
        queue.offer(command);
    }
    
    @Override
    public void run()
    {
        
    }
}
