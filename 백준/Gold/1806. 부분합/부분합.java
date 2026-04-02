/*
0. 구하고자 하는 값
- N개의 수열 중, 부분합이 S이상이 되는 부분 중 가장 짧은 길이 구하기
1. 입력크기 확인
- N <100000, S<=100000000 -> 완전탐색 불가능
2. 아이디어
- 10개중의 부분합 만들기: 1~N개를 갖는 집합을 for문으로 돌아서, n개씩 일때 또 for문 (이중for문)
- dp? 이분탐색?
3. 
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 투포인터
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        boolean success = false;
        
        for(int right=0; right<N; right++){
            sum += arr[right];
            
            while(sum >= S){
                success = true;
                minLen = Math.min(minLen, right-left+1);
                sum -= arr[left++];
            }
        }
        
        if(success){
            System.out.println(minLen);
        }else{
            System.out.println(0);
        }
        
    }
}