package com.tms.TZ;

import java.util.List;

public class AirType {
    String Air;

    public AirType(String air) {
        Air = air;
    }

    public String getAir() {
        return Air;
    }

    public void setAir(String air) {
        Air = air;
    }

    @Override
    public String toString() {
        return "AirType{" +
                "Air='" + Air + '\'' +
                '}';
    }
}
