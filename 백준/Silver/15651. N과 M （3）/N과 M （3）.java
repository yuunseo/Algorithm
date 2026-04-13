import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        /* 총 M개의 수를 저장할 자료구조 */
        arr = new int[M];
        
        /* DFS로 모든 조합의 수 구하기 */
        dfs(0);
        
        System.out.println(sb);
    }
    
    static void dfs(int count){
        /* 종료 조건 */
        if(count==M){
            for(int i=0; i<count; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        /* 반복 조건 */
        for(int i=1; i<=N; i++){
            arr[count] = i;
            dfs(count+1);
        }
    }
}