import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 동전의 종류
        int K = sc.nextInt(); // 목표 가치

        int[] coins = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            coins[i] = sc.nextInt();
        }

        int count = 0;

        for (int coin : coins) {
            int quotient = K / coin;

            if (quotient > 0) {
                K -= coin * quotient;
                count += quotient;
            }
        }

        System.out.println(count);
    }
}
