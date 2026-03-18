class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int MOD = 1000000007;
                
        // 각 위치까지 접근 가능한 개수 배열
        int[][] dp = new int[n+1][m+1];
        
        // 물웅덩이 만들기
        for(int[] puddle: puddles){
            int x = puddle[0];
            int y = puddle[1];
            dp[y][x] = -1;
        }
        
        // 시작점에서부터 위 아래로 이동
        dp[1][1] = 1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                
                // 오른쪽, 아래만 갈 수 있으므로 두 경우만 더해줌
                if(j>1) dp[i][j] += dp[i][j-1];
                if(i>1) dp[i][j] += dp[i-1][j];
                
                dp[i][j] %= MOD;
                
                
            }
        }
        
        
        return dp[n][m];
    }
   
}