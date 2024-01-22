package AlgorithmStudy;

import java.util.Arrays;
import java.util.Scanner;

public class N2304 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] heights = new int[20];

        int max_idx = 0;
        int max_height = 0;
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            int h = sc.nextInt();
            if (max_height < h) {
                max_idx = idx;
                max_height = h;
            }

            heights[idx] = h;
        }

//        System.out.println(Arrays.toString(heights));
//        System.out.println(max_idx + " " + max_height);

        int left = heights[0];
        for (int i = 1; i < max_idx; i++) {
            if (left < heights[i]) {
                left = heights[i];
            } else {
                heights[i] = left;
            }
        }

        int right = heights[heights.length - 1];
        for (int i = heights.length - 2; i > max_idx; i--) {
            if (right < heights[i]) {
                right = heights[i];
            } else {
                heights[i] = right;
            }
        }

//        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.stream(heights).sum());




    }
}