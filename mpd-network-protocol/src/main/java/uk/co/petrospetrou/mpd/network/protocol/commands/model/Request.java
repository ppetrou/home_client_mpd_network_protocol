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
public class Request {
    
    private final Date resquestTime;
    private final MPDRequest mpdRequest;

    public Request(MPDRequest mpdRequest) {
        resquestTime = new Date();
        this.mpdRequest = mpdRequest;
    }

    public Date getResquestTime() {
        return resquestTime;
    }

    public MPDRequest getMpdRequest() {
        return mpdRequest;
    }

    @Override
    public String toString() {
        return "Request{" + "resquestTime=" + resquestTime + ", mpdRequest=" + mpdRequest + '}';
    }
    
}
