import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] honey = new int[N];
        for(int i=0; i<N; i++){
            honey[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합
        long[] prefix = new long[N];
        prefix[0] = honey[0];
        for(int i=1; i<N; i++){
            prefix[i] = prefix[i-1] + honey[i];
        }
        long total = prefix[N-1];
        long answer =0 ;

        // 1) 벌-벌-벌통
        for(int i=1; i<N-1; i++){
            long sum=(prefix[N-1]-honey[0]-honey[i])+(prefix[N-1]-prefix[i]);
            answer = Math.max(answer, sum);
        }

        // 2) 벌통-벌-벌
        for(int i=1; i<N-1; i++){
            long sum=(prefix[N-2]-honey[i])+(prefix[i-1]);
            answer = Math.max(answer, sum);
        }

        // 3) 벌-벌통-벌
        for(int i = 1; i < N-1; i++){
            long left = prefix[i] - honey[0];
            long right = (prefix[N-2] - prefix[i-1]);
            long value = left + right;
            answer = Math.max(answer, value);
        }

        // 출력
        System.out.println(answer);

    }
}