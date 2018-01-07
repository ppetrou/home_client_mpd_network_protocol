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
public enum FindType {
    
    // any checks all tag values
    // file checks the full path (relative to the music directory)
    // base restricts the search to songs in the given directory (also relative to the music directory)
    // modified-since compares the file's time stamp with the given value (ISO 8601 or UNIX time stamp)
    
    ANY ("any"),
    FILE ("file"),
    BASE ("base"),
    MODIFIED_SINCE ("modified-since");
    
    private final String findType;
    
    private FindType(String findType) {
        this.findType = findType;
    }
    
    public String getFindType() {
        return this.findType;
    }
    
}
