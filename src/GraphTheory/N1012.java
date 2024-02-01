import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M, N, count;
	static int[][] map;
	static boolean[][] vis;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean isValid(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N) {
			return false;
		}

		if (vis[x][y] || map[x][y] == 0) {
			return false;
		}

		return true;
	}

	static void BFS(int r, int c) {
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(r, c));
		vis[r][c] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();
			
			int x = p.x;
			int y = p.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isValid(nx, ny)) {
					q.add(new Pair(nx, ny));
					vis[nx][ny] = true;
				}
      }
		} // while

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			count = 0;

			map = new int[M][N];
			vis = new boolean[M][N];

			int K = sc.nextInt();

			for (int i = 0; i < K; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();

				map[r][c] = 1;
			}
			
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1 && !(vis[r][c])) {
						count++;
						BFS(r, c);
					}
				}
			}
			
			sb.append(count).append('\n');
		} // test case
		
		System.out.println(sb);
	} // main
}
