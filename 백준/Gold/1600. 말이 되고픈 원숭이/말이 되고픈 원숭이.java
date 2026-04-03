import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x, y, k, dist;

        Node(int x, int y, int k, int dist) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.dist = dist;
        }
    }

    // 원숭이 이동 (4방향)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 말 이동 (8방향)
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // visited[x][y][k]
        boolean[][][] visited = new boolean[H][W][K + 1];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 도착
            if (cur.x == H - 1 && cur.y == W - 1) {
                System.out.println(cur.dist);
                return;
            }

            // 1. 원숭이 이동
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (map[nx][ny] == 1 || visited[nx][ny][cur.k]) continue;

                visited[nx][ny][cur.k] = true;
                q.add(new Node(nx, ny, cur.k, cur.dist + 1));
            }

            // 2. 말 이동 (K번 이하일 때만)
            if (cur.k < K) {
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + hx[d];
                    int ny = cur.y + hy[d];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (map[nx][ny] == 1 || visited[nx][ny][cur.k + 1]) continue;

                    visited[nx][ny][cur.k + 1] = true;
                    q.add(new Node(nx, ny, cur.k + 1, cur.dist + 1));
                }
            }
        }

        // 도달 못한 경우
        System.out.println(-1);
    }
}