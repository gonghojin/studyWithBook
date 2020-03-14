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
		robot.order(Robot.Command.WALK);
		robot.order(Robot.Command.STOP);
		robot.order(Robot.Command.JUMP);
	}
}
