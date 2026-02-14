/*
n번째 피보나치의 수열을 구하자
1. i-2, i-1 = i
2. 1,2 번째 값을 저장해두고 갱신한다!
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        if(N == 0){
            System.out.println(0);
            return;
        }
        
        int[] arr = new int[N+1]; // 0~N
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i=2; i<=N; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        
        System.out.println(arr[N]);
        
    }
}