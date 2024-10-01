import java.util.*;

class Solution {
	public int solution(int n, int[][] computers) {
		boolean[] visited = new boolean[n];
		Map<Integer, List<Integer>> adjMap = new HashMap<>();

		for (int i = 0 ; i < computers.length ; i++) {
			int[] computer = computers[i];
			adjMap.put(i, new ArrayList<>());

			for(int j = 0 ; j < computer.length ; j++) {
				if (computer[j] == 1) {
					adjMap.get(i).add(j);
				}
			}
		}

		final BfsExecutor executor = new BfsExecutor();

		int answer = 0;
		for (int i = 0 ; i < n ; i++) {
			if (visited[i]) {
				continue;
			}

			executor.bfs(i, adjMap, visited);
			answer++;
		}

		return answer;
	}
}

class BfsExecutor {

	public void bfs(int start, Map<Integer, List<Integer>> adjMap, boolean[] visited) {
		Queue<Integer>  q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;

		while(!q.isEmpty()) {
			int n = q.poll();

			List<Integer> adjList = adjMap.get(n);
			for (int adj : adjList) {
				if (visited[adj]) {
					continue;
				}

				visited[adj] = true;
				q.offer(adj);
			}
		}
	}
}
