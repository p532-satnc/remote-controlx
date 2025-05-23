package edu.iu.habahram.remotecontroller.model;

public class CeilingFanMediumCommand implements Command {
    private CeilingFan ceilingFan;
    private int prevSpeed; // Track the previous speed

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
        this.prevSpeed = ceilingFan.getSpeed();
    }

    @Override
    public String execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
        return null;
    }

    @Override
    public String undo() {
        // Undo by setting the fan back to its previous speed
        switch (prevSpeed) {
            case CeilingFan.HIGH -> ceilingFan.high();
            case CeilingFan.MEDIUM -> ceilingFan.medium();
            case CeilingFan.LOW -> ceilingFan.low();
            case CeilingFan.OFF -> ceilingFan.off();
        };
        return null;
    }
}