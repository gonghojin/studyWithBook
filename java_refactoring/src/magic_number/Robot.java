package magic_number;

/*
public class Robot {
	private final String _name;

	public Robot(String name) {
		this._name = name;
	}
	
	public void order(int command) {
		if (command == 0) {
			System.out.println(_name + " walks.");
		} else if (command == 1) {
			System.out.println(_name + " stops.");
		} else if (command == 2) {
			System.out.println(_name + " jumps.");
		} else {
			System.out.println("Command error. command = " + command);
		}
	}
}
*/
/*

public class Robot {
	private final String _name;

	public static final int COMMAND_WALK = 0;
	public static final int COMMAND_STOP = 1;
	public static final int COMMAND_JUMP = 2;


	public Robot(String name) {
		this._name = name;
	}

	public void order(int command) {
		if (command == COMMAND_WALK) {
			System.out.println(_name + " walks.");
		} else if (command == COMMAND_STOP) {
			System.out.println(_name + " stops.");
		} else if (command == COMMAND_JUMP) {
			System.out.println(_name + " jumps.");
		} else {
			System.out.println("Command error. command = " + command);
		}
	}
}
*/

public class Robot {
	private final String _name;

	public enum Command {
		WALK,
		STOP,
		JUMP,
	};

	public Robot(String name) {
		this._name = name;
	}

	public void order(Robot.Command command) {
		if (command == Command.WALK) {
			System.out.println(_name + " walks.");
		} else if (command == Command.STOP) {
			System.out.println(_name + " stops.");
		} else if (command == Command.JUMP) {
			System.out.println(_name + " jumps.");
		} else {
			System.out.println("Command error. command = " + command);
		}
	}
}