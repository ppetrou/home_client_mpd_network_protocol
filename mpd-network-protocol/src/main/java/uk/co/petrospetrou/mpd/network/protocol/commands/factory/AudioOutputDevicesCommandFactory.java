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
public class AudioOutputDevicesCommandFactory {
    
    // http://www.musicpd.org/doc/protocol/output_commands.html
    
    private static final String DISABLEOUTPUT = "disableoutput";
    private static final String ENABLEOUTPUT = "enableoutput";
    private static final String TOGGLEOUTPUT = "toggleoutput";
    private static final String OUTPUTS = "outputs";


    // disableoutput {ID}
    // Turns an output off. 
    public static String disableoutput(int id) {
        MPDRequest mpdRequest = new MPDRequest(DISABLEOUTPUT, Integer.toString(id));
        return mpdRequest.getRequest();                
    }

    // enableoutput {ID}
    // Turns an output on. 
    public static String enableoutput(int id) {
        MPDRequest mpdRequest = new MPDRequest(ENABLEOUTPUT, Integer.toString(id));
        return mpdRequest.getRequest();                
    }

    // toggleoutput {ID}
    // Turns an output on or off, depending on the current state. 
    public static String toggleoutput(int id) {
        MPDRequest mpdRequest = new MPDRequest(TOGGLEOUTPUT, Integer.toString(id));
        return mpdRequest.getRequest();                
    }

    // outputs
    // Shows information about all outputs.
    // outputid: 0
    // outputname: My ALSA Device
    // outputenabled: 0
    // OK

    // Return information:
    // outputid: ID of the output. May change between executions
    // outputname: Name of the output. It can be any.
    // outputenabled: Status of the output. 0 if disabled, 1 if enabled. 
    public static String outputs() {
        MPDRequest mpdRequest = new MPDRequest(OUTPUTS);
        return mpdRequest.getRequest();                
    }
    
}
