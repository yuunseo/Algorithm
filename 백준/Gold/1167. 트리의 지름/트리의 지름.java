import java.io.*;
import java.util.*;

public class Main {
    
    static class Node {
        int to, weight;
        
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static boolean[] visited;
    static int maxDist = 0;
    static int farNode = 0;
    static ArrayList<Node>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int V = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            
            while (true) {
                int v2 = Integer.parseInt(st.nextToken());
                if (v2 == -1) break;
                int dis = Integer.parseInt(st.nextToken());
                
                graph[v1].add(new Node(v2, dis));
            }
        }
        
        // 1차 DFS
        visited = new boolean[V + 1];
        dfs(1, 0);
        
        // 2차 DFS
        visited = new boolean[V + 1];
        maxDist = 0;
        dfs(farNode, 0);
        
        System.out.println(maxDist);
    }
    
    static void dfs(int cur, int dist) {
        visited[cur] = true;
        
        if (dist > maxDist) {
            maxDist = dist;
            farNode = cur;
        }
        
        for (Node next : graph[cur]) {
            if (!visited[next.to]) {
                dfs(next.to, dist + next.weight);
            }
        }
    }
}