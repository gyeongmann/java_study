import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static void fixBottom(int bottom, int idx, int[][] dice) {
        int a = dice[idx][0];
        int b = dice[idx][1];
        int c = dice[idx][2];
        int d = dice[idx][3];
        int e = dice[idx][4];
        int f = dice[idx][5];

        if (f == bottom) {
        } else if (d == bottom) {
            dice[idx][0] = b;
            dice[idx][1] = a;
            dice[idx][2] = c;
            dice[idx][3] = f;
            dice[idx][4] = e;
            dice[idx][5] = d;
        } else if (e == bottom) {
            dice[idx][0] = c;
            dice[idx][1] = a;
            dice[idx][2] = b;
            dice[idx][3] = f;
            dice[idx][4] = d;
            dice[idx][5] = e;
        } else if (b == bottom) {
            dice[idx][0] = d;
            dice[idx][1] = a;
            dice[idx][2] = e;
            dice[idx][3] = f;
            dice[idx][4] = c;
            dice[idx][5] = b;
        } else if (c == bottom) {
            dice[idx][0] = e;
            dice[idx][1] = a;
            dice[idx][2] = d;
            dice[idx][3] = f;
            dice[idx][4] = b;
            dice[idx][5] = c;
        } else {
            dice[idx][0] = f;
            dice[idx][1] = b;
            dice[idx][2] = e;
            dice[idx][3] = d;
            dice[idx][4] = c;
            dice[idx][5] = a;
        }
    }

    static int getMax(int[] row) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            list.add(row[i]);
        }
        return Collections.max(list);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dice = new int[n][6];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dice[i][0] = Integer.parseInt(st.nextToken());
            dice[i][1] = Integer.parseInt(st.nextToken());
            dice[i][2] = Integer.parseInt(st.nextToken());
            dice[i][3] = Integer.parseInt(st.nextToken());
            dice[i][4] = Integer.parseInt(st.nextToken());
            dice[i][5] = Integer.parseInt(st.nextToken());
        }

        int[][] clone = new int[n][];
        for (int i = 0; i < n; i++) {
            clone[i] = dice[i].clone();
        }

        int max = 0;
        int current = 0;

        for (int bottom = 1; bottom <= 6; bottom++) {
            fixBottom(bottom, 0, clone);
            for (int i = 1; i < n; i++) {
                int newBottom = clone[i - 1][0];
                fixBottom(newBottom, i, clone);
            }

            for (int[] row : clone) {
                if (bottom == 1) {
                    max += getMax(row);
                } else {
                    current += getMax(row);
                }

//                System.out.print(Arrays.toString(row));
//                System.out.println();
            }
//            System.out.println();
            if (current > max) {
                max = current;
            }
            current = 0;
        }

        System.out.println(max);

    }
}
