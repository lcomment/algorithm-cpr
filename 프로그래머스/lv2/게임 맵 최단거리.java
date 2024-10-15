import java.util.*;

class Solution {

    private int[][] d = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public int solution(int[][] maps) {
        final int N = maps.length;
        final int M = maps[0].length;
        final Queue<Node> q = new LinkedList<>();
        final int[][] distances = new int[N][M];

        for (int i=0 ; i<N; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        q.offer(new Node(0, 0, 1));
        distances[0][0] = 1;

        while (!q.isEmpty()) {
            Node n = q.poll();

            if (n.getR() == N - 1 && n.getC() == M - 1) {
                break;
            }

            for (int i=0 ; i<4 ; i++) {
                int nr = n.getR() + d[i][0];
                int nc = n.getC() + d[i][1];

                if (!in(nr, nc, N, M)) {
                    continue;
                }

                if (maps[nr][nc] == 0) {
                    continue;
                }

                if (n.getD() + 1 >= distances[nr][nc]) {
                    continue;
                }

                distances[nr][nc] = n.getD() + 1;
                q.offer(new Node(nr, nc, n.getD() + 1));
            }
        }

        return distances[N-1][M-1] == Integer.MAX_VALUE ? -1 : distances[N-1][M-1];
    }

    public boolean in(int r, int c, int N, int M) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}

class Node {

    private int r;
    private int c;
    private int d;

    public Node(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }
}