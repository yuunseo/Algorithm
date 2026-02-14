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
        
        if(N < 2){
            System.out.println(N);
            return;
        }
        
        long prev2 = 0;
        long prev1 = 1;
        long current = 0;
        
        for(int i=2; i<=N; i++){
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        System.out.println(current);
        
    }
}