package com.example.akshay.warehouse.putaway;

import com.example.akshay.warehouse.models.Rtag;

import java.util.List;

/**
 * Created by akshay on 29/10/15.
 */
public class RtagDataResponse {
    private List<Rtag> rtags;

    public List<Rtag> getRtags() {
        return rtags;
    }

    public void setRtags(List<Rtag> rtags) {
        this.rtags = rtags;
    }
}
