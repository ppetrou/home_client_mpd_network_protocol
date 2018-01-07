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
public enum Subsystem {
    DATABASE ("database"),
    UPDATE ("update"),
    STORED_PLAYLIST ("stored_playlist"),
    PLAYLIST ("playlist"),
    PLAYER ("player"),
    MIXER ("mixer"),
    OUTPUT ("output"),
    OPTIONS ("options"),
    STICKER ("sticker"),
    SUBSCRIPTION ("subscription"),
    MESSAGE ("message");
    
    private final String subsystem;
    
    private Subsystem(String subsystem) {
        this.subsystem = subsystem;
    }
    
    public String getSubSystem() {
        return this.subsystem;
    }
}
