package edu.iu.habahram.remotecontroller.model;

public class Stereo {
    String location;

    public Stereo(String location) {
        this.location = location;
    }

    public String on() {
        return location + " stereo is on";
    }

    public String off() {
        return location + " stereo is off";
    }

    public String setCd() {
        return location + " stereo is set to CD";
    }

    public String setDvd() {
        return location + " stereo is set to DVD";
    }

    public String setRadio() {
        return location + " stereo is set to Radio";
    }

    public String setVolume(int volume) {
        return location + " stereo volume set to " + volume;
    }
}
