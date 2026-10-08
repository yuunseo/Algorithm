/*
idea: 물에 잠기지 않은 길로 최단 경로 탐색
- 최단 경로는 BFS로 구할 수 있음.
- but 우리가 원하는 건 최단 경로의 개수임!!!!!
- 그럼 모든 경우의 수를 구해본 다음에 최소인 경로가 몇개인지 파악해야 한다는 말이군..
- DFS로 갈 수 있는 경로를 가는데, 출발할 때 BFS 탐색으로 최단 거리로 가기
- 그럼 계속 반복적으로 구하는 값이 생김. 이러한 반복 계산을 줄이고자 dp 배열 활용
*/
import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 자료구조 초기화
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = 1; // 지나갈 수 있는 길 표시(1)
            }
        }
        
        for(int[] puddle: puddles){
            map[puddle[1]-1][puddle[0]-1] = 0; // 물 웅덩이는 지나갈 수 없음(0)
        }
        
        int[][] dp = new int[n][m];
        dp[0][0] = 1; // 시작점
        
        for(int i=0; i<n ;i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0) continue; // 시작점 무시
                if(map[i][j] == 0) continue; // 물웅덩이 무시
                
                if(i==0){ // 맨 윗 줄은 왼쪽에서 오는 것만 유효
                    dp[i][j] = dp[i][j-1];
                }else if(j==0){ // 맨 왼쪽 줄은 위에서 오는 것만 유효
                    dp[i][j] = dp[i-1][j];
                }else{ // 중간에서는 왼쪽-위에서 오는 것 둘다 유효
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j])% 1000000007;
                }
            }
        }
        
        // 결과 반환
        return dp[n-1][m-1];
    }
   
}