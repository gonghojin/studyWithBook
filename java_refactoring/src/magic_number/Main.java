package magic_number;

/*
public class Main {
	public static void main(String[] args) {
		Robot robot = new Robot("Andrew");
		robot.order(0);
		robot.order(1);
		robot.order(2);
	}
}
*/
public class Main {
	public static void main(String[] args) {
		Robot robot = new Robot("Andrew");
		robot.order(Robot.COMMAND_WALK);
		robot.order(Robot.COMMAND_STOP);
		robot.order(Robot.COMMAND_JUMP);
	}
}
