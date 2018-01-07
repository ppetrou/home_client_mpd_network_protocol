/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.model;

import java.util.List;

/**
 *
 * @author petros
 */
public class MPDCommandList {
    
    private static final String COMMAND_LIST_BEGIN = "command_list_begin";
    private static final String COMMAND_LIST_OK_BEGIN = "command_list_ok_begin";
    private static final String COMMAND_LIST_END = "command_list_end";
    
    private static final String COMMAND_LIST_OK_BEGIN_SUCCESS = "list_OK";
    private static final String FAILURE = "ACK";
    
    private static final String NEWLINE = "\n";

    private final List<MPDRequest> requests;
    private final boolean listOK;
    
    public MPDCommandList(List<MPDRequest> requests, boolean listOK) {
        this.listOK = listOK;
        this.requests = requests;
    }
    
    public String getRequest() {
        
        String requestsCmd = "";
        
        if (listOK) {
            requestsCmd += COMMAND_LIST_OK_BEGIN;
        } else {
            requestsCmd += COMMAND_LIST_BEGIN;
        }
        
        for (MPDRequest req : requests) {
            requestsCmd += req.getRequest() + NEWLINE;            
        }
        
        requestsCmd += COMMAND_LIST_END;
        
        return requestsCmd;
        
    }

    @Override
    public String toString() {
        return "MPDCommandList{" + "requests=" + requests + ", listOK=" + listOK + '}';
    }
            
}
