package edu.iu.habahram.remotecontroller.model;

public class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;
    private int prevSpeed; // Track the previous speed

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
        this.prevSpeed = ceilingFan.getSpeed();
    }

    @Override
    public String execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
        return null;
    }

    @Override
    public String undo() {

        switch (prevSpeed) {
            case CeilingFan.HIGH -> ceilingFan.high();
            case CeilingFan.MEDIUM -> ceilingFan.medium();
            case CeilingFan.LOW -> ceilingFan.low();
            case CeilingFan.OFF -> ceilingFan.off();
        };
        return null;
    }
}
