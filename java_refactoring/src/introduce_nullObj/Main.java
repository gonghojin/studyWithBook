package introduce_nullObj;

public class Main {
	public static void main(String[] args) {
		Person[] people = {
				new Person(new Label("Alice"), new Label("alice@example.com")),
				new Person(new Label("Bobby"), new Label("bobby@example.com")),
				new Person(new Label("Chris")),
		};

		for (Person person: people) {
			System.out.println(person.toString());
			person.display();
			System.out.println("");
		}
	}
}
