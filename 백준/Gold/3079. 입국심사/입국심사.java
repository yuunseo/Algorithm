import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        long minVal = Integer.MAX_VALUE;
        long maxVal = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            minVal = Math.min(minVal, arr[i]);
            maxVal = Math.max(maxVal, arr[i]);
        }
        
        maxVal = maxVal * M;
                
        long answer = 0;
        while(minVal <= maxVal){
            long mid = (minVal + maxVal)/2 ;
            long sum = 0;
            for(int i=0; i<N; i++){
                sum += (mid/arr[i]);
                if(sum >= M) break;
            }
            
            if(sum >= M){
                maxVal = mid-1;
                answer = mid;
            }else{
                minVal = mid+1;
            }
        }
        
        System.out.println(answer);
        
    }
}