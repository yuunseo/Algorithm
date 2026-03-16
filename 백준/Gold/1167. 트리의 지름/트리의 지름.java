import java.io.*;
import java.util.*;

public class Main {

    // 인접 리스트 (노드 -> [연결노드, 거리])
    static ArrayList<int[]>[] graph;

    static boolean[] visited;

    // 가장 먼 노드 번호
    static int farNode = 0;

    // 최대 거리
    static int maxDist = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 입력 처리
        for (int i = 0; i < V; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());

            while (true) {

                int next = Integer.parseInt(st.nextToken());

                // -1이면 끝
                if (next == -1) break;

                int dist = Integer.parseInt(st.nextToken());

                graph[node].add(new int[]{next, dist});
            }
        }

        // 1. 임의의 노드(1)에서 DFS → 가장 먼 노드 찾기
        visited = new boolean[V + 1];
        dfs(1, 0);

        // 2. 찾은 노드에서 다시 DFS → 지름 계산
        visited = new boolean[V + 1];
        maxDist = 0;
        dfs(farNode, 0);

        // 결과 출력
        System.out.println(maxDist);
    }

    // DFS (현재 노드, 현재까지 거리)
    static void dfs(int node, int dist) {

        visited[node] = true;

        // 최대 거리 갱신
        if (dist > maxDist) {
            maxDist = dist;
            farNode = node;
        }

        // 연결된 노드 탐색
        for (int[] next : graph[node]) {

            int nextNode = next[0];
            int weight = next[1];

            if (!visited[nextNode]) {
                dfs(nextNode, dist + weight);
            }
        }
    }
}