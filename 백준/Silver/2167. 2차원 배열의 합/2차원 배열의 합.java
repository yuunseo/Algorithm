import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 누적합 
        int[][] prefix = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                prefix[i][j] = arr[i][j] + prefix[i][j-1] + prefix[i-1][j] - prefix[i-1][j-1];
            }
        }
        
        int a,b;
        int x,y;
        
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            
            int sum = prefix[x][y] - prefix[a-1][y] - prefix[x][b-1] + prefix[a-1][b-1];
            sb.append(sum).append("\n");
        }
        
        System.out.println(sb);
       
        
    }
}