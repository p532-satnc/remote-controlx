package edu.iu.habahram.remotecontroller.model;

public class StereoOffCommand implements Command {
    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public String execute() {
        stereo.off();

        return null;
    }

    @Override
    public String undo() {
         new StereoOnCommand(stereo).execute();
        return null;
    }
}

