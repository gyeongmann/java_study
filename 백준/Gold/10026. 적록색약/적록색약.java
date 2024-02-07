import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, group;
    static char[][] map;
    static boolean[][] vis;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static boolean isValid(int nx, int ny, char color) {
        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
            return false;
        }

        if (vis[nx][ny] || map[nx][ny] != color) { // 방문했거나 색이 다르면
            return false;
        }

        return true;
    }

    static void BFS(int x, int y) {
        group++;
        char color = map[x][y];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        vis[x][y] = true;

        while (!q.isEmpty()) {
//            System.out.println(q);
            Pair pair = q.poll();
            x = pair.x;
            y = pair.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny, color)) {
                    q.add(new Pair(nx, ny));
                    vis[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new char[N][N];
        vis = new boolean[N][N];

        sc.nextLine(); // 줄바꾸기

        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!vis[r][c]) {
                    BFS(r, c);
                }
            }
        }
        System.out.println(group);


        // 2. 적록색약
        vis = new boolean[N][N];
        group = 0;
        // 적록색약 행렬 재생성
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 'G') {
                    map[r][c] = 'R';
                }
            } // col
        } // row

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!vis[r][c]) {
                    BFS(r, c);
                }
            }
        }
        System.out.println(group);

    } // main
}

