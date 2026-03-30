class Solution {
    public int solution(int n, int[] money) {
    
        int answer = 0;
        
        // dp 배열 생성: 0원부터 n원까지 만들 수 있는 경우의 개수를 저장할 용도
        int[] dp = new int[n+1];
        dp[0] = 1; // 0원을 만들 수 있는 경우의 수 1개
        
        // 가진 코인으로 가능한 수를 구해야 하므로, coin으로 반복
        for(int coin: money){
            for(int i=coin; i<=n; i++){
                dp[i] = (dp[i] + dp[i-coin])%1000000007;
            }
        }
        
        
        return dp[n];
    }
    
    
}