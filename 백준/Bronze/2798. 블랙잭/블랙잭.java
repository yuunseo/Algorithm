/*
양의 정수, N장, 중에 3개 선택, M을 넘지 않으면서 M과 젤 가깝게 
M 이하 최댓값 sum을 구해라
- 3개 조합 중 M이하 & 최댓값 반환하기
*/
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] int_array = new int[N];
        for(int i=0; i<N; i++){
            int_array[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        int temp = 0;
        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    temp = int_array[i] + int_array[j] + int_array[k];
                    if(max<temp && temp<=M){
                        max = temp;
                    }
                }
            }
        }
        
        System.out.println(max);
        
        
    }
}