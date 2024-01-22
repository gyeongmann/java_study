package DynammicProgramming;

import java.util.Scanner;

public class N17070 {
    static int count, n;

    static boolean isValid(int[][] map, int x, int y) {
        // out of bounds
        if (x >= n || y >= n) return false;
        if (map[x][y] == 1) return false;

        return true;
    }

    static void DFS(int[][] map, int x, int y, int dir) {
        if (x == n - 1 && y == n - 1) count++;

        // 1. 가로
        if (dir == 1) {
            if (isValid(map, x, y+1)) {
                DFS(map, x, y+1, 1);
            }

            if (isValid(map, x+1, y) &&
                    isValid(map, x+1, y+1) &&
                    isValid(map, x, y+1)) {
                DFS(map, x+1, y+1, 3);
            }
        }
        // 2. 세로
        else if (dir == 2) {
            if (isValid(map, x+1, y)) {
                DFS(map, x+1, y, 2);
            }

            if (isValid(map, x+1, y) &&
                    isValid(map, x+1, y+1) &&
                    isValid(map, x, y+1)) {
                DFS(map, x+1, y+1, 3);
            }
        }
        // 3. 대각
        else {
            if (isValid(map, x, y+1)) {
                DFS(map, x, y+1, 1);
            }

            if (isValid(map, x+1, y)) {
                DFS(map, x+1, y, 2);
            }

            if (isValid(map, x+1, y) &&
                    isValid(map, x+1, y+1) &&
                    isValid(map, x, y+1)) {
                DFS(map, x+1, y+1, 3);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        DFS(map, 0, 1, 1);

        System.out.println(count);
    }

}
