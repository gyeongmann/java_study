import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int w, h, group;
    static int[][] map;
    static boolean[][] vis;

    static int[] dr = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean isValid(int nr, int nc) {
        // out of bounds
        if (nr < 0 || nc < 0 || nr >= w || nc >= h) {
            return false;
        }

        // 바다거나 방문했거나
        if (vis[nr][nc] || map[nr][nc] == 0) {
            return false;
        }

        return true;
    }

    static void BFS(int r, int c) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(r, c));
        vis[r][c] = true;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            r = pair.r;
            c = pair.c;

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isValid(nr, nc)) {
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }

        group++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            h = sc.nextInt();
            w = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[w][h];
            vis = new boolean[w][h];
            group = 0;

            for (int r = 0; r < w; r++) {
                for (int c = 0; c < h; c++) {
                    map[r][c] = sc.nextInt();
                }
            }

            for (int r = 0; r < w; r++) {
                for (int c = 0; c < h; c++) {
                    if (map[r][c] == 1 && !vis[r][c]) {
                        BFS(r, c);
                    }
                }
            }

            sb.append(group).append('\n');
        } // test case

        System.out.print(sb);

    }
}
