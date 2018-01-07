/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.factory;

import uk.co.petrospetrou.mpd.network.protocol.commands.model.MPDRequest;
import java.net.URI;

/**
 *
 * @author user1
 */
public class MountsAndNeighboursCommandFactory {
    
    // http://www.musicpd.org/doc/protocol/mount.html
    
    private static final String MOUNT = "mount";
    private static final String UNMOUNT = "unmount";
    private static final String LISTMOUNTS = "listmounts";
    private static final String LISTNEIGHBORS = "listneighbors";

    // mount {PATH} {URI}
    // Mount the specified remote storage URI at the given path. Example:
    // mount foo nfs://192.168.1.4/export/mp3
    public static String mount(String path, URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(MOUNT, path, uri.getPath());
        return mpdRequest.getRequest();
    }

    // unmount {PATH}
    // Unmounts the specified path. Example:
    // unmount foo
    public static String unmount(String path) {              
        MPDRequest mpdRequest = new MPDRequest(UNMOUNT, path);
        return mpdRequest.getRequest();
    }

    // listmounts
    // Queries a list of all mounts. By default, this contains just the configured music_directory. Example:
    // listmounts
    // mount: 
    // storage: /home/foo/music
    // mount: foo
    // storage: nfs://192.168.1.4/export/mp3
    // OK
    public static String listmounts() {              
        MPDRequest mpdRequest = new MPDRequest(LISTMOUNTS);
        return mpdRequest.getRequest();
    }

    // listneighbors
    // Queries a list of "neighbors" (e.g. accessible file servers on the local net). 
    // Items on that list may be used with the mount command. Example:
    // listneighbors
    // neighbor: smb://FOO
    // name: FOO (Samba 4.1.11-Debian)
    // OK
    public static String listneighbors() {              
        MPDRequest mpdRequest = new MPDRequest(LISTNEIGHBORS);
        return mpdRequest.getRequest();
    }
    
}
