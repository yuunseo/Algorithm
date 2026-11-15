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