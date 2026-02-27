import java.util.*;
import java.io.*; 

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // M개 중 3개 선택해서, N행에 걸쳐 최댓값구하기
        int answer = 0;
        for(int i=0; i<M-2; i++){
            for(int j=i+1; j<M-1; j++){
                for(int k=j+1; k<M; k++){
                    int num = 0;
                    for(int n=0; n<N; n++){
                        num += Math.max(arr[n][i], Math.max(arr[n][j], arr[n][k]));
                    }
                    answer = Math.max(answer, num);
                }
            }
        }
        
        System.out.println(answer);
    }
}