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
public enum Operator {
    
    EQUALS ("="),
    LT ("<"),
    GT (">");
    
    private final String operator;
    
    private Operator(String operator) {
        this.operator = operator;
    }
    
    public String getOperator() {
        return this.operator;
    }
}
