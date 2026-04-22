/*
아이디어
1. 채우는 방법의 수를 구해야 하므로 : DFS 혹은 DP, 완전탐색
2. 가로의 길이만큼 새로만으로 채우기
3. 세로 -= 2 랑 가로 += 2로 치환 가능

*/
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = dp[1]+1;
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])% 1000000007 ;
        }
        
        return dp[n] ;
    }
}