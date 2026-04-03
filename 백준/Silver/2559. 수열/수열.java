import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수열의 길이
        int K = Integer.parseInt(st.nextToken()); // 부분 수열의 길이

        // 누적합 배열 dp 초기화
        int[] dp = new int[N+1];
        dp[0] = 0;
        
        // 누적합 배열 dp 완성
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
        }
        
        // 부분 수열의 합 갱신
        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<=N-K; i++){
            maxVal = Math.max(maxVal, dp[i+K] - dp[i]);
        }

        System.out.print(maxVal);
    }
}