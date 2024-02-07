import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, H;
	static int[][][] map;

	static Queue<Point> q;

	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	static class Point {
		int x, y, z;

		public Point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

	static boolean isValid(int nx, int ny, int nz) {
		// out of bounds
		if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) {
			return false;
		}

		if (map[nx][ny][nz] == -1) { // 벽에 부딪히면
			return false;
		}

		return true;
	}

	static void BFS() {
		while (!q.isEmpty()) {
			Point p = q.poll();

			int x = p.x;
			int y = p.y;
			int z = p.z;

			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				
				if (isValid(nx, ny, nz) && map[nx][ny][nz] == 0) {
					q.add(new Point(nx, ny, nz));
					map[nx][ny][nz] = map[x][y][z] + 1;
				}
			}
		}
	}
	
	static int getMax() {
		int max = 0;
		
		for (int z = 0; z < H; z++) {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (map[x][y][z] > max) {
						max = map[x][y][z];
					}
				}
			}
		}
		
		return max;
	}
	
	static boolean existZero() {
		for (int z = 0; z < H; z++) {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (map[x][y][z] ==  0) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); // 가로 칸 수 - 열
		N = sc.nextInt(); // 새로 칸 수 - 행
		H = sc.nextInt(); // 높이

		map = new int[N][M][H];
		q = new LinkedList<>();

		for (int z = 0; z < H; z++) {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					int next = sc.nextInt();
					
					if (next == 1) {
						q.add(new Point(x, y, z));
					}
					
					map[x][y][z] = next;
				}
			}
		}
		
		BFS();
		
		if (existZero()) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(getMax() - 1);
		
	} // main
}
