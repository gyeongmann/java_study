package GraphTheory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1326 {
	static int N;
	static int[] jump, visit;

	static class pair {
		int x, y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return x + "," + y;
		}

	}

	private static int BFS(int a, int b) {
		visit = new int[N + 1];
		Arrays.fill(visit, Integer.MAX_VALUE);

		Queue<pair> queue = new LinkedList<>();
		queue.add(new pair(a, 0));
		visit[a] = 0;

		while (!queue.isEmpty()) {
			pair now = queue.poll();

			// 현재 위치가 목적지
			if (now.x == b) {
				return now.y;
			}

			// 음수 방향 탐색
			for (int i = now.x; i > 0; i -= jump[now.x]) {
				if (now.y + 1 < visit[i]) {
					// 현재 경로로 거쳐간 횟수가 visit 값보다 작으면 대입
					visit[i] = now.y + 1;
					queue.add(new pair(i, now.y + 1));
				}
			}

			// 양수 방향 탐색
			for (int i = now.x; i <= N; i += jump[now.x]) {
				if (now.y + 1 < visit[i]) {
					// 현재 경로로 거쳐간 횟수가 visit 값보다 작으면 대입
					visit[i] = now.y + 1;
					queue.add(new pair(i, now.y + 1));
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		jump = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			jump[i] = sc.nextInt();
		}

		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println(BFS(a, b));
	}
}
