package GraphTheory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N17070 {

    static class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dRow = {0, 1, 1};
    static int[] dCol = {1, 1, 0};

    // 1. isValid()
    static boolean isValid(boolean matrix[][], int row, int col, boolean diagonal) {
        int n = matrix.length;

        if (row >= n || col >= n) return false;
        if (matrix[row][col]) return false;
        if (diagonal) {
            if (matrix[row - 1][col] || matrix[row][col - 1]) {
                return false;
            }
        }

        return true;
    }

    static Queue<pair> q = new LinkedList<>();

    // 2. move()
    static void move(boolean matrix[][], int row, int col,
                     boolean goRight, boolean goDownRight, boolean goDown) {
        if (goRight) {
            col++;
            if (isValid(matrix, row, col, false)) {
                System.out.println("goRight");
                q.add(new pair(row, col));
                move(matrix, row, col, true, false, false);
                move(matrix, row, col, false, true, false);
            }
        }

        if (goDownRight) {
            row++;
            col++;
            if (isValid(matrix, row, col, true)) {
                System.out.println("goDownRight");
                q.add(new pair(row, col));
                move(matrix, row, col, true, false, false);
                move(matrix, row, col, false, true, false);
                move(matrix, row, col, false, false, true);
            }
        }

        if (goDown) {
            row++;
            if (isValid(matrix, row, col, false)) {
                System.out.println("goDown");
                q.add(new pair(row, col));
                move(matrix, row, col, false, true, false);
                move(matrix, row, col, false, false, true);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean[][] matrix = new boolean[n][n];
        int[][] grid = new int[n][n];
        int idx = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() == 1) {
                    matrix[i][j] = true;
                }
                grid[i][j] = idx++;
            }
        }

//        q.add(new pair(0, 1));

        for (int i = 0; i < 3; i++) {
            move(matrix, 0, 1, true, false, false);

        }

        System.out.println(q.toString());

//        do {
//            move(matrix, 0, 0, true, false, false);
//            pair cell = q.peek();
//            int x = cell.x;
//            int y = cell.y;
//
//            System.out.print(grid[x][y] + " ");
//            q.remove();
//        } while (!q.isEmpty());
    }
}