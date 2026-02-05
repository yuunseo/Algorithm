import java.util.*;
import java.io.*;

class Main {
    static int idx(int x, int N) {
        return (x % N + N) % N;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] cows = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cows[i] = Integer.parseInt(st.nextToken());

        int[] fakes = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) fakes[i] = Integer.parseInt(st.nextToken()) - 1;

        long S = 0;
        for (int i = 0; i < N; i++) {
            S += cows[i] * cows[idx(i+1,N)] * cows[idx(i+2,N)] * cows[idx(i+3,N)];
        }

        for (int q = 0; q < Q; q++) {
            int k = fakes[q];

            for (int d = -3; d <= 0; d++) {
                int i = idx(k + d, N);
                S -= cows[i] * cows[idx(i+1,N)] * cows[idx(i+2,N)] * cows[idx(i+3,N)];
            }

            cows[k] *= -1;

            for (int d = -3; d <= 0; d++) {
                int i = idx(k + d, N);
                S += cows[i] * cows[idx(i+1,N)] * cows[idx(i+2,N)] * cows[idx(i+3,N)];
            }

            System.out.println(S);
        }
    }
}
