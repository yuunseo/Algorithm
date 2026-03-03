/*
1. 정해진 총액 이하에서 가능한 최대 국가의 예산을 분배하자
2. 요청한대로 최대한 배정해주고, 불가능할 때는 상한액으로 배정하자. 그 이하는 그대로
3. 그럼 나는 최대 나누어줄 수 있는 각각의 예산의 금액을 찾아야 함 -> 탐색
4. 최소 예산, 최대 예산을 설정해서 범위를 나눠가면서 찾아보기 -> 이분탐색
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // input
        int N = Integer.parseInt(br.readLine()); // 국가의 개수
        int minVal = 1; // 최소 예산 금액
        int maxVal = 1;; // 최대 예산 금액
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 국가별 요청 금액
            maxVal = Math.max(maxVal, arr[i]);
        }
        int M = Integer.parseInt(br.readLine()); // 예산의 총합
        
        // 배정 가능한 최대 금액 찾기
        while(minVal <= maxVal){
            int mid = (minVal + maxVal)/2;
            int sum = 0;
            for(int i=0; i<N; i++){
                if(arr[i] < mid){
                    sum += arr[i];
                }else{
                    sum += mid;
                }
            }
            
            if(sum <= M){
                minVal = mid+1;
            }else{
                maxVal = mid-1;
            }
        }
        
        // 출력
        System.out.println(maxVal);
        
    }
}