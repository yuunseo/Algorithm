import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;

    static int[] dx = {-1, 0, 0, 1}; // 위, 왼, 오른, 아래
    static int[] dy = {0, -1, 1, 0};

    static class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int sharkX, sharkY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 입력 + 상어 위치 찾기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0; // 상어 자리 초기화
                }
            }
        }

        // 반복 BFS
        while (true) {
            Node fish = bfs();

            // 먹을 물고기 없으면 종료
            if (fish == null) break;

            // 이동
            sharkX = fish.x;
            sharkY = fish.y;
            time += fish.dist;

            // 물고기 먹기
            map[sharkX][sharkY] = 0;
            eatCount++;

            // 크기 증가 체크
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    static Node bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;

        List<Node> candidates = new ArrayList<>();

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                // 상어보다 큰 물고기 → 못 감
                if (map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, cur.dist + 1));

                // 먹을 수 있는 물고기
                if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                    candidates.add(new Node(nx, ny, cur.dist + 1));
                }
            }
        }

        // 먹을 수 있는 물고기 없음
        if (candidates.isEmpty()) return null;

        // 정렬: 거리 → 위 → 왼쪽
        Collections.sort(candidates, (a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        return candidates.get(0);
    }
}