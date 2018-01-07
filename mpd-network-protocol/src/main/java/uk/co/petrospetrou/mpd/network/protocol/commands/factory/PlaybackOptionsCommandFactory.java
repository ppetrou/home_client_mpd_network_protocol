/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.factory;

import uk.co.petrospetrou.mpd.network.protocol.commands.model.MPDRequest;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.ReplayGainMode;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.State;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.Volume;

/**
 *
 * @author user1
 */
public class PlaybackOptionsCommandFactory {
    
    // http://www.musicpd.org/doc/protocol/playback_option_commands.html
    
    private static final String CONSUME = "consume";
    private static final String CROSSFADE = "crossfade";
    private static final String MIXRAMPDB = "mixrampdb";
    private static final String MIXRAMPDELAY = "mixrampdelay";
    private static final String RANDOM = "random";
    private static final String REPEAT = "repeat";
    private static final String SETVOL = "setvol";
    private static final String SINGLE = "single";
    private static final String REPLAY_GAIN_MODE = "replay_gain_mode";
    private static final String REPLAY_GAIN_STATUS = "replay_gain_status";
    
    // consume {STATE}
    // Sets consume state to STATE, STATE should be 0 or 1. When consume is activated, 
    // Weach song played is removed from playlist. 
    public static String consume(State state) {
        MPDRequest mpdRequest = new MPDRequest(CONSUME, state.getState());
        return mpdRequest.getRequest();                
    }
  
    // crossfade {SECONDS}
    // Sets crossfading between songs. 
    public static String crossfade(int seconds) {
        MPDRequest mpdRequest = new MPDRequest(CROSSFADE, Integer.toString(seconds));
        return mpdRequest.getRequest();                        
    }
    
    // mixrampdb {deciBels}
    // Sets the threshold at which songs will be overlapped. Like crossfading but doesn't fade the track volume, 
    // just overlaps. The songs need to have MixRamp tags added by an external tool. 
    // 0dB is the normalized maximum volume so use negative values, I prefer -17dB. 
    // In the absence of mixramp tags crossfading will be used. See http://sourceforge.net/projects/mixramp 
    public static String mixrampdb(int deciBels) {
        MPDRequest mpdRequest = new MPDRequest(MIXRAMPDB, Integer.toString(deciBels));
        return mpdRequest.getRequest();                        
    }
    
    // mixrampdelay {SECONDS}
    // Additional time subtracted from the overlap calculated by mixrampdb. 
    // A value of "nan" disables MixRamp overlapping and falls back to crossfading. 
    public static String mixrampdelay(int seconds) {
        MPDRequest mpdRequest = new MPDRequest(MIXRAMPDELAY, Integer.toString(seconds));
        return mpdRequest.getRequest();                        
    }
    
    // random {STATE}
    // Sets random state to STATE, STATE should be 0 or 1. 
    public static String random(State state) {
        MPDRequest mpdRequest = new MPDRequest(RANDOM, state.getState());
        return mpdRequest.getRequest();                        
    }
    
    // repeat {STATE}
    // Sets repeat state to STATE, STATE should be 0 or 1.
    public static String repeat(State state) {
        MPDRequest mpdRequest = new MPDRequest(REPEAT, state.getState());
        return mpdRequest.getRequest();                        
    }
    
    // setvol {VOL}
    // Sets volume to VOL, the range of volume is 0-100.
    public static String setvol(Volume volume) {
        MPDRequest mpdRequest = new MPDRequest(SETVOL, volume.getVolume());
        return mpdRequest.getRequest();                        
    }
    
    // single {STATE}
    // [2] Sets single state to STATE, STATE should be 0 or 1. 
    // When single is activated, playback is stopped after current song, or song is repeated if the 'repeat' mode 
    // is enabled. 
    public static String single(State state) {
        MPDRequest mpdRequest = new MPDRequest(SINGLE, state.getState());
        return mpdRequest.getRequest();                        
    }
    
    // replay_gain_mode {MODE}
    // Sets the replay gain mode. One of off, track, album, auto[5].
    // Changing the mode during playback may take several seconds, 
    // because the new settings does not affect the buffered data.
    // This command triggers the options idle event. 
    public static String replaygainmode(ReplayGainMode replayGainMode) {
        MPDRequest mpdRequest = new MPDRequest(REPLAY_GAIN_MODE, replayGainMode.getReplayGainMode());
        return mpdRequest.getRequest();                        
    }
    
    // replay_gain_status
    // Prints replay gain options. Currently, only the variable replay_gain_mode is returned. 
    public static String replaygainstatus() {
        MPDRequest mpdRequest = new MPDRequest(REPLAY_GAIN_STATUS);
        return mpdRequest.getRequest();                        
    }   
    
}
