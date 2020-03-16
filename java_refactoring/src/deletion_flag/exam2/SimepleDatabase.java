package deletion_flag.exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class SimepleDatabase {
	private Map<String, String> map = new HashMap<>();

	public SimepleDatabase(Reader r1) throws IOException {
		BufferedReader r2 = new BufferedReader(r1);
		boolean flag = false;
		String tmp;
		while (!flag) {
			tmp = r2.readLine();
			if (tmp == null) {
				flag = true;
			} else {
				boolean flag2 = true;
				StringBuffer s1 = new StringBuffer();
				StringBuffer s2 = new StringBuffer();
				for (int i = 0; i < tmp.length(); i++) {
					char tmp2 = tmp.charAt(i);
					if (flag2) {
						if (tmp2 == '=') {
							flag2 = false;
						} else {
							s1.append(tmp2);
						}
					} else {
						s2.append(tmp2);
					}

				}
				String ss1 = s1.toString();
				String ss2 = s2.toString();
				map.put(ss1, ss2);
			}
		}
	}
}
