/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.model;

/**
 *
 * @author petros
 */
public class Range {
    
    private static final String SEPERATOR = ":";    

    private final Float start;
    private final Float end;

    public Range(Float start, Float end) {
        this.start = start;
        this.end = end;
    }
    
    public String getRange() {
        String start = (this.start == null)?"":this.start.toString();
        String end = (this.end == null)?"":this.end.toString();
        return start + SEPERATOR + end;
    }

}
