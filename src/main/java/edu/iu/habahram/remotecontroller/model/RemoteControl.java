package edu.iu.habahram.remotecontroller.model;

//
// This is the invoker
//
public class RemoteControl {
	Command[] onCommands;
	Command[] offCommands;
	Command lastCommand;
 
	public RemoteControl(int numberOfDevices) {
		onCommands = new Command[numberOfDevices];
		offCommands = new Command[numberOfDevices];
		lastCommand = new Command() {
			@Override
			public String execute() {

				return null;
			}

			@Override
			public String undo() {

				return null;
			}
		};
 
		for (int i = 0; i < numberOfDevices; i++) {
			onCommands[i] = new Command() {
				@Override
				public String execute() {
					return "";
				}

				@Override
				public String undo() {
					return "";
				}
			};
			offCommands[i] = new Command() {
				@Override
				public String execute() {
					return "";
				}

				@Override
				public String undo() {
					return "";
				}
			};
		}
	}
  
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
 
	public String onButtonWasPushed(int slot) {
		lastCommand = onCommands[slot];
		return onCommands[slot].execute();
	}
 
	public String offButtonWasPushed(int slot) {
		lastCommand = onCommands[slot];
		return offCommands[slot].execute();
	}

	public String undoButtonWasPushed() {
		return lastCommand.undo();
	}

	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
				+ "    " + offCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();
	}

}
