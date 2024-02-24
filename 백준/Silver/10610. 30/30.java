import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        char[] toCharArray = N.toCharArray();
        Arrays.sort(toCharArray);

        int l = toCharArray.length;

        if (toCharArray[0] - '0' != 0) {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum += toCharArray[i] - '0';
        }

        if (sum % 3 == 0) {
            for (int i = 0; i < l; i++) {
                System.out.print(toCharArray[l - 1 - i]);
            }
            return;
        }
        System.out.println(-1);
        
    }
}
