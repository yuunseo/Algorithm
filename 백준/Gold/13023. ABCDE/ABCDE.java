/*
정점을 5개 이상으로 하는 네트워크가 존재하는지 찾기 
dfs
*/
import java.io.*;
import java.util.*;

class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;

            if(found) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    static void dfs(int current, int depth) {
        if(depth == 4) {
            found = true;
            return;
        }

        for(int next : graph[current]) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;

                if(found) return;
            }
        }
    }
}
