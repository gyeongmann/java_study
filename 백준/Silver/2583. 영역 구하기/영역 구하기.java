import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int M, N, K, group;
	static List<Integer> ans = new ArrayList<>();

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static boolean isValid(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= M || nc >= N) {
			return false;
		}

		if (map[nr][nc] == -1) {
			return false;
		}

		return true;
	}

	static void BFS(int r, int c) {
		Queue<Pair> q = new LinkedList<>();
		
		int cnt = 0;
		
		q.offer(new Pair(r, c));
		group++;
		map[r][c] = group;
		ans.add(group, ++cnt);
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			r = pair.r;
			c = pair.c;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (isValid(nr, nc) && map[nr][nc] == 0) {
					q.add(new Pair(nr, nc));
					map[nr][nc] = group;
					ans.set(group, ++cnt);
				}
			}
		}
		
	}

	static void draw(int r1, int c1, int r2, int c2) {
		for (int r = r1; r < r2; r++) {
			for (int c = c1; c < c2; c++) {
				map[r][c] = -1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();

		map = new int[M][N];
		ans.add(0);

		for (int i = 0; i < K; i++) {
			int c1 = sc.nextInt();
			int r1 = sc.nextInt();
			int c2 = sc.nextInt();
			int r2 = sc.nextInt();

			draw(r1, c1, r2, c2);
		}
		
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 0) {
					BFS(r, c);
				}
			}
		}
		
		System.out.println(group);
		Collections.sort(ans);
		for (int i = 1; i <= group; i++) {
			System.out.print(ans.get(i) + " ");
		}
		
	}

}
