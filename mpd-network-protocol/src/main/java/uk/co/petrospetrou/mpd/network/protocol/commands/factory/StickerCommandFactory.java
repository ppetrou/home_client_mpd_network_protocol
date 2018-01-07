/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.factory;

import uk.co.petrospetrou.mpd.network.protocol.commands.model.Operator;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.MPDRequest;
import java.net.URI;

/**
 *
 * @author user1
 */
public class StickerCommandFactory {
    
    // http://www.musicpd.org/doc/protocol/stickers.html
    
    private static final String GET = "sticker get";
    private static final String SET = "sticker set";
    private static final String DELETE = "sticker delete";
    private static final String LIST = "sticker list";
    private static final String FIND = "sticker find";
    
    // sticker get {TYPE} {URI} {NAME}
    // Reads a sticker value for the specified object.
    public static String get(String type, URI uri, String name) {              
        MPDRequest mpdRequest = new MPDRequest(GET, type, uri.getPath(), name);
        return mpdRequest.getRequest();
    }

    // sticker set {TYPE} {URI} {NAME} {VALUE}
    // Adds a sticker value to the specified object. If a sticker item with that name already exists, it is replaced.
    public static String set(String type, URI uri, String name, String value) {              
        MPDRequest mpdRequest = new MPDRequest(SET, type, uri.getPath(), name, value);
        return mpdRequest.getRequest();
    }

    // sticker delete {TYPE} {URI} [NAME]
    // Deletes a sticker value from the specified object. 
    // If you do not specify a sticker name, all sticker values are deleted. 
    public static String delete(String path, URI uri, String name) {              
        MPDRequest mpdRequest = new MPDRequest(DELETE, path, uri.getPath(), name);
        return mpdRequest.getRequest();
    }

    // sticker list {TYPE} {URI}
    // Lists the stickers for the specified object. 
    public static String list(String path, URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(LIST, path, uri.getPath());
        return mpdRequest.getRequest();
    }

    // sticker find {TYPE} {URI} {NAME}
    // Searches the sticker database for stickers with the specified name, below the specified directory (URI). 
    // For each matching song, it prints the URI and that one sticker's value. 
    public static String find(String type, URI uri, String name) {              
        MPDRequest mpdRequest = new MPDRequest(FIND, uri.getPath(), name);
        return mpdRequest.getRequest();
    }

    // sticker find {TYPE} {URI} {NAME} = {VALUE}
    // Searches for stickers with the given value.
    // Other supported operators are: "<", ">" 
    public static String find(String type, URI uri, String name, Operator operator, String value) {              
        MPDRequest mpdRequest = new MPDRequest(FIND, uri.getPath(), name, operator.getOperator(), value);
        return mpdRequest.getRequest();
    }
    
}
