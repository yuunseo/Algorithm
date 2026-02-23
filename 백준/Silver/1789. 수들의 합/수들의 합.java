/*
서로 다른 n개의 숫자의 합이 200이고, 개수가 최대가 되려면
가장 작은 수에서부터 시작해서 200이 될 때 멈추기
1. 1부터 시작
2. S되면 멈추기 -> 그런데 연속된 수의 합이 S가 되지 않을 수도 있잖아?
---
1. 1부터 시작하되
2. 1~N까지의 합 공식 이용해서 해당 값이 S이상이 될때 찾기
    - N(N+1)/2
3. 
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long S = Long.parseLong(br.readLine());
        
        long left = 1;
        long right = S;
        long answer = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = mid * (mid+1) / 2;
            
            if(sum <= S){
                answer = mid;
                left = mid+1; //더 큰 N 탐색을 위해 이동
            }else{
                right = mid-1; // 범위 줄이기
            }
        }
        
        System.out.println(answer);
        
    }
}