import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];

        q.offer(new int[]{x, 0});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int cnt = cur[1];

            if (now == y) return cnt;

            int[] next = new int[]{now + n, now * 2, now * 3};

            for (int nx : next) {
                if (nx <= y && !visited[nx]) {
                    visited[nx] = true;
                    q.offer(new int[]{nx, cnt + 1});
                }
            }
        }

        return -1;
    }
}