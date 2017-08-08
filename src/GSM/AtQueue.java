/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSM;

import java.util.List;

/**
 *
 * @author xolani
 */
public interface AtQueue {
    
    public void addCommand(cmd command) throws IllegalStateException;
    public void addCommandList(List<cmd> commands) throws IllegalStateException;
    public int getQueueLength();
    public cmd pollQueue();
    public cmd peekQueue();
    public void offerQueue(cmd command);
    
}
