package step3;

import java.util.Scanner;

public class N25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt() * sc.nextInt();
        }

        if (x == sum) System.out.println("Yes");
        else System.out.println("No");
    }
}
