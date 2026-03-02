import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        
        // 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 기본 배열 초기화
        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 누적합 배열 초기화
        int[][] prefix = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                prefix[i][j] = arr[i][j] + prefix[i][j-1] + prefix[i-1][j] - prefix[i-1][j-1];
            }
        }
        
        // M개의 구하고자하는 영역 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int sum = prefix[x2][y2] 
                - prefix[x2][y1-1]
                - prefix[x1-1][y2]
                + prefix[x1-1][y1-1];
            
            answer.append(sum).append("\n");
        }
        
        // 출력
        System.out.println(answer);
    }
}