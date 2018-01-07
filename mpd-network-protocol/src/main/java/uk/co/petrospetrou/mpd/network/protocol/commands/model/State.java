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
public enum State {
    ON ("1"), 
    OFF ("0");
    
    private final String state;
    
    private State(String state) {
        this.state = state;
    }
    
    public String getState() {
        return this.state;
    }
    
}
