package Bruteforce;

import java.util.*;

public class N3961 {
    static String[][] keyboard = {
            {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"},
            {"a", "s", "d", "f", "g", "h", "j", "k", "l"},
            {"z", "x", "c", "v", "b", "n", "m"}
    };

    static int[] searchIdx(String s) {
        int[] idx = new int[2];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < keyboard[r].length; c++) {
                if (keyboard[r][c].equals(s)) {
                    idx[0] = r;
                    idx[1] = c;
                    return idx;
                }
            }
        }

        return null;
    }

    static int calculateDistance(char ch1, char ch2) {
        if (ch1 == ch2) {
            return 0;
        }

        // char -> String
        String s1 = String.valueOf(ch1);
        String s2 = String.valueOf(ch2);

        int[] idx1 = searchIdx(s1);
        int[] idx2 = searchIdx(s2);

        int distance = 0;
        distance += Math.abs(idx1[0] - idx2[0]);
        distance += Math.abs(idx1[1] - idx2[1]);

        return distance;
    }

    static int distanceOfWord(String word1, String word2) {
        int distance = 0;
        for (int i = 0; i < word1.length(); i++) {
            distance += calculateDistance(word1.charAt(i), word2.charAt(i));
        }
        return distance;
    }

    static class Pair {
        String word;
        int distance;

        Pair(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return word + " " + distance;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(searchIdx("c")));
//        System.out.println(Arrays.toString(searchIdx("f")));
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String word;
        int N;
        String[] words;

        for (int i = 0; i < T; i++) {
            List<Pair> list = new ArrayList<>();
            word = sc.next();
            N = sc.nextInt();

            for (int j = 0; j < N; j++) {
                String next = sc.next();

                Pair pair = new Pair(next, distanceOfWord(word, next));
                list.add(pair);
            }

            Collections.sort(list, (o1, o2) -> {
                if (o1.distance == o2.distance) {
                    return o1.word.compareTo(o2.word);
                }
                return Integer.compare(o1.distance, o2.distance);
            });

            for (Pair pair : list) {
                sb.append(pair).append('\n');
            }
        }
        System.out.print(sb);
    }
}
