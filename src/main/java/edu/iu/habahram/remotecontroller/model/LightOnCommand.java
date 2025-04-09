package edu.iu.habahram.remotecontroller.model;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public String execute() {
        light.on();
        return null;
    }

    @Override
    public String undo() {
        light.off();
        return null;
    }
}
