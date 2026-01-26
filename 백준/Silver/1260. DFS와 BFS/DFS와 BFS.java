/*
DFS: 깊이우선탐색 
- stack
BFS: 너비우선탐색
- queue

정점은 작은 순서대로
*/
import java.io.*;
import java.util.*;

class Main {
    
    static List<List<Integer>> graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int v){
        visited[v] = true;
        sb.append(v).append(" ");
        
        for(int next: graph.get(v)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
    
    static void bfs(Queue<Integer> q, int v){
        q.offer(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        // map
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        
        // 자료구조
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        // map 만들기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // 작은 번호부터 방문
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        
        // DFS 수행하기
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println(sb.toString().trim());
        
        // BFS 수행하기
        visited = new boolean[N+1];
        sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        bfs(q, V);
        System.out.println(sb.toString().trim());
        
        
    }
}