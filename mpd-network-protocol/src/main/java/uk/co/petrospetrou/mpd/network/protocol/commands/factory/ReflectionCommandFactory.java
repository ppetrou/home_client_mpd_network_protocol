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
public class ReflectionCommandFactory {

    // http://www.musicpd.org/doc/protocol/reflection_commands.html
    
    private static final String CONFIG = "config";
    private static final String COMMANDS = "commands";
    private static final String NOTCOMMANDS = "notcommands";
    private static final String TAGTYPES = "tagtypes";
    private static final String URLHANDLERS = "urlhandlers";
    private static final String DECODERS = "decoders";
    
    // config
    // Dumps configuration values that may be interesting for the client. 
    // This command is only permitted to "local" clients (connected via UNIX domain socket).
    // The following response attributes are available:
    // Name Description
    // music_directory The absolute path of the music directory.
    public static String config() {
        MPDRequest mpdRequest = new MPDRequest(CONFIG);
        return mpdRequest.getRequest();                
    }
    
    // commands
    // Shows which commands the current user has access to. 
    public static String commands() {
        MPDRequest mpdRequest = new MPDRequest(COMMANDS);
        return mpdRequest.getRequest();                
    }
    
    // notcommands
    // Shows which commands the current user does not have access to. 
    public static String notcommands() {
        MPDRequest mpdRequest = new MPDRequest(NOTCOMMANDS);
        return mpdRequest.getRequest();                
    }
    
    
    // tagtypes
    // Shows a list of available song metadata. 
    public static String tagtypes() {
        MPDRequest mpdRequest = new MPDRequest(TAGTYPES);
        return mpdRequest.getRequest();                
    }
    
    // urlhandlers
    // Gets a list of available URL handlers.
    public static String urlhandlers() {
        MPDRequest mpdRequest = new MPDRequest(URLHANDLERS);
        return mpdRequest.getRequest();                
    }
    
    // decoders
    // Print a list of decoder plugins, followed by their supported suffixes and MIME types. Example response:
    // plugin: mad
    // suffix: mp3
    // suffix: mp2
    // mime_type: audio/mpeg
    // plugin: mpcdec
    // suffix: mpc
    public static String decoders() {
        MPDRequest mpdRequest = new MPDRequest(DECODERS);
        return mpdRequest.getRequest();                
    }
    
}
