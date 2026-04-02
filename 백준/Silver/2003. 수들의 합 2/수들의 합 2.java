/*
1. 아이디어
- 부분합이 M이 되는 경우의 수 구하기
- 투포인터로 범위 증가하면서 구하기?
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        
        while(true){
            if(sum >= M){
                if(sum == M) count++;
                sum -= arr[left++];
            }else{
                if(right == N) break;
                sum += arr[right++];
            }
        }
        
        System.out.println(count);
    }
}