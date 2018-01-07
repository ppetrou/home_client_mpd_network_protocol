/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.client.exception;

/**
 *
 * @author user1
 */
public class InvalidResponseCodeException extends Exception {

    public InvalidResponseCodeException() {
    }

    public InvalidResponseCodeException(String msg) {
        super(msg);
    }

    public InvalidResponseCodeException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
