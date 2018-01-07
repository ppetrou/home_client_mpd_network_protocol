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
public class ConnectResponse {
    
    private String response;
    private boolean connected;

    public ConnectResponse(String response, boolean connected) {
        this.response = response;
        this.connected = connected;
    }

    public String getResponse() {
        return response;
    }

    public boolean isConnected() {
        return connected;
    }

    @Override
    public String toString() {
        return "ConnectResponse{" + "response=" + response + ", connected=" + connected + '}';
    }
        
}
