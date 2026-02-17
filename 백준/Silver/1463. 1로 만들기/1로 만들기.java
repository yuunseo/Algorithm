/*
N에서부터 나누려고 하면 너무 많은 메모리 필요
그래서 차라리 1에서부터 늘려가자
+1 하고 cnt++
*2 하고 cnt++
*3 하고 cnt++

그러다가 N이 되면, cnt 모으기
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N+1];
        dp[1] = 0;
        
        for(int i=2; i<=N; i++){ // i는 n을 1부터 올려가면서 최소의 연산 횟수로 갱신하게 함
            dp[i] = dp[i-1] + 1;
            
            if(i%2==0){
                dp[i] = Math.min(dp[i], dp[i/2]+1); // +1을 하는 이유는 i/2를 하는데 드는 비용이기 때문임
            }
            
            if(i%3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }
        
        // 결과 출력 
        System.out.println(dp[N]);
        
    }
}