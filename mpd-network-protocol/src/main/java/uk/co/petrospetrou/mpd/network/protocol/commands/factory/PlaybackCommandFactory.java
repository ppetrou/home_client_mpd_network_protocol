/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.factory;

import uk.co.petrospetrou.mpd.network.protocol.commands.model.MPDRequest;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.SeekSymbol;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.State;

/**
 *
 * @author petros
 */
public class PlaybackCommandFactory {
    
    // http://www.musicpd.org/doc/protocol/playback_commands.html
       
    private static final String NEXT = "next";
    private static final String PAUSE = "pause";
    private static final String PLAY = "play";
    private static final String PLAYID = "playid";
    private static final String PREVIOUS = "previous";
    private static final String SEEK = "seek";
    private static final String SEEKID = "seekid";
    private static final String SEEKCUR = "seekcur";
    private static final String STOP = "stop";
    
    // next
    // Plays next song in the playlist. 
    public static String next() {              
        MPDRequest mpdRequest = new MPDRequest(NEXT);
        return mpdRequest.getRequest();
    }
        
    // pause {PAUSE}
    // Toggles pause/resumes playing, PAUSE is 0 or 1. 
    public static String pause(State state) {              
        MPDRequest mpdRequest = new MPDRequest(PAUSE, state.getState());
        return mpdRequest.getRequest();
    }
    
    // play [SONGPOS]
    // Begins playing the playlist at song number SONGPOS. 
    public static String play(int songPos) {             
        MPDRequest mpdRequest = new MPDRequest(PLAY, Integer.toString(songPos));
        return mpdRequest.getRequest();
    }
    
    // playid [SONGID]
    // Begins playing the playlist at song SONGID. 
    public static String playid(int songId) {
        MPDRequest mpdRequest = new MPDRequest(PLAYID, Integer.toString(songId));
        return mpdRequest.getRequest();
    }
    
    // previous
    // Plays previous song in the playlist. 
    public static String previous() {
        MPDRequest mpdRequest = new MPDRequest(PREVIOUS);
        return mpdRequest.getRequest();
    }
    
    // seek {SONGPOS} {TIME}
    // Seeks to the position TIME (in seconds; fractions allowed) of entry SONGPOS in the playlist. 
    public static String seek(int songPos, float time) {
        MPDRequest mpdRequest = new MPDRequest(SEEK, Integer.toString(songPos), Float.toString(time));
        return mpdRequest.getRequest();
    }
    
    // seekid {SONGID} {TIME}
    // Seeks to the position TIME (in seconds; fractions allowed) of song SONGID. 
    public static String seekid(int songId, float time) {
        MPDRequest mpdRequest = new MPDRequest(SEEKID, Integer.toString(songId), Float.toString(time));
        return mpdRequest.getRequest();
    }
    
    // seekcur {TIME}
    // Seeks to the position TIME (in seconds; fractions allowed) within the current song. 
    // If prefixed by '+' or '-', then the time is relative to the current playing position. 
    public static String seekcur(float time) {
        MPDRequest mpdRequest = new MPDRequest(SEEKCUR, Float.toString(time));
        return mpdRequest.getRequest();
    }
    
    public static String seekcur(float time, SeekSymbol seekSymbol) {
        
        String timeArgSeek = Float.toString(time);
        timeArgSeek = seekSymbol.getSeekSymbol() + timeArgSeek;
        
        MPDRequest mpdRequest = new MPDRequest(SEEKCUR, timeArgSeek);
        return mpdRequest.getRequest();
    }
    
    // stop
    // Stops playing. 
    public static String stop() {
        MPDRequest mpdRequest = new MPDRequest(STOP);
        return mpdRequest.getRequest();
    }
       
}
