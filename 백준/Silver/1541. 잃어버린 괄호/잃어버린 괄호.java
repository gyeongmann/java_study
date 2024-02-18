import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String[] splitByMinus = s.split("-");
//        System.out.println(Arrays.toString(splitByMinus));

        int sum = 0;
        for (int i = 0; i < splitByMinus.length; i++) {
            int curSum = 0;
            String current = splitByMinus[i];
            String[] splitByPlus = current.split("\\+");

//            System.out.println(Arrays.toString(splitByPlus));

            for (int idx = 0; idx < splitByPlus.length; idx++) {
                curSum += Integer.parseInt(splitByPlus[idx]);
            }

            if (i == 0) {
                sum += curSum;
                continue;
            }

            sum -= curSum;
        }

        System.out.println(sum);
    }
}
