import java.io.*;
import java.util.*;

public class Main {

    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;
    static int N;
    static int[] A;
    static int[] op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 숫자 배열 초기화
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 부등호 배열 초기화
        op = new int[4]; // + - * / 순서대로
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        // DFS로 모든 경우를 구한 후, 최대/최소 갱신하기
        dfs(1, A[0]); // 시작


        // 출력
        System.out.println(maxVal);
        System.out.println(minVal);
    }

    static void dfs(int index, int cur){
        if(index == N){
            maxVal = Math.max(maxVal, cur);
            minVal = Math.min(minVal, cur);
            return;
        }

        for(int i=0; i<4; i++){
            if(op[i] > 0){
                op[i]--;

                int next = 0;

                if(i == 0) next = cur + A[index];
                else if(i == 1) next = cur - A[index];
                else if(i == 2) next = cur * A[index];
                else next = cur / A[index];

                dfs(index + 1, next);

                op[i]++; // 복구
            }
        }
    }
}