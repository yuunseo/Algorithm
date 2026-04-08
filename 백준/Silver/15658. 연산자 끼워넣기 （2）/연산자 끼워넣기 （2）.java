import java.io.*;
import java.util.*;

public class Main {
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;
    static int N;
    static int[] op;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 수

        A = new int[N]; // 수열 A
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4]; // 부등호 배열 + - * /
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, A[0]); 

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    static void dfs(int idx, int total){
        if(idx == N){ // 종료 조건
            maxVal = Math.max(maxVal, total);
            minVal = Math.min(minVal, total);
            return;
        }



        for(int i=0; i<4; i++){
            if(op[i] > 0){
                op[i]--;
                int next = 0;
                switch(i){
                    case 0:
                        next = total + A[idx]; break;
                    case 1:
                        next = total - A[idx]; break;
                    case 2:
                        next = total * A[idx]; break;
                    case 3:
                        next = total / A[idx]; break;
                }
                dfs(idx+1, next);
                op[i]++;
            }
        }

    }
}