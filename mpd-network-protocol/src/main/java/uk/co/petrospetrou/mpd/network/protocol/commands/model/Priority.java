/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.model;

/**
 *
 * @author user1
 */
public class Priority {
    
    private int priority;

    public Priority(int priority) {
        if (priority < 0 || priority > 255) {
            throw new IllegalArgumentException("Priority range is between 0 and 255.");
        } else {
            this.priority = priority;
        }
    }

    public String getPriority() {
        return Integer.toString(priority);
    }

    @Override
    public String toString() {
        return "Priority{" + "priority=" + priority + '}';
    }
    
}
