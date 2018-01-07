/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.petrospetrou.mpd.network.protocol.commands.model;

/**
 *
 * @author petros
 */
public class MPDRequest {

    private static final String ARG_SEPERATOR = " ";

    private final String command;
    private final String[] args;

    public MPDRequest(String command, String... args) {
        this.command = command;
        this.args = args;
    }  

    public String getRequest() {
        String requestCmd = this.command;
        
        // Check for empty argument list! Commands like "previous" do not use any arguments.
        if (args != null) {
            for (String arg : args) {
                requestCmd += ARG_SEPERATOR + formatArg(arg);
            }
        }

        return requestCmd;
    }
    
    private String formatArg(String arg) {
        // Wrap argument to double quotation marks if it contains spaces.
        // http://www.musicpd.org/doc/protocol/request_syntax.html
        return arg.contains(" ")?"\"" + arg + "\"":arg;
    } 

    @Override
    public String toString() {
        return "MPDRequest{" + "command=" + command + ", args=" + args + '}';
    }

}
