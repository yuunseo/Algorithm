import java.util.*;
import java.io.*;

class Main{
    static ArrayList<int[]>[] tree;
    static boolean[] visited;
    static int answer =0;
    static int maxDist = 0;
    static int farNode = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        if(n==1){
            System.out.println(0);
            return;
        }

        // 우리가 저장해야 하는 값은 연결된 노드와 간선의 값
        tree = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1 ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree[a].add(new int[] {b,c});
            tree[b].add(new int[] {a,c}); //양방향 정보 저장
        }

        // 아무 노드에서 DFS : 최장 간선과 시작 노드 탐색용도
        visited = new boolean[n+1];
        dfs(1,0);

        // 시작 노드에서 DFS
        visited = new boolean[n+1];
        maxDist = 0;
        dfs(farNode,0);

        System.out.println(maxDist);
    }

    static void dfs(int node, int dist){
        visited[node] = true;

        if(dist > maxDist){
            maxDist = dist;
            farNode = node;
        }

        for(int[] next : tree[node]){

            int nextNode = next[0];
            int weight = next[1];

            if(!visited[nextNode]){
                dfs(nextNode, dist + weight);
            }
        }

    }
}