import java.util.*;

class Solution {
    public int solution(int sticker[]) {

        int len = sticker.length;
        
        if(len==1) return sticker[0];
        
        // 1. 첫 번째 뽑는 경우
        int[] dp = new int[len];
        dp[0] = sticker[0]; // 1개인 경우 최대로 뽑는 수
        dp[1] = Math.max(dp[0], sticker[1]); // 2개인 경우 최대로 뽑는 수
        
        for(int i=2; i<len; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]); 
                            // 이전 값 뽑는 경우 vs 현재 값 뽑는 경우
        }
        
        // 2. 첫 번째 안 뽑는 경우
        int[] dp2 = new int[len];
        dp2[1] = sticker[1];
        for(int i=2; i<len; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+sticker[i]);
        }
        
        // 결과
        // 첫 번째 뽑으면 마지막 거 불가능
        // 첫 번째 안 뽑으면 마지막 거가 최대
        return Math.max(dp[len-2], dp2[len-1]); 
        
        
    }
}