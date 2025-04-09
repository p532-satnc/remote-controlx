package edu.iu.habahram.remotecontroller.repository;

import edu.iu.habahram.remotecontroller.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoteLoader implements  IRemoteLoader{
    HashMap<Integer, RemoteControl> remoteControls = new HashMap<>();
    @Override
    public void setup(int id, List<DeviceData> devices) {
        RemoteControl remoteControl = new RemoteControl(devices.size());
        for(DeviceData device : devices) {
            switch (device.type()) {
                case "light":
                    Light light = new Light(device.location());
                    Command lightOn = new LightOnCommand(light);
                    Command lightOff = new LightOffCommand(light);
                    remoteControl.setCommand(device.slot(), lightOn, lightOff);
                    break;
                case "stereo":
                    Stereo stereo = new Stereo(device.location());
                    Command stereoOn = new StereoOnCommand(stereo);
                    Command stereoOff = new StereoOffCommand(stereo);

                    remoteControl.setCommand(device.slot(), stereoOn, stereoOff);
                    break;
                case "ceilingFan":
                    CeilingFan ceilingFan = new CeilingFan(device.location());
                    Command fanOn = new CeilingFanMediumCommand(ceilingFan);
                    Command fanOff = new CeilingFanOffCommand(ceilingFan);

                    remoteControl.setCommand(device.slot(), fanOn, fanOff);

                    break;

            }
        }
        remoteControls.put(id, remoteControl);
        System.out.println(remoteControl.toString());
    }

    @Override
    public String onButtonWasPushed(int id, int slot) {
         return remoteControls.get(id).onButtonWasPushed(slot);
    }

    @Override
    public String offButtonWasPushed(int id, int slot) {
        return remoteControls.get(id).offButtonWasPushed(slot);
    }

    public String undoButtonWasPushed(int id) {
        return remoteControls.get(id).undoButtonWasPushed();
    }
}
