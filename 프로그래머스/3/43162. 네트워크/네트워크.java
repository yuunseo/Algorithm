import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int result = 0; // 네트워크 개수
        boolean[] visited = new boolean[n]; // 사이클 금지를 위한 방문 배열
        
        int[] network = new int[n]; // 컴퓨터 별 네트워크 표시를 위한 배열
        
        // 네트워크 검색
        for(int i=0; i<n; i++){
            if(visited[i]) continue; // 방문했던 컴퓨터면 제외
            
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            result ++; 
            visited[i] = true;
            
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int j=0; j<n; j++){
                    if(j!=cur && computers[cur][j] == 1 && !visited[j]){
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        
        return result;
        
    }
}