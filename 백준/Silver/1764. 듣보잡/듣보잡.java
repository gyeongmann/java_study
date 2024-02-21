import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			map.put(sc.next(), 1);
		}
		
		for (int j = 0; j < M; j++) {
			String name = sc.next();
			if (map.containsKey(name)) {
				map.put(name, 2);
				continue;
			}
			map.put(name, 1);
		}
		
		List<String> list = new ArrayList<>();
		
		for (String name : map.keySet()) {
			int cnt = map.get(name);
			if (cnt == 2) {
				list.add(name);
			}
		}
		Collections.sort(list);
		
		System.out.println(list.size());
		for (String name : list) {
			System.out.println(name);
		}
	}
}
