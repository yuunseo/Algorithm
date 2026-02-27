import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[K];
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        long left = 1;
        long right = arr[K-1];
        long answer = 0;
        while(left <= right){
            int cnt = 0;
            long mid = (left+right)/2;
            
            for(int i=0; i<K; i++){
                cnt += arr[i]/mid;
            }
            
            if(cnt >= N){ // 너무 많이 잘랐으면, 범위를 크게 다시
                answer = mid;
                left = mid + 1;
            }else{        // 너무 적게 잘랐으면, 범위를 작게 다시
                right = mid-1;
            }
            
        }
        
        System.out.println(answer);
    }
}