package edu.iu.habahram.remotecontroller.model;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public String execute() {
        light.off();
        return null;
    }

    @Override
    public String undo() {
        light.on();
        return null;
    }
}