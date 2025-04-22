def solution(n):
    
    dp = [0 for i in range(n+1)]
    MOD = 1234567
    
    dp[0] = 0
    dp[1] = 1
    
    for i in range(2,n+1):
        dp[i] = ( dp[i-1] + dp[i-2] ) % MOD
    
    return dp[n] 