package introduce_nullObj;

public class NullLabel extends Label {
	public NullLabel() {
		super("(none)");
	}

	@Override
	public boolean isNull() {
		return true;
	}
}
