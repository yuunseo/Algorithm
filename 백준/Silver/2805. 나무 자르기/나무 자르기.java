import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 나무의 길이
        int[] arr = new int[N];
        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(arr[i],right);
        }
        
        
        int H = 0;
        while(left <= right){
            int mid = (left+right)/2;
            long sum = 0;
            for(int num : arr){
                if(num > mid){
                    sum += (num - mid);
                }
            }
            
            if(sum >= M){ 
                H = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }

        System.out.print(H);
    }
}