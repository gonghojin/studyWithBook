package magic_number;

public class RobotCommand {
	private final String _name;

	public RobotCommand(String name) {
		this._name = name;
	}

	@Override
	public String toString() {
		return "RobotCommand{" +
				"_name='" + _name + '\'' +
				'}';
	}
}
