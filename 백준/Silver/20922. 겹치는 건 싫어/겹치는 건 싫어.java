import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 로직 작성
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int maxLen = 0;
        int[] cnt = new int[100001];
        for(int right=0; right<N; right++){
            cnt[arr[right]]++;
            
            // K 초과하면 left 이동
            while(cnt[arr[right]] > K){
                cnt[arr[left]]--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right -left +1);
        }
        
        System.out.println(maxLen);

        
    }
}