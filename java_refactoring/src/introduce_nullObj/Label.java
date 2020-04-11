package introduce_nullObj;

public class Label {
	private final String label;

	public Label(String label) {
		this.label = label;
	}

	public void display() {
		System.out.println("display: " + label);
	}

	public boolean isNull() {
		return false;
	}

	@Override
	public String toString() {
		return "\"" + label + "\"";
	}

	// 팩토리 메서드
	public static Label newNull() {
		return NullLabel.getInstance();
	}

	// 널 객체
	private static class NullLabel extends Label {
		// 싱글톤
		private static final NullLabel singleton = new NullLabel();

		private static NullLabel getInstance() {
			return singleton;
		}

		private NullLabel() {
			super("(none)");
		}

		@Override
		public boolean isNull() {
			return true;
		}

		@Override
		public void display() {
		}

	}
}
