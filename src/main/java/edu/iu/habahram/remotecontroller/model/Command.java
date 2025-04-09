package edu.iu.habahram.remotecontroller.model;

public interface Command {
    public String execute();
    public String undo();
}
