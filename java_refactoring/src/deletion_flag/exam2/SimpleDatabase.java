package deletion_flag.exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleDatabase {
	private Map<String, String> map = new HashMap<>();

	// 의미 전달이 되지 않는 변수명을 리팩토링
	public SimpleDatabase(Reader r) throws IOException {
		BufferedReader reader = new BufferedReader(r);
		boolean reading = false;
		String line;
		while (!reading) {
			line = reader.readLine();
			if (line == null) {
				reading = true;
			} else {
				boolean scanningKey = true;
				StringBuffer keyBuffer = new StringBuffer();
				StringBuffer valueBuffer = new StringBuffer();
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (scanningKey) {
						if (c == '=') {
							scanningKey = false;
						} else {
							keyBuffer.append(c);
						}
					} else {
						valueBuffer.append(c);
					}

				}
				String key = keyBuffer.toString();
				String value = valueBuffer.toString();
				map.put(key, value);
			}
		}
	}

	public void putValue(String key, String value) {
		map.put(key,value);
	}

	public String getValue(String key) {
		return map.get(key);
	}

	public Iterator<String> iterator() {
		return map.keySet().iterator();
	}
}
