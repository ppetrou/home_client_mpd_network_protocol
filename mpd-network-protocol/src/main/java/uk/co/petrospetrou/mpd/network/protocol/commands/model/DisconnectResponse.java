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
public class DisconnectResponse {
    
    private String response;
    private boolean disconnected;

    public DisconnectResponse(String response, boolean connected) {
        this.response = response;
        this.disconnected = connected;
    }

    public String getResponse() {
        return response;
    }

    public boolean isConnected() {
        return disconnected;
    }

    @Override
    public String toString() {
        return "DisconnectResponse{" + "response=" + response + ", connected=" + disconnected + '}';
    }
    
}
