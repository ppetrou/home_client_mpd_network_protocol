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
public class Volume {
    
    private int volume;

    public Volume(int volume) {
        if (volume < 0 || volume > 100) {
            throw new IllegalArgumentException("Volume range is between 0 and 100.");
        } else {
            this.volume = volume;
        }
    }

    public String getVolume() {
        return Integer.toString(volume);
    }
    
    @Override
    public String toString() {
        return "Volume{" + "volume=" + volume + '}';
    }
    
}
