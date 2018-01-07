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
public class ClientToClientCommandFactory {
    
    // http://www.musicpd.org/doc/protocol/client_to_client.html
    
    private static final String SUBSCRIBE = "subscribe";
    private static final String UNSUBSCRIBE = "unsubscribe";
    private static final String CHANNELS = "channels";
    private static final String READMESSAGES = "readmessages";
    private static final String SENDMESSAGE = "sendmessage";

    // subscribe {NAME}
    // Subscribe to a channel. The channel is created if it does not exist already. 
    // The name may consist of alphanumeric ASCII characters plus underscore, dash, dot and colon. 
    public static String subscribe(String name) {              
        MPDRequest mpdRequest = new MPDRequest(SUBSCRIBE, name);
        return mpdRequest.getRequest();
    }

    // unsubscribe {NAME}
    // Unsubscribe from a channel. 
    public static String unsubscribe(String name) {              
        MPDRequest mpdRequest = new MPDRequest(UNSUBSCRIBE, name);
        return mpdRequest.getRequest();
    }

    // channels
    // Obtain a list of all channels. The response is a list of "channel:" lines. 
    public static String channels() {              
        MPDRequest mpdRequest = new MPDRequest(CHANNELS);
        return mpdRequest.getRequest();
    }

    // readmessages
    // Reads messages for this client. The response is a list of "channel:" and "message:" lines. 
    public static String readmessages() {              
        MPDRequest mpdRequest = new MPDRequest(READMESSAGES);
        return mpdRequest.getRequest();
    }

    // sendmessage {CHANNEL} {TEXT}
    // Send a message to the specified channel. 
    public static String sendmessage(String channel, String text) {              
        MPDRequest mpdRequest = new MPDRequest(SENDMESSAGE, channel, text);
        return mpdRequest.getRequest();
    }
    
}
