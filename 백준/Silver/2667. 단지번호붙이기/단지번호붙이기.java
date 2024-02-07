
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, group;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] vis;
	static List<Pair> res = new ArrayList<>();

	static class Pair {
		int x, y, group;

		public Pair(int x, int y, int group) {
			super();
			this.x = x;
			this.y = y;
			this.group = group;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", group=" + group + "]";
		}

	}

	static boolean isValid(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) {
//			System.out.println("out of bounds");
			return false;
		}

		if (vis[x][y] || map[x][y] == 0) {
			return false;
		}

		return true;
	}

	static void BFS(int x, int y) {
		if (!isValid(x, y)) {
			return;
		}

		vis[x][y] = true;
		Queue<Pair> q = new LinkedList<>();
		Pair pair = new Pair(x, y, group);
		q.add(pair);
		res.add(pair);
//		System.out.println(q);

		while (!q.isEmpty()) {
			Pair cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (isValid(nx, ny)) {
					vis[nx][ny] = true;
					Pair next = new Pair(nx, ny, group);
					q.add(next);
					res.add(next);
				}
			} // for

//			System.out.println(q);
		} // while

		group++;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = Integer.parseInt(sc.nextLine());

		map = new int[N][N];
		vis = new boolean[N][N];
		group = 1;

		for (int row = 0; row < N; row++) {
			String[] line = sc.nextLine().split("");

			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(line[col]);
			} // col
		} // row

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				BFS(x, y);
			}
		}

//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}

		System.out.println(group - 1);

		int[] count = new int[group - 1];

		for (Pair pair : res) {
			count[pair.group - 1]++;
		}

		Arrays.sort(count);

		for (int i = 0; i < group - 1; i++) {
			System.out.println(count[i]);
		}
	} // main
}
