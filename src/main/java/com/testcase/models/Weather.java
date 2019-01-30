package com.testcase.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class Weather {
    private static SecureRandom random = new SecureRandom();

    @Autowired
    private GeoLocation geoLocation;

    private Byte temperature;
    private Short pressure;

    @Autowired
    private Wind wind;

    public Byte getTemperature() {
        return temperature;
    }

    public void setTemperature(Byte temperature) {
        this.temperature = temperature;
    }

    public Short getPressure() {
        return pressure;
    }

    public void setPressure(Short pressure) {
        this.pressure = pressure;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    @Component
    public static class Wind {

        private Byte speed;

        @Autowired
        private DirectionEnum direction;

        public DirectionEnum getDirection() {
            return direction;
        }

        public void setDirection(DirectionEnum direction) {
            this.direction = direction;
        }

        public Byte getSpeed() {
            return speed;
        }

        public void setSpeed(Byte speed) {
            this.speed = speed;
        }

        @Component
        public enum DirectionEnum {
            south,
            east,
            west,
            north
        }

        static Wind generateRandom() {

            Wind wind = new Wind();
            wind.direction =  DirectionEnum.values()[random.nextInt(DirectionEnum.values().length)];

            byte bytes1[] = new byte[1];
            random.nextBytes(bytes1);

            wind.speed = bytes1[0];

            return wind;
        }
    }

    public static class Randomizer {

        public static Weather generateWeather(GeoLocation geoLocation) {

            Weather weather = new Weather();
            byte bytes[] = new byte[1];
            random.nextBytes(bytes);

            weather.geoLocation = geoLocation;
            weather.temperature = bytes[0];
            weather.pressure = (short) random.nextInt(Short.MAX_VALUE + 1);

            weather.wind = Wind.generateRandom();

            return weather;
        }
    }
}
