/*
컴퓨터의 개수 n 연결 정보 [][] -> 네트워크의 개수를 반환하자
1. 하나의 컴퓨터와 연결된 다른 컴퓨터로 이동 -> visited true

*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 자료구조 초기화
        boolean[] visited = new boolean[n];
        int idx = 0;
        while(idx<n){
            
            // 방문했던 컴퓨터는 패스
            if(visited[idx]){
                idx++; continue;
            }
            
            // 방문하지 않았던 컴퓨터의 네트워크 검색
            Queue<Integer> q = new LinkedList<>();
            q.add(idx);
            visited[idx] = true;
            
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int j=0; j<n; j++){
                    if(cur == j) continue;
                    if(computers[cur][j] == 1 && !visited[j]){
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
            
            // 하나의 연결된 네트워크가 종료되면, 카운트하고 다음 네트워크 찾아서 이동
            answer++;
            idx++;
            
        }
        
        
        
        return answer;
    }
}