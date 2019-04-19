package com.group4.Objects;

import com.group4.Objects.MapSite;

public class Wall extends MapSite {

    private int wallNr;
    private static int wallCnt = 1;

    public Wall(){
        wallNr = wallCnt++;
//        System.out.println("creating Wall #" + new Integer(_wallNr).toString());
    }
    public String toString(){ return "Wall #" + new Integer(wallNr).toString(); }

}