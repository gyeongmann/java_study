package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N27211 {
    static class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int dRow[] = {-1, 0, 1, 0};
    static int dCol[] = {0, 1, 0, -1};

    static boolean isValid(boolean vis[][], int row, int col) {
        if (vis[row][col]) return false;
        return true;
    }

    static void BFS(int grid[][], boolean vis[][], int row, int col, int n, int m) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(row, col));
        vis[row][col] = true;

        while (!q.isEmpty()) {
            pair cell = q.peek();
            int x = cell.x;
            int y = cell.y;

//            System.out.println(grid[x][y] + " ");

            q.remove();

            for (int i = 0; i < 4; i++) {
                int adjx = (x + dRow[i] + n) % n;
                int adjy = (y + dCol[i] + m) % m;

                if (isValid(vis, adjx, adjy)) {
                    q.add(new pair(adjx, adjy));
                    vis[adjx][adjy] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] vis = new boolean[n][m];
        int[][] grid = new int[n][m];
        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sc.nextInt() == 1) vis[i][j] = true;
                else vis[i][j] = false;
                grid[i][j] = idx++;
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    BFS(grid, vis, i, j, n, m);
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
