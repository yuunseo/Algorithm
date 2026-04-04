import java.util.*;

class Solution {
    static ArrayList<Integer> [] arr;
    static int maxVal = 0;
    static boolean[] visited;
    static int[] count;
    
    public int solution(int n, int[][] edge) {
        
        // input
        int edge_count = edge.length;
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        
        // 노드의 간선 배열
        for(int[] vertex: edge){ 
            int a = vertex[0];
            int b = vertex[1];
            
            arr[a].add(b);
            arr[b].add(a);
        }
        
        // 각 노드까지의 간선의 개수 저장 배열
        count = new int[n+1];
        
        // 최단거리 bfs
        visited = new boolean[n+1];
        visited[1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int node = cur[0];
            int total = cur[1];
            count[node] = total;
            
            for(int next: arr[cur[0]]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new int[] {next, total+1});
                }
            }
            
        }
        
        for(int num: count){
            maxVal = Math.max(maxVal, num);
        }
        
        int answer = 0;
        for(int num: count){
            if(num == maxVal){
                answer++;
            }
        }
        
        return answer;  
        
    }
}
