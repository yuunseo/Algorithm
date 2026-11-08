import java.util.*;

class Solution {
    
    private static boolean[] hasNetwork;
    private int answer;
    
    public int solution(int n, int[][] computers) {
        
        // 1. 자료구조 초기화
        hasNetwork = new boolean[n+1]; 
        answer = 0;
        
        // 2. 0번 점부터 탐색
        for(int i=0; i<n; i++){
            if(hasNetwork[i]){ // 이미 네트워크에 포함됐으면, 건너뛰기
                continue;
            }
            
            answer++;
            bfs(i, computers, n);
        }
        
        return answer;
        
    }
    
    private void bfs(int current, int[][] computers, int len){
        
        // 탐색
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(current);
        hasNetwork[current] = true; // 새로운 네트워크의 출발점
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            // now와 연결된 애들 찾기
            for(int i=0; i<len; i++){
                if(i == now ||
                  computers[now][i] == 0||
                  hasNetwork[i]) continue;
                
                hasNetwork[i] = true;
                q.offer(i);
            }
        }
    }
}