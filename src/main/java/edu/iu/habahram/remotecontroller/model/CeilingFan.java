package edu.iu.habahram.remotecontroller.model;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public String high() {
        speed = HIGH;
        return location + " ceiling fan is on high";
    }

    public String medium() {
        speed = MEDIUM;
        return location + " ceiling fan is on medium";
    }

    public String low() {
        speed = LOW;
        return location + " ceiling fan is on low";
    }

    public String off() {
        speed = OFF;
        return location + " ceiling fan is off";
    }

    public int getSpeed() {
        return speed;
    }
}
