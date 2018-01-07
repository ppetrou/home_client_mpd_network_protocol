/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.factory;

import uk.co.petrospetrou.mpd.network.protocol.commands.model.MPDRequest;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.Range;
import java.net.URI;

/**
 *
 * @author user1
 */
public class StoredPlaylistCommandFactory {
    
    // http://www.musicpd.org/doc/protocol/playlist_files.html
    private static final String LISTPLAYLIST = "listplaylist";
    private static final String LISTPLAYLISTINFO = "listplaylistinfo";
    private static final String LISTPLAYLISTS = "listplaylists";
    private static final String LOAD = "load";
    private static final String PLAYLISTADD = "playlistadd";
    private static final String PLAYLISTCLEAR = "playlistclear";
    private static final String PLAYLISTDELETE = "playlistdelete";
    private static final String PLAYLISTMOVE = "playlistmove";
    private static final String RENAME = "rename";
    private static final String RM = "rm";
    private static final String SAVE = "save";
    
    // listplaylist {NAME}
    // Lists the songs in the playlist. Playlist plugins are supported. 
    public static String listplaylist(String name) {              
        MPDRequest mpdRequest = new MPDRequest(LISTPLAYLIST, name);
        return mpdRequest.getRequest();
    }
    
    // listplaylistinfo {NAME}
    // Lists the songs with metadata in the playlist. Playlist plugins are supported. 
    public static String listplaylistinfo(String name) {              
        MPDRequest mpdRequest = new MPDRequest(LISTPLAYLISTINFO, name);
        return mpdRequest.getRequest();
    }
    
    // listplaylists
    // Prints a list of the playlist directory.
    // After each playlist name the server sends its last modification time as attribute "Last-Modified" 
    // in ISO 8601 format. To avoid problems due to clock differences between clients and the server, 
    // clients should not compare this value with their local clock. 
    public static String listplaylists() {              
        MPDRequest mpdRequest = new MPDRequest(LISTPLAYLISTS);
        return mpdRequest.getRequest();
    }
    
    // load {NAME} [START:END]
    // Loads the playlist into the current queue. Playlist plugins are supported. 
    // A range may be specified to load only a part of the playlist. 
    public static String load(String name) {              
        MPDRequest mpdRequest = new MPDRequest(LOAD, name);
        return mpdRequest.getRequest();
    }
    
    public static String load(String name, Range range) {              
        MPDRequest mpdRequest = new MPDRequest(LOAD, name, range.getRange());
        return mpdRequest.getRequest();
    }
    
    // playlistadd {NAME} {URI}
    // Adds URI to the playlist NAME.m3u.
    // NAME.m3u will be created if it does not exist. 
    public static String playlistadd(String name, URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLISTADD, name, uri.getPath());
        return mpdRequest.getRequest();
    }
    
    // playlistclear {NAME}
    // Clears the playlist NAME.m3u. 
    public static String playlistclear(String name) {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLISTCLEAR, name);
        return mpdRequest.getRequest();
    }
    
    // playlistdelete {NAME} {SONGPOS}
    // Deletes SONGPOS from the playlist NAME.m3u. 
    public static String playlistdelete(String name, int songPos) {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLISTDELETE, name, Integer.toString(songPos));
        return mpdRequest.getRequest();
    }
    
    // playlistmove {NAME} {SONGID} {SONGPOS}
    // Moves SONGID in the playlist NAME.m3u to the position SONGPOS. 
    public static String playlistmove(String name, int songId, int songPos) {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLISTMOVE, name, Integer.toString(songId) ,Integer.toString(songPos));
        return mpdRequest.getRequest();
    }
    
    // rename {NAME} {NEW_NAME}
    // Renames the playlist NAME.m3u to NEW_NAME.m3u. 
    public static String rename(String name, String newName) {              
        MPDRequest mpdRequest = new MPDRequest(RENAME, name, newName);
        return mpdRequest.getRequest();
    }
    
    // rm {NAME}
    // Removes the playlist NAME.m3u from the playlist directory. 
    public static String rm(String name) {              
        MPDRequest mpdRequest = new MPDRequest(RM, name);
        return mpdRequest.getRequest();
    }
    
    // save {NAME}
    // Saves the current playlist to NAME.m3u in the playlist directory. 
    public static String save(String name) {              
        MPDRequest mpdRequest = new MPDRequest(SAVE, name);
        return mpdRequest.getRequest();
    }
    
}
