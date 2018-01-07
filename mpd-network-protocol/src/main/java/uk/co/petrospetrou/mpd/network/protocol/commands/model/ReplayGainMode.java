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
public enum ReplayGainMode {
    OFF ("off"), 
    TRACK ("track"), 
    ALBUM ("album"), 
    AUTO ("auto");
    
    private final String replayGainMode;
    
    private ReplayGainMode(String replayGainMode) {
        this.replayGainMode = replayGainMode;
    }
    
    public String getReplayGainMode() {
        return this.replayGainMode;
    }
    
}
