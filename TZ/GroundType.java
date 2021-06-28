package com.tms.TZ;

import java.util.List;

public class GroundType {
    String Ground;

    public GroundType(String ground) {
        Ground = ground;
    }

    public String getGround() {
        return Ground;
    }

    public void setGround(String ground) {
        Ground = ground;
    }

    @Override
    public String toString() {
        return "GroundType{" +
                "Ground='" + Ground + '\'' +
                '}';
    }
}
