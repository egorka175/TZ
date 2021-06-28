package com.tms.TZ;

import java.util.List;

public class MarineType {
    String Marine;

    public MarineType(String marine) {
        Marine = marine;
    }

    public String getMarine() {
        return Marine;
    }

    public void setMarine(String marine) {
        Marine = marine;
    }

    @Override
    public String toString() {
        return "MarineType{" +
                "Marine='" + Marine + '\'' +
                '}';
    }
}
