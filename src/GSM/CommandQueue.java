/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSM;

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
