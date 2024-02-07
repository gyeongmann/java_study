import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean visited[];
	static int adj_matrix[][];
	static int count;

	static void BFS(int i) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(i);
		visited[i] = true;
				
		while(!q.isEmpty()) {
			int cur = q.poll();
			
//			System.out.print(cur + " ");
//			System.out.println(q.toString());
			
			for (int idx = 1; idx < adj_matrix.length; idx++) {
				if(visited[idx]) continue;
				if (adj_matrix[cur][idx] == 1) {
					q.add(idx);
					visited[idx] = true;
					count++;
//					System.out.println("visit");
				}
			}
			
			
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int computers = sc.nextInt();
		adj_matrix = new int[computers+1][computers+1]; // 인접 행렬

		visited = new boolean[computers + 1];
		int e = sc.nextInt(); // edge 수
		for (int i = 0; i < e; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj_matrix[u][v] = 1;
			adj_matrix[v][u] = 1;
		}
		
//		for (int[] row : adj_matrix) {
//			System.out.println(Arrays.toString(row));
//		}
		
		
		BFS(1);
		System.out.println(count);
//		System.out.println(Arrays.toString(visited));
	}
}