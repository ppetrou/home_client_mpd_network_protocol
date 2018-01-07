/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.model;

import uk.co.petrospetrou.mpd.network.protocol.client.exception.InvalidResponseCodeException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author petros
 */
public class MPDResponse {

    private static final String SUCCESS = "OK";
    private static final String FAILURE = "ACK";
    private static final String RESPONSE_SEPERATOR = " ";
    private static final String ERROR_SEPERATOR = "@";

    // ACK [50@1] {play} song doesn't exist: "10240"
    private final String commandResponse;
    private final List<String> dataLines;
    private String error;
    private String commandListNum;
    private String currentCommand;
    private String messageText;
    private List<String> rawResponseLines;

    // TODO Rename Exception
    public MPDResponse(List<String> responseLines) throws InvalidResponseCodeException {

        // ACK [50@1] {play} song doesn't exist: "10240" 
        // http://www.musicpd.org/doc/protocol/response_syntax.html
        String response = "";
        dataLines = new LinkedList<String>();

        // Find the response line with the response code.
        for (String line : responseLines) {
            if (line.startsWith(SUCCESS) || line.startsWith(FAILURE)) {
                response = line;
            } else {
                dataLines.add(line);
            }
        }

        String[] responseParts = response.split(RESPONSE_SEPERATOR);
        this.commandResponse = responseParts[0];

        // Check for valid responseLines
        String regExp = SUCCESS + "|" + FAILURE;
        if (!commandResponse.matches(regExp)) {
            throw new InvalidResponseCodeException("Invalid Response Code");
        }

        // Initialize the error fields if FAILURE
        if (this.commandResponse.equals(FAILURE)) {
            String errorPart = responseParts[1];
            this.currentCommand = responseParts[2];
            
            // Join the message part of the response.
            // 3 is the index of the array where the message starts.
            this.messageText = "";
            for (int i = 3; i < responseParts.length; i++) {
                this.messageText += responseParts[i] + RESPONSE_SEPERATOR;
            }

            // Get the error and commandListNum, removing []. e.g. [50@1]
            String[] errorParts = errorPart.split(ERROR_SEPERATOR);
            this.error = errorParts[0].substring(1);
            this.commandListNum = errorParts[1].substring(0, errorParts[1].length()-1);
        }

    }

    public String getCommandResponse() {
        return commandResponse;
    }

    public List<String> getDataLines() {
        return dataLines;
    }

    public String getError() {
        return error;
    }

    public String getCommandListNum() {
        return commandListNum;
    }

    public String getCurrentCommand() {
        return currentCommand;
    }

    public String getMessageText() {
        return messageText;
    }

    public List<String> getRawResponseLines() {
        return rawResponseLines;
    }

    @Override
    public String toString() {
        return "MPDResponse{" + "commandResponse=" + commandResponse + ", dataLines=" + 
                dataLines + ", error=" + error + ", commandListNum=" + commandListNum + 
                ", currentCommand=" + currentCommand + ", messageText=" + messageText + 
                ", rawResponseLines=" + rawResponseLines + '}';
    }

}
