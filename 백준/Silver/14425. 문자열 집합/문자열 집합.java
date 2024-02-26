import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            map.put(sc.next(), 0);
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            String key = sc.next();
            if (map.containsKey(key)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}
