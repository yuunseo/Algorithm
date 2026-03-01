import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 구간별 합을 구해야 하므로, 매번 구간별로 더하는 것 대신
        // 구간별 합을 미리 만들어두기
        int[] prefix = new int[N];
        prefix[0] = arr[0];
        // prefix[i]란, 0~i번째 원소까지 더한 합계
        for(int i=1; i<N; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            if(s <= 1){
                sb.append(prefix[e-1]).append("\n");
            }else{
                sb.append(prefix[e-1] - prefix[s-2]).append("\n");
            }
        }
        
        
        System.out.println(sb);
    }
}