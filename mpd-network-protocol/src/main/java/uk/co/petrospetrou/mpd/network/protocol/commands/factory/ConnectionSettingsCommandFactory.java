/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.factory;

import uk.co.petrospetrou.mpd.network.protocol.commands.model.MPDRequest;

/**
 *
 * @author user1
 */
public class ConnectionSettingsCommandFactory {

    // http://www.musicpd.org/doc/protocol/connection_commands.html
    private static final String CLOSE = "close";
    private static final String KILL = "kill";
    private static final String PASSWORD = "password";
    private static final String PING = "ping";
    
    // close
    // Closes the connection to MPD. MPD will try to send the remaining output buffer before it actually closes 
    // the connection, but that cannot be guaranteed. This command will not generate a response. 
    public static String close() {              
        MPDRequest mpdRequest = new MPDRequest(CLOSE);
        return mpdRequest.getRequest();
    }
    
    // kill
    // Kills MPD.
    public static String kill() {              
        MPDRequest mpdRequest = new MPDRequest(KILL);
        return mpdRequest.getRequest();
    }
    
    // password {PASSWORD}
    // This is used for authentication with the server. PASSWORD is simply the plaintext password. 
    public static String password(String password) {              
        MPDRequest mpdRequest = new MPDRequest(PASSWORD, password);
        return mpdRequest.getRequest();
    }
    
    // ping
    // Does nothing but return "OK". 
    public static String ping() {              
        MPDRequest mpdRequest = new MPDRequest(PING);
        return mpdRequest.getRequest();
    }
    
}
