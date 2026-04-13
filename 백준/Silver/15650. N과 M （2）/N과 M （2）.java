import java.io.*;
import java.util.*;

public class Main {
    
    static int[] arr;
    static int N,M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M]; // M개의 선택한 값을 저장할 배열
        dfs(0,1);

    }
    
    static void dfs(int depth, int start){
        /* 종료 조건 */
        if(depth==M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        
        /* 반복 조건 */
        for(int next=start; next<=N; next++){
            arr[depth] = next;
            dfs(depth+1, next+1);
        }
    }
}