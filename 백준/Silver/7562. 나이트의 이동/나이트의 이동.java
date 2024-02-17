import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int r, c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}

public class Main {
    static int L;
    static int[][] map, dist;
    static boolean[][] vis;

    static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};

    static boolean isValid(int nr, int nc) {
        // out of bounds
        if (nr < 0 || nc < 0 || nr >= L || nc >= L) {
            return false;
        }

        if (vis[nr][nc]) {
            return false;
        }

        return true;
    }

    static void BFS(int r, int c, int destR, int destC) {
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
                    dist[nr][nc] = dist[r][c] + 1;
                    vis[nr][nc] = true;
                }
            }

            if (dist[destR][destC] != 0) {
                System.out.println(dist[destR][destC]);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스의 개수
        for (int t = 0; t < T; t++) {
            L = sc.nextInt();

            map = new int[L][L];
            dist = new int[L][L];
            vis = new boolean[L][L];

            int r = sc.nextInt(); // 현재 행 좌표
            int c = sc.nextInt(); // 현재 열 좌표

            int destR = sc.nextInt(); // 목적지 행 좌표
            int destC = sc.nextInt(); // 목적지 열 좌표

            if (r == destR && c == destC) {
                System.out.println(0);
                continue;
            }
            BFS(r, c, destR, destC);

        } // test case
    } // main
}
