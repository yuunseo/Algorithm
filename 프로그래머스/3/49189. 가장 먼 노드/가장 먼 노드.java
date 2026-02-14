/*
1번노드에서 출발했을 때, 거리배열을 갱신하고
가장 긴 거리를 갱신하며 출력하기
*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++){
            int s = edge[i][0];
            int e = edge[i][1];
            
            graph[s].add(e);
            graph[e].add(s);
        }
        
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
        
        int max = 0;
        for(int i=1; i<=n; i++){
            max = Math.max(max, dist[i]);
        }
        
        int count = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == max){
                count++;
            }
        }
        
        return count;
    }
}
