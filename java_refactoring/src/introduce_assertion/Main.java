package introduce_assertion;

import java.util.Random;

public class Main {
	private static final Random random = new Random(1234);

	private static void execute(int length) {
		// 난수로 데이터 작성
		int[] data = new int[length];
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(data.length);
		}

		// 데이터 표시
		SortSample sortSample = new SortSample(data);
		System.out.println("BEFORE:" + sortSample);

		// 정렬해서 표시
		sortSample.sort();
		System.out.println(" AFTER:" + sortSample);

		System.out.println();
	}
	public static void main(String[] args) {
		execute(10);
		execute(10);
		execute(10);
		execute(10);
		execute(10);
	}
}
