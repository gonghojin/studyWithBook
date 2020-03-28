package introduce_nullObj;

public class Label {
	private final String label;

	public Label(String label) {
		this.label = label;
	}

	public void display() {
		System.out.println("display: " + label);
	}

	@Override
	public String toString() {
		return "\"" + label + "\"";
	}
}
