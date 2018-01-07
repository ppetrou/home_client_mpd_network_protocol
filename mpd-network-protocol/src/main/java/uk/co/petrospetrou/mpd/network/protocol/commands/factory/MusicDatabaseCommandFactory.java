/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.factory;

import uk.co.petrospetrou.mpd.network.protocol.commands.model.FindType;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.MPDRequest;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.Range;
import java.net.URI;

/**
 *
 * @author user1
 */
public class MusicDatabaseCommandFactory {
    
    // http://www.musicpd.org/doc/protocol/database.html
    
    private static final String COUNT = "count";
    private static final String FIND = "find";
    private static final String FINDADD = "findadd";
    private static final String LIST = "list";
    private static final String LISTALL = "listall";
    private static final String LISTALLINFO = "listallinfo";
    private static final String LISTFILES = "listfiles";
    private static final String LSINFO = "lsinfo";
    private static final String READCOMMENTS = "readcomments";
    private static final String SEARCH = "search";
    private static final String SEARCHADD = "searchadd";
    private static final String SEARCHADDPL = "searchaddpl";
    private static final String UPDATE = "update";
    private static final String RESCAN = "rescan";
    

    // count {TAG} {NEEDLE} [...] [group] [GROUPTYPE]
    // Counts the number of songs and their total playtime in the db matching TAG exactly.
    // The group keyword may be used to group the results by a tag. The following prints per-artist counts:
    // count group artist
    public static String count(String tag, String needle) {              
        MPDRequest mpdRequest = new MPDRequest(COUNT, tag, needle);
        return mpdRequest.getRequest();
    }
    
    public static String count(boolean group, String grouptype) {              
        MPDRequest mpdRequest = new MPDRequest(COUNT, group?"group":"", grouptype);
        return mpdRequest.getRequest();
    }
    
    public static String count(String tag, String needle, boolean group, String grouptype) {              
        MPDRequest mpdRequest = new MPDRequest(COUNT, tag, needle, group?"group":"", grouptype);
        return mpdRequest.getRequest();
    }

    // find {TYPE} {WHAT} [...] [window START:END]
    // Finds songs in the db that are exactly WHAT. 
    // TYPE can be any tag supported by MPD, or one of the special parameters:
    // any checks all tag values
    // file checks the full path (relative to the music directory)
    // base restricts the search to songs in the given directory (also relative to the music directory)
    // modified-since compares the file's time stamp with the given value (ISO 8601 or UNIX time stamp) 
    // WHAT is what to find.
    // window can be used to query only a portion of the real response. 
    // The parameter is two zero-based record numbers; a start number and an end number. 
    public static String find(FindType type, String what) {              
        MPDRequest mpdRequest = new MPDRequest(FIND, type.getFindType(), what);
        return mpdRequest.getRequest();
    }
    
    public static String find(FindType type, String what, Range window) {              
        MPDRequest mpdRequest = new MPDRequest(FIND, type.getFindType(), what, window.getRange());
        return mpdRequest.getRequest();
    }

    // findadd {TYPE} {WHAT} [...]
    // Finds songs in the db that are exactly WHAT and adds them to current playlist. 
    // Parameters have the same meaning as for find. 
    public static String findadd(FindType type, String what) {              
        MPDRequest mpdRequest = new MPDRequest(FINDADD, type.getFindType(), what);
        return mpdRequest.getRequest();
    }
    
    // list {TYPE} [FILTERTYPE] [FILTERWHAT] [...] [group] [GROUPTYPE] [...]
    // Lists unique tags values of the specified type. TYPE can be any tag supported by MPD or file.
    // Additional arguments may specify a filter like the one in the find command.
    // The group keyword may be used (repeatedly) to group the results by one or more tags. 
    // The following example lists all album names, grouped by their respective (album) artist:
    // list album group albumartist
    public static String list(String type) {              
        MPDRequest mpdRequest = new MPDRequest(LIST, type);
        return mpdRequest.getRequest();
    }
    
    public static String list(String type, FindType filterType, String what, boolean group, String groupType) {              
        MPDRequest mpdRequest = new MPDRequest(LIST, type, filterType.getFindType(), what, group?"group":"", groupType);
        return mpdRequest.getRequest();
    }
    
    public static String list(String type, boolean group, String groupType) {              
        MPDRequest mpdRequest = new MPDRequest(LIST, type, group?"group":"", groupType);
        return mpdRequest.getRequest();
    }
    
    // listall [URI]
    // Lists all songs and directories in URI.
    // Do not use this command. Do not manage a client-side copy of MPD's database. 
    // That is fragile and adds huge overhead. It will break with large databases. 
    // Instead, query MPD whenever you need something. 
    public static String listall(URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(LISTALL, uri.getPath());
        return mpdRequest.getRequest();
    }

    // listallinfo [URI]
    // Same as listall, except it also returns metadata info in the same format as lsinfo.
    // Do not use this command. Do not manage a client-side copy of MPD's database. 
    // That is fragile and adds huge overhead. It will break with large databases. 
    // Instead, query MPD whenever you need something. 
    public static String listallinfo(URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(LISTALLINFO, uri.getPath());
        return mpdRequest.getRequest();
    }

    // listfiles [URI]
    // Lists the contents of the directory URI, including files are not recognized by MPD. 
    // URI can be a path relative to the music directory or an URI understood by one of the storage plugins. 
    // The response contains at least one line for each directory entry with the prefix "file: " or "directory: ", 
    // and may be followed by file attributes such as "Last-Modified" and "size".
    // For example, "smb://SERVER" returns a list of all shares on the given SMB/CIFS server; 
    // "nfs://servername/path" obtains a directory listing from the NFS server. 
    public static String listfiles(URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(LISTFILES, uri.getPath());
        return mpdRequest.getRequest();
    }

    // lsinfo [URI]
    // Lists the contents of the directory URI.
    // When listing the root directory, this currently returns the list of stored playlists. 
    // This behavior is deprecated; use "listplaylists" instead.
    // This command may be used to list metadata of remote files (e.g. URI beginning with "http://" or "smb://").
    // Clients that are connected via UNIX domain socket may use this command to read the tags of 
    // an arbitrary local file (URI is an absolute path). 
    public static String lsinfo(URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(LSINFO, uri.getPath());
        return mpdRequest.getRequest();
    }

    // readcomments [URI]
    // Read "comments" (i.e. key-value pairs) from the file specified by "URI". This "URI" can be a path relative 
    // to the music directory or an absolute path.
    // This command may be used to list metadata of remote files (e.g. URI beginning with "http://" or "smb://").
    // The response consists of lines in the form "KEY: VALUE". Comments with suspicious characters (e.g. newlines) 
    // are ignored silently.
    // The meaning of these depends on the codec, and not all decoder plugins support it. 
    // For example, on Ogg files, this lists the Vorbis comments. 
    public static String readcomments(URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(READCOMMENTS, uri.getPath());
        return mpdRequest.getRequest();
    }

    // search {TYPE} {WHAT} [...] [window START:END]
    // Searches for any song that contains WHAT. Parameters have the same meaning as for find, 
    // except that search is not case sensitive.
    public static String search(FindType type, String what) {              
        MPDRequest mpdRequest = new MPDRequest(SEARCH, type.getFindType(), what);
        return mpdRequest.getRequest();
    }
    
    public static String search(FindType type, String what, Range window) {              
        MPDRequest mpdRequest = new MPDRequest(SEARCH, type.getFindType(), what, window.getRange());
        return mpdRequest.getRequest();
    }

    // searchadd {TYPE} {WHAT} [...]
    // Searches for any song that contains WHAT in tag TYPE and adds them to current playlist.
    // Parameters have the same meaning as for find, except that search is not case sensitive. 
    public static String searchadd(FindType type, String what) {              
        MPDRequest mpdRequest = new MPDRequest(SEARCHADD, type.getFindType(), what);
        return mpdRequest.getRequest();
    }

    // searchaddpl {NAME} {TYPE} {WHAT} [...]
    // Searches for any song that contains WHAT in tag TYPE and adds them to the playlist named NAME.
    // If a playlist by that name doesn't exist it is created.
    // Parameters have the same meaning as for find, except that search is not case sensitive. 
    public static String searchaddpl(String name, FindType type, String what) {              
        MPDRequest mpdRequest = new MPDRequest(SEARCHADDPL, name, type.getFindType(), what);
        return mpdRequest.getRequest();
    }
    
    // update [URI]
    // Updates the music database: find new files, remove deleted files, update modified files.
    // URI is a particular directory or song/file to update. If you do not specify it, everything is updated.
    // Prints "updating_db: JOBID" where JOBID is a positive number identifying the update job. 
    // You can read the current job id in the status response.
    public static String update(URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(UPDATE, uri.getPath());
        return mpdRequest.getRequest();
    }

    // rescan [URI]
    // Same as update, but also rescans unmodified files. 
    public static String rescan(URI uri) {              
        MPDRequest mpdRequest = new MPDRequest(RESCAN, uri.getPath());
        return mpdRequest.getRequest();
    }
    
}
