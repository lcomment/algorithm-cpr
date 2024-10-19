import java.util.*;

class Solution {

	private int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

	public int solution(String[] board) {
		final int R = board.length;
		final int C = board[0].length();
		final Node start = findNode(board, 'R');
		final Node end = findNode(board, 'G');

		final Queue<Node> q = new LinkedList<>();
		final int[][] distances = new int[R][C];

		for (int[] d : distances) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}

		q.offer(start);
		distances[start.getR()][start.getC()] = 0;

		while (!q.isEmpty()) {
			final Node n = q.poll();

			if (n.equals(end)) {
				return distances[end.getR()][end.getC()];
			}

			for (int[] dir : directions) {
				final int dr = dir[0];
				final int dc = dir[1];

				int nr = n.getR();
				int nc = n.getC();

				do {
					nr += dr;
					nc += dc;
				} while (in(nr, nc, R, C) && board[nr].charAt(nc) != 'D');

				nr -= dr;
				nc -= dc;

				int depth = distances[n.getR()][n.getC()] + 1;
				if (distances[nr][nc] > depth) {
					distances[nr][nc] = depth;
					q.offer(new Node(nr, nc));
				}
			}
		}

		return -1;
	}

	private Node findNode(String[] board, char c) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length(); j++) {
				if (board[i].charAt(j) == c) {
					return new Node(i, j);
				}
			}
		}

		throw new RuntimeException();
	}

	private boolean in(int r, int c, int R, int C) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}

class Node {

	private int r;
	private int c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}

	public boolean equals(Node n) {
		return this.r == n.getR() && this.c == n.getC();
	}
}
