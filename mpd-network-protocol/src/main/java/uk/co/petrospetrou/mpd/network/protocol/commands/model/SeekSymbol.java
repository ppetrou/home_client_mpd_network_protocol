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
public enum SeekSymbol {
    
    PLUS ("+"),
    MINUS ("-");
    
    private final String seekSymbol;
    
    private SeekSymbol(String symbol) {
        this.seekSymbol = symbol;
    }
    
    public String getSeekSymbol() {
        return this.seekSymbol;
    }
    
}
