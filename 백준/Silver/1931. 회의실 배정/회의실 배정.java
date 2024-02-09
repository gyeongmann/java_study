
import java.util.*;

public class Main {
    static class Schedule {
        int start, end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int ans = 0;
        int nextStart = 0;

        for (int i = 0; i < N; i++) {
            if (nextStart <= time[i][0]) {
                nextStart = time[i][1];
                ans++;
            }
        }

        System.out.println(ans);
        
    }
}
