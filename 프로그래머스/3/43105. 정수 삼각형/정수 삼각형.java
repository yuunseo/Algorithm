/*
idea: 꼭대기에서부터 내려오면서 숫자들의 합을 계산하기
- DFS를 통해 모든 경우의 수를 돌아돌 수 있음
- 하지만, 아래로 내려갈 수록 위층에서 계산했던 값을 반복해서 계산함
- 아래로 한 칸씩 내려가면서, 최댓값만 저장하기 (좌우로만 가능하니까)
*/
import java.util.*;

class Solution {

    public int solution(int[][] triangle) {
        
        // 자료구조 초기화
        int depth = triangle.length;
        int[][] dp = new int[depth][depth];
        
        // 시작점
        dp[0][0] = triangle[0][0];
        
        // 숫자의 합 & 최댓값만 저장하는 로직
        for(int i=1; i<depth; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j==0){
                    // 왼쪽 가장자리는 triangle[i-1][j] 만 더해질 수 있음
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }else if(j==triangle[i].length-1){
                    // 오른쪽 가장자리는 triangle[i-1][j-1] 만 더해질 수 있음
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }else{
                    // 중간 자리는 [i-1][j-1], [i-1][j] 두 개를 더할 수 있음
                    dp[i][j] = Math.max(
                        triangle[i][j] + dp[i-1][j-1],
                        triangle[i][j] + dp[i-1][j]
                    );
                }
            }
        }
        
        // 맨 아래줄까지 온, 애들 중 최댓값 구하기
        int max=0;
        for(int num: dp[depth-1]){
            max = Math.max(max, num);
        }
        
        // 결과 반환
        return max;
        
    }
}