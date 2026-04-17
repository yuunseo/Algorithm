
class Solution {
    int solution(int[][] land) {
        
        // dp 배열 초기화
        int[][] dp = new int[land.length][land[0].length];
        
        // dp 1번행 초기화
        for(int i=0; i<4; i++){
            dp[0][i] = land[0][i];
        }
        
        // 다음 행 부터 선택
        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                int cur = land[i][j]; // 현재 위치의 값
                int maxVal = 0; // 갱신을 위한 최댓 값
                for(int k=0; k<4; k++){
                    if(j==k) continue; // 이전 열은 선택 불가
                    maxVal = Math.max(maxVal, cur + dp[i-1][k]);
                }
                dp[i][j] = maxVal;
            }
        }
        
        // 맨 마지막 열 중 최댓값 반환
        int answer = 0;
        for(int i=0; i<4; i++){
            answer = Math.max(answer, dp[land.length-1][i]);
        }

        return answer;
    }
    
    
}