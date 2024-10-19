import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] arr;
	static int max = 0;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int[] input = sToIArr(br.readLine());
		N = input[0];
		M = input[1];
		arr = new ArrayList[N + 1];
		result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			final int[] link = sToIArr(br.readLine());
			arr[link[0]].add(link[1]);
		}

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}

		for (int i = 1; i <= N; i++) {
			max = Math.max(result[i], max);
		}

		for (int i = 1; i <= N; i++) {
			if (result[i] == max)
				bw.write(i + " ");
		}
		bw.flush();
		bw.close();
	}

	static void bfs(int root) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();

		q.offer(root);
		visited[root] = true;
		result[root]++;

		while (!q.isEmpty()) {
			int r = q.poll();

			for (int k : arr[r]) {
				if (!visited[k]) {
					q.offer(k);
					visited[k] = true;
					result[k]++;
				}
			}
		}
	}

	private static int[] sToIArr(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}
