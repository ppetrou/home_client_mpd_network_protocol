/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.factory;

import uk.co.petrospetrou.mpd.network.protocol.commands.model.MPDRequest;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.Subsystem;

/**
 *
 * @author user1
 */
public class StatusCommandFactory {

    // http://www.musicpd.org/doc/protocol/command_reference.html#status_commands
    private static final String CLEARERROR = "clearerror";
    private static final String CURRENTSONG = "currentsong";
    private static final String IDLE = "idle";
    private static final String NOIDLE = "noidle";
    private static final String STATUS = "status";
    private static final String STATS = "stats";

    // clearerror
    // Clears the current error message in status (this is also accomplished by any command that starts playback). 
    public static String clearerror() {
        MPDRequest mpdRequest = new MPDRequest(CLEARERROR);
        return mpdRequest.getRequest();
    }

    // currentsong
    // Displays the song info of the current song (same song that is identified in status). 
    public static String currentsong() {
        MPDRequest mpdRequest = new MPDRequest(CURRENTSONG);
        return mpdRequest.getRequest();
    }

    // idle [SUBSYSTEMS...]
    // Waits until there is a noteworthy change in one or more of MPD's subsystems. As soon as there is one, it lists all changed systems in a line in the format changed: SUBSYSTEM, where SUBSYSTEM is one of the following: 
    public static String idle(Subsystem subsystem) {

        MPDRequest mpdRequest;
        
        // Check is the subsystem parameter is passed and initialize the MPDCommand accordingly.
        if (subsystem == null) {
            mpdRequest = new MPDRequest(IDLE);
        } else {
            mpdRequest = new MPDRequest(IDLE, subsystem.getSubSystem());
        }

        return mpdRequest.getRequest();
    }

    // noidle
    // The idle command can be canceled by sending the command noidle (no other commands are allowed). 
    // MPD will then leave idle mode and print results immediately; might be empty at this time. 
    public static String noidle() {
        MPDRequest mpdRequest = new MPDRequest(NOIDLE);
        return mpdRequest.getRequest();
    }
    
    // status
    // Reports the current status of the player and the volume level. 
    public static String status() {
        MPDRequest mpdRequest = new MPDRequest(STATUS);
        return mpdRequest.getRequest();
    }
    
    // stats
    // Displays statistics. 
    public static String stats() {
        MPDRequest mpdRequest = new MPDRequest(STATS);
        return mpdRequest.getRequest();
    }
        
}
