import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 유치원생 N, 조 개수 K
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 유치원생 키 순서대로 모음 
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] diff = new int[N-1];
        for(int i=0; i<N-1; i++){
            diff[i] = arr[i+1] - arr[i];
        }
        
        Arrays.sort(diff);
        
        int sum = 0;
        for(int i=0;i<N-K;i++){
            sum += diff[i];
        }

        System.out.println(sum);
        
        
    }
}