import java.util.*;

public class N1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            if (list.contains(next)) {
                continue;
            }
            list.add(next);
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(), o2.length());
        });

        for (String str : list) {
            sb.append(str).append('\n');
        }

        System.out.print(sb);
    }
}
