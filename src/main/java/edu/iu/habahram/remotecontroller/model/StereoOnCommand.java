package edu.iu.habahram.remotecontroller.model;

public class StereoOnCommand implements Command {
    private Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public String execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(8);
        return null;
    }

    @Override
    public String undo() {
        stereo.off();

        return null;
    }
}

