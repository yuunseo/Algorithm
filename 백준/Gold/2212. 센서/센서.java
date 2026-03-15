import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 센서 개수
        int K = Integer.parseInt(br.readLine()); // 집중국 개수

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sensor = new int[N];

        // 센서 위치 입력
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        // 집중국이 센서보다 많거나 같으면
        // 각 센서마다 하나씩 설치 가능 → 거리 0
        if (K >= N) {
            System.out.println(0);
            return;
        }

        // 1. 센서 위치 정렬
        Arrays.sort(sensor);

        // 2. 센서 사이 거리 저장
        int[] dist = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            dist[i] = sensor[i + 1] - sensor[i];
        }

        // 3. 거리 정렬
        Arrays.sort(dist);

        // 4. 가장 큰 K-1개 거리 제거
        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += dist[i];
        }

        // 5. 결과 출력
        System.out.println(result);
    }
}