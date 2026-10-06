/*
idea: 네트워크의 개수를 찾는 문제
- 하나의 점에서 시작해서 연결된 컴퓨터들의 끝을 찾으면 하나의 네트워크
- 연결가능한 네트워크의 모든 점들을 확인하는 것이 목적이므로 BFS(너비우선)
- 또한 네트워크로 묶여있는지 아닌지 확인을 위한 배열 필요

sudo code:
- 1번 컴퓨터부터 확인하기(computers[0])
- computers[0][i]에 든 컴퓨터들 중, i!=0인 애들만 확인
- computers[0][i]에서 1인 컴퓨터가 있으면, 연결된 것임
- 연결되었으면 hasNetwork에 parnet를 채우기
- 다음 컴퓨터로 이동해서, 1인지 0인지 확인하기
- 1번 컴퓨터 끝났으면 2번 컴퓨터로 이동하기(computers[1])
- 이때 2번 컴퓨터가 이미 네트워크에 포함되었는지 확인 (hasNetwork)
- 이미 포함됐으면 탐색 안하고, 다음 컴퓨터로 이동하기
*/
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
            else{
                hasNetwork[i] = true; // 새로운 네트워크의 출발점
                answer++;
                bfs(i, computers, n);
            }
        }
        
        return answer;
        
    }
    
    private void bfs(
        int current, 
        int[][] computers,
        int len){
        
        // 탐색
        boolean[] isVisited = new boolean[len+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(current);
        isVisited[current] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            
            // now와 연결된 애들 찾기
            for(int i=0; i<len; i++){
                if(i == now ||
                  computers[now][i] == 0||
                  isVisited[i]) continue;
                
                isVisited[i] = true;
                hasNetwork[i] = true;
                q.offer(i);
            }
        }
    }
}