import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, group;
	static int[][] map;
	static boolean[][] vis; // 방문했던 곳이나 

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Pair {
		int x, y, count;

		public Pair(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", count=" + count + "]";
		}

	}
	
	static boolean isValid(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= N || ny >= N) { // out of bounds
			return false;
		}
		
		if (vis[nx][ny]) {
			return false;
		}
		
		return true;
	}

	static void BFS(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		
		group++;
		q.add(new Pair(x, y, group));
		vis[x][y] = true;

		while (!q.isEmpty()) {
			Pair pair = q.poll();

			x = pair.x;
			y = pair.y;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (isValid(nx, ny)) {
					q.add(new Pair(nx, ny, group));
					vis[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		int max = 0;

		// 비 높이 설정
		for (int rain = 0; rain <= 100; rain++) {
			vis = new boolean[N][N]; // 불린 행렬 초기화
			group = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] <= rain) {
						vis[r][c] = true;
					}
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!vis[r][c]) { // 간 적이 없으면
						BFS(r, c);
					}
				}
			}
			
			if (group == 0)
				break;
			
			if (group > max) {
				max = group;
			}
		}
		
		System.out.println(max);

	} // main
}
