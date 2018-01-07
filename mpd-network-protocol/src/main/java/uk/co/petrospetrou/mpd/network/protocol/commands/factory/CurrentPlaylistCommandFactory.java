/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.factory;

import uk.co.petrospetrou.mpd.network.protocol.commands.model.MPDRequest;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.Priority;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.Range;
import java.net.URI;

/**
 *
 * @author user1
 */
public class CurrentPlaylistCommandFactory {
    
    // http://www.musicpd.org/doc/protocol/queue.html
    private static final String ADD = "add";
    private static final String ADDID = "addid";
    private static final String CLEAR = "clear";
    private static final String DELETE = "delete";
    private static final String DELETEID = "deleteid";
    private static final String MOVE = "move";
    private static final String MOVEID = "moveid";
    private static final String PLAYLIST = "playlist";
    private static final String PLAYLISTFIND = "playlistfind";
    private static final String PLAYLISTID = "playlistid";
    private static final String PLAYLISTINFO = "playlistinfo";
    private static final String PLAYLISTSEARCH = "playlistsearch";
    
    private static final String PLCHANGES = "plchanges";
    private static final String PLCHANGESPOSID = "plchangesposid";
    private static final String PRIO = "prio";
    private static final String PRIOID = "prioid";
    private static final String RANGEID = "rangeid";
    private static final String SHUFFLE = "shuffle";
    private static final String SWAP = "swap";
    private static final String SWAPID = "swapid";
    private static final String ADDTAGID = "addtagid";
    private static final String CLEARTAGID = "cleartagid";
    
    // add {URI}
    // Adds the file URI to the playlist (directories add recursively). URI can also be a single file. 
    public static String add(URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(ADD, uri.getPath());
        return mpdRequest.getRequest();
    }
    
    // addid {URI} [POSITION]
    // Adds a song to the playlist (non-recursive) and returns the song id.
    // URI is always a single file or URL. For example:
    // addid "foo.mp3"
    // Id: 999
    // OK
    public static String addid(URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(ADDID, uri.getPath());
        return mpdRequest.getRequest();
    }
    
    // clear
    // Clears the current playlist. 
    public static String clear() {              
        MPDRequest mpdRequest = new MPDRequest(CLEAR);
        return mpdRequest.getRequest();
    }
    
    // delete [{POS} | {START:END}]
    // Deletes a song from the playlist. 
    public static String delete(int position) {              
        MPDRequest mpdRequest = new MPDRequest(DELETE, Integer.toString(position));
        return mpdRequest.getRequest();
    }
    
    public static String delete(Range range) {              
        MPDRequest mpdRequest = new MPDRequest(DELETE, range.getRange());
        return mpdRequest.getRequest();
    }
    
    // deleteid {SONGID}
    // Deletes the song SONGID from the playlist
    public static String deleteid(int songId) {              
        MPDRequest mpdRequest = new MPDRequest(DELETEID, Integer.toString(songId));
        return mpdRequest.getRequest();
    }
    
    // move [{FROM} | {START:END}] {TO}
    // Moves the song at FROM or range of songs at START:END to TO in the playlist. [6] 
    public static String move(int from, int to) {              
        MPDRequest mpdRequest = new MPDRequest(MOVE, Integer.toString(from), Integer.toString(to));
        return mpdRequest.getRequest();
    }
    
    public static String move(Range range, int to) {              
        MPDRequest mpdRequest = new MPDRequest(MOVE, range.getRange(), Integer.toString(to));
        return mpdRequest.getRequest();
    }
    
    // moveid {FROM} {TO}
    // Moves the song with FROM (songid) to TO (playlist index) in the playlist. 
    // If TO is negative, it is relative to the current song in the playlist (if there is one). 
    public static String moveid(int fromSongId, int toPlaylistIndex) {              
        MPDRequest mpdRequest = new MPDRequest(MOVEID, Integer.toString(fromSongId), Integer.toString(toPlaylistIndex));
        return mpdRequest.getRequest();
    }
    
    // playlist
    // Displays the current playlist.
    // Note
    // Do not use this, instead use playlistinfo. 
    public static String playlist() {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLIST);
        return mpdRequest.getRequest();
    }
    
    // playlistfind {TAG} {NEEDLE}
    // Finds songs in the current playlist with strict matching. 
    public static String playlistfind(String tag, int needle) {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLISTFIND, tag, Integer.toString(needle));
        return mpdRequest.getRequest();
    }
    
    // playlistid {SONGID}
    // Displays a list of songs in the playlist. SONGID is optional and specifies a single song to display info for. 
    public static String playlistid(int songId) {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLISTID, Integer.toString(songId));
        return mpdRequest.getRequest();
    }
    
    // playlistinfo [[SONGPOS] | [START:END]]
    // Displays a list of all songs in the playlist, or if the optional argument is given, 
    // displays information only for the song SONGPOS or the range of songs START:END [6] 
    public static String playlistinfo() {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLISTINFO);
        return mpdRequest.getRequest();
    }
    
    public static String playlistinfo(int songPos) {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLISTINFO, Integer.toString(songPos));
        return mpdRequest.getRequest();
    }
    
    public static String playlistinfo(Range range) {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLISTINFO, range.getRange());
        return mpdRequest.getRequest();
    }
    
    // playlistsearch {TAG} {NEEDLE}
    // Searches case-insensitively for partial matches in the current playlist. 
    public static String playlistsearch(String tag, int needle) {              
        MPDRequest mpdRequest = new MPDRequest(PLAYLISTSEARCH, tag, Integer.toString(needle));
        return mpdRequest.getRequest();
    }
    
    // plchanges {VERSION}
    // Displays changed songs currently in the playlist since VERSION.
    // To detect songs that were deleted at the end of the playlist, use playlistlength returned by status command. 
    public static String plchanges(int version) {              
        MPDRequest mpdRequest = new MPDRequest(PLCHANGES, Integer.toString(version));
        return mpdRequest.getRequest();
    }
    
    // plchangesposid {VERSION}
    // Displays changed songs currently in the playlist since VERSION. 
    // This function only returns the position and the id of the changed song, not the complete metadata. 
    // This is more bandwidth efficient.
    // To detect songs that were deleted at the end of the playlist, use playlistlength returned by status command. 
    public static String plchangesposid(int version) {              
        MPDRequest mpdRequest = new MPDRequest(PLCHANGESPOSID, Integer.toString(version));
        return mpdRequest.getRequest();
    }
    
    // prio {PRIORITY} {START:END...}
    // Set the priority of the specified songs. 
    // A higher priority means that it will be played first when "random" mode is enabled.
    // A priority is an integer between 0 and 255. The default priority of new songs is 0. 
    public static String prio(Priority priority, Range range) {              
        MPDRequest mpdRequest = new MPDRequest(PRIO, priority.getPriority(), range.getRange());
        return mpdRequest.getRequest();
    }
    
    // prioid {PRIORITY} {ID...}
    // Same as prio, but address the songs with their id. 
    public static String prioid(Priority priority, int songId) {              
        MPDRequest mpdRequest = new MPDRequest(PRIOID, priority.getPriority(), Integer.toString(songId));
        return mpdRequest.getRequest();
    }
    
    // rangeid {ID} {START:END}
    // [7] Specifies the portion of the song that shall be played. 
    // START and END are offsets in seconds (fractional seconds allowed); both are optional. 
    // Omitting both (i.e. sending just ":") means "remove the range, play everything". 
    // A song that is currently playing cannot be manipulated this way. 
    public static String rangeid(int songId, Range range) {              
        MPDRequest mpdRequest = new MPDRequest(RANGEID, Integer.toString(songId), range.getRange());
        return mpdRequest.getRequest();
    }
    
    // shuffle [START:END]
    // Shuffles the current playlist. START:END is optional and specifies a range of songs. 
    public static String shuffle() {              
        MPDRequest mpdRequest = new MPDRequest(SHUFFLE);
        return mpdRequest.getRequest();
    }
    
    public static String shuffle(Range range) {              
        MPDRequest mpdRequest = new MPDRequest(SHUFFLE, range.getRange());
        return mpdRequest.getRequest();
    }
    
    // swap {SONG1} {SONG2}
    // Swaps the positions of SONG1 and SONG2. 
    public static String swap(int song1, int song2) {              
        MPDRequest mpdRequest = new MPDRequest(SWAP, Integer.toString(song1), Integer.toString(song2));
        return mpdRequest.getRequest();
    }
    
    // swapid {SONG1} {SONG2}
    // Swaps the positions of SONG1 and SONG2 (both song ids). 
    public static String swapid(int songId1, int songId2) {              
        MPDRequest mpdRequest = new MPDRequest(SWAPID, Integer.toString(songId1), Integer.toString(songId2));
        return mpdRequest.getRequest();
    }
    
    // addtagid {SONGID} {TAG} {VALUE}
    // Adds a tag to the specified song. Editing song tags is only possible for remote songs. 
    // This change is volatile: it may be overwritten by tags received from the server, 
    // and the data is gone when the song gets removed from the queue. 
    public static String addtagid(int songId, String tag, String value) {              
        MPDRequest mpdRequest = new MPDRequest(ADDTAGID, Integer.toString(songId), tag, value);
        return mpdRequest.getRequest();
    }
    
    // cleartagid {SONGID} [TAG]
    // Removes tags from the specified song. If TAG is not specified, then all tag values will be removed. 
    // Editing song tags is only possible for remote songs. 
    public static String cleartagid(int songId, String tag) {              
        MPDRequest mpdRequest = new MPDRequest(CLEARTAGID, Integer.toString(songId), tag);
        return mpdRequest.getRequest();
    }
    
}
