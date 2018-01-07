/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.client;

import uk.co.petrospetrou.mpd.network.protocol.client.exception.InvalidResponseCodeException;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.ConnectResponse;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.DisconnectResponse;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.MPDResponse;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.Request;
import uk.co.petrospetrou.mpd.network.protocol.commands.model.Response;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ppetrou
 */
public class TCPSocketClient {

    private final String clientId;
    private final String hostname;
    private final int portNumber;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    
    private static final String SUCCESS_MSG = "OK";

    public TCPSocketClient(String hostname, int portNumber) {
        this.clientId = UUID.randomUUID().toString();
        this.hostname = hostname;
        this.portNumber = portNumber;
    }

    public Response connect() {

        Response resp;
        ConnectResponse connResponse;
        
        try {
            socket = new Socket(this.hostname, this.portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String tcpResponse = in.readLine();
            
            connResponse = new ConnectResponse(tcpResponse, true);
            resp = new Response(true, connResponse);
        } catch (IOException ex) {
            connResponse = new ConnectResponse(ex.getMessage(), false);
            resp = new Response(false, connResponse);
        }
        
        return resp;

    }

    public Response disconnect() {
        Response resp;
        DisconnectResponse disconResponse;
        
        try {
            socket.close();
            
            disconResponse = new DisconnectResponse(SUCCESS_MSG, true);
            resp = new Response(true, disconResponse);
            
        } catch (IOException ex) {
            disconResponse = new DisconnectResponse(ex.getMessage(), true);
            resp = new Response(false, disconResponse);
        }
        
        return resp;
    }

    public Response sendCommand(Request request) {

        Response response;

        try {

            String mpdRequestCmd = request.getMpdRequest().getRequest();
            List<String> lines = new LinkedList<>();
            
            out.println(mpdRequestCmd);
            String line = in.readLine();
            lines.add(line);
            
            while (in.ready()) {
                line = in.readLine();
                lines.add(line);
            }
            
            try {
                MPDResponse mpdResponse = new MPDResponse(lines);
                response = new Response(true, mpdResponse);
            } catch (InvalidResponseCodeException ex) {
                response = new Response(false, ex.getMessage());
            }
            
            return response;

        } catch (UnknownHostException ex) {
            response = new Response(false, ex.getMessage());
        } catch (IOException ex) {
            response = new Response(false, ex.getMessage());
        }
        
        return response;

    }

    public String getClientId() {
        return clientId;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPortNumber() {
        return portNumber;
    }

    @Override
    public String toString() {
        return "TCPSocketClient{" + "clientId=" + clientId + ", hostname=" + hostname + 
                ", portNumber=" + portNumber + '}';
    }

}
