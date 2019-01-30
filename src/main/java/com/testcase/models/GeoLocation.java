package com.testcase.models;

import org.springframework.stereotype.Component;

@Component
public class GeoLocation {

    private Double longitude;
    private Double latitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        if ((latitude < -180) || (latitude > 180)) throw new IllegalArgumentException("Incorrect latitude value");
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        if ((longitude < -90) || (longitude > 90)) throw new IllegalArgumentException("Incorrect latitude value");
        this.longitude = longitude;
    }
}
