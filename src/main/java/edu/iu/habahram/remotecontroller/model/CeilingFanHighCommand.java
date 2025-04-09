package edu.iu.habahram.remotecontroller.model;

public class CeilingFanHighCommand implements Command {
    private CeilingFan ceilingFan;
    private int prevSpeed; // Track the previous speed

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
        this.prevSpeed = ceilingFan.getSpeed();
    }

    @Override
    public String execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
        return null;
    }

    @Override
    public String undo() {

        switch (prevSpeed) {
            case CeilingFan.HIGH -> ceilingFan.high(); // Set to High
            case CeilingFan.MEDIUM -> ceilingFan.medium(); // Set to medium
            case CeilingFan.LOW -> ceilingFan.low(); // Set to low
            case CeilingFan.OFF -> ceilingFan.off(); // Set to off
        };
        return null;
    }
}

