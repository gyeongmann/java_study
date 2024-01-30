import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class N11650 {
	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<Pair> list = new ArrayList<>();
		
		Pair pair;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			pair = new Pair(x, y);
			list.add(pair);
		}
		
		Collections.sort(list, (o1, o2) -> {
			if (o1.x == o2.x) {
				return o1.y - o2.y;
			}
			return o1.x - o2.x;
		});
		
		for (Pair x : list) {
			System.out.println(x);
		}
	}
}
