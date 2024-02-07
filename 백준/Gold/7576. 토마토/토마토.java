
import java.util.*;

public class Main {
    static int Col, Row;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, result;
    static boolean[][] vis;

    static class Tomato {
        int x, y, day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }

        @Override
        public String toString() {
            return "Tomato{" +
                    "x=" + x +
                    ", y=" + y +
                    ", day=" + day +
                    '}';
        }
    }

    static boolean isValid(int x, int y) {
        if (x < 0 || x >= Row || y < 0 || y >= Col) {
            return false;
        }

        if (vis[x][y]) {
            return false;
        }

        return true;
    }

    static void BFS(List<Tomato> tomatoes) {
        Queue<Tomato> q = new LinkedList<>();

        for (Tomato tomato : tomatoes) {
            q.add(tomato);
        }

        while (!q.isEmpty()) {
            Tomato tomato = q.peek();
            q.poll();

            int x = tomato.x;
            int y = tomato.y;
            int day = tomato.day;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny)) {
                    q.add(new Tomato(nx, ny, day + 1));
                    result[nx][ny] = day + 1;
                    vis[nx][ny] = true;
                }
            } // for

//            System.out.println(q);

        } // while
    }

    static boolean allVisited(boolean[][] vis) {
        for (int r = 0; r < Row; r++) {
            for (int c = 0; c < Col; c++) {
                if (!vis[r][c]) {
                    return false;
                }
            } // col
        } // row

        return true;
    }

    static int findMax(int[][] result) {
        int max = 0;

        for (int r = 0; r < Row; r++) {
            for (int c = 0; c < Col; c++) {
                if (result[r][c] > max) {
                    max = result[r][c];
                }
            } // col
        } // row

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Col = sc.nextInt();
        Row = sc.nextInt();

        List<Tomato> tomatoes = new ArrayList<>();

        map = new int[Row][Col];
        result = new int[Row][Col];
        vis = new boolean[Row][Col];

        for (int x = 0; x < Row; x++) {
            for (int y = 0; y < Col; y++) {
                map[x][y] = sc.nextInt();
                if (map[x][y] == 1) {
                    tomatoes.add(new Tomato(x, y, 0));
                    vis[x][y] = true;
                }

                if (map[x][y] == -1) {
                    vis[x][y] = true;
                }
            } // y
        } // x

        BFS(tomatoes);

        if (allVisited(vis)) {
            System.out.println(findMax(result));
        } else {
            System.out.println(-1);
        }

    } // main
}
