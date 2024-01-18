package GraphTheory;

import java.util.Arrays;
import java.util.Scanner;

public class N1520 {
    static int[][] map, dp;
    static int M, N;

    static int dRow[] = { 0, 1, 0, -1 };
    static int dCol[] = { -1, 0, 1, 0 };

    static int DFS(int r, int c) {
        System.out.println(r + " " + c);
        if (r == M - 1 && c == N - 1) {

            return 1;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 0;

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i< 4; i++) {
            int nr = r + dRow[i];
            int nc = c + dCol[i];

            if (nr < 0 || nr >= M || nc < 0 || nc >= N)
                continue;

            if (map[nr][nc] < map[r][c])
                dp[r][c] += DFS(nr, nc);

        }

        return dp[r][c];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[M][N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        // Dynamic Programming
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0, 0));

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }
}
