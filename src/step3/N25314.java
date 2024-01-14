package step3;

import java.util.Scanner;

public class N25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        int count = (n - 4) / 4;
        for (int i = 0; i < count; i++) {
            sb.append("long ");
        }
        sb.append("long int");
        System.out.println(sb);
    }
}
