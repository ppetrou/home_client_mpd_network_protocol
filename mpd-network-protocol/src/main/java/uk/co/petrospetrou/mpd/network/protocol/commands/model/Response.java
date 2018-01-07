/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.model;

import java.util.Date;

/**
 *
 * @author user1
 */
public class Response {
    
    private final Date responseTime;
    private final boolean success;
    private final String message;
    private final MPDResponse mpdResponse;
    private final ConnectResponse connectResponse;
    private final DisconnectResponse disconnectResponse;

    public Response(boolean success, MPDResponse mpdResponse) {
        this.responseTime = new Date();
        this.success = success;
        this.message = null;
        this.mpdResponse = mpdResponse;
        this.connectResponse = null;
        this.disconnectResponse = null;
    }

    public Response(boolean success, ConnectResponse connectResponse) {
        this.responseTime = new Date();
        this.success = success;
        this.message = null;
        this.mpdResponse = null;
        this.connectResponse = connectResponse;
        this.disconnectResponse = null;
    }
    
    public Response(boolean success, DisconnectResponse disconnectResponse) {
        this.responseTime = new Date();
        this.success = success;
        this.message = null;
        this.mpdResponse = null;
        this.connectResponse = null;
        this.disconnectResponse = disconnectResponse;
    }
        
    public Response(boolean success, String message) {
        this.responseTime = new Date();
        this.success = success;
        this.message = message;
        this.mpdResponse = null;
        this.connectResponse = null;
        this.disconnectResponse = null;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
    
    public MPDResponse getMpdResponse() {
        return mpdResponse;
    }

    public ConnectResponse getConnectResponse() {
        return connectResponse;
    }

    public DisconnectResponse getDisconnectResponse() {
        return disconnectResponse;
    }

}
