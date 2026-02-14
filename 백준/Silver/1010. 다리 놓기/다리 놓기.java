/*
N개의 다리를 지을 수 있는 모든 경우의 수 구하기
1-1인 경우, 2-2,3,4,5,6, ..
조합의 수를 구하는 거 맞음 MCN = M! /( N! *(M-N)!)

DP 사고가 필요함
- N개 중 1개를 M번째를 선택했으면 M-1개 중 N-1개 고르면 됨
- N개 중 1개를 M번째로 선택하지 않았으면 M-1개 중 N개 고르면 됨
이 두 경우의 수를 더한 값이 모든 경우의 수다!


*/
import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp = new long[31][31];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 이전 계산 값을 저장해 둘 자료구조 DP 배열 초기화
        for(int i = 0; i <= 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            for(int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            sb.append(dp[M][N]).append("\n");
        }

        System.out.print(sb.toString());
    }

}
