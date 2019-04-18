package com.group4.Objects;

import com.group4.Objects.MapSite;

public class Wall extends MapSite {
    public Wall(){
        _wallNr = _wallCnt++;
//        System.out.println("creating Wall #" + new Integer(_wallNr).toString());
    }
    public String toString(){ return "Wall #" + new Integer(_wallNr).toString(); }
    private int _wallNr;
    private static int _wallCnt = 1;
}