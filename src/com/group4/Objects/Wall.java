package com.group4.Objects;

import com.group4.Interfaces.MapSite;

public class Wall implements MapSite {

    private int wallNr;
    private static int wallCnt = 1;

    public Wall(){
        wallNr = wallCnt++;
    }


    @Override
    public String toString(){ return "Wall #" + wallNr; }

}