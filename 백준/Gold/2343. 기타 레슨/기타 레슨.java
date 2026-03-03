/*
1. 순서를 유지하면서 N개의 강의를 하나로 묶자
2. 구간의 합 중 최댓값을 구해놓고 그들 중 최소가 되는 걸 출력하자.
3. 최소, 최대 구해놓고 시작
4. mid보다 작은 최대가 될 때 구간을 나누고, 이때 구간이 M개 초과하면 다시 mid 계산
5. 최대가 되면서 M개가 되는 값을 출력하면 된다
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int minVal = 0;
        int maxVal = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            maxVal += arr[i];
            minVal = Math.max(minVal, arr[i]);
        }
        
        // logic
        int answer = maxVal;
        while(minVal <= maxVal){
            int count = 1;
            int mid = (minVal + maxVal)/2;
            int sum = 0;
            for(int i=0; i<N; i++){
                if(sum + arr[i] > mid){
                    count++;
                    sum = arr[i];
                }else{
                    sum += arr[i];
                }
            }
            
            if(count <= M){
                answer = mid;
                maxVal = mid-1;
            }else{
                minVal = mid+1;
            }
        }
        
        // output
        System.out.println(answer);
    }
}