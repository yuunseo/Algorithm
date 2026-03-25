import java.util.*;

class Solution {
    static int minLen;
    static List<Integer>[] arr;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            int a = road[0];
            int b = road[1];
            
            arr[a].add(b);
            arr[b].add(a);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n+1];
        for(int i=1; i<dist.length; i++){ // 거리 배열 초기화
            dist[i] = -1;
        }
        
        q.add(destination);
        dist[destination] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next: arr[cur]){
                if(dist[next] == -1){ 
                    dist[next] = dist[cur] +1;
                    q.add(next);
                }
            }
        }
        for(int i=0; i<sources.length; i++){
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
    
    
}