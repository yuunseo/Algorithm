/*
1. 수빈-동생 위치가 수빈*2보다 멀다면, 동생 쪽으로 순간이동
2. 수빈-동생 위치가 수빈*2보다 가깝다면, 동생 쪽으로 걷기
3. 1,2를 거리가 0이 될 때까지 반복
-> 이렇게 해결하면 greedy임. 무조건 순간이동 한다고 빠른게 아닐 수 있음.

1. 그래프 탐색, 각 위치가 노드이며 이동 초 수가 가중치(0과 1)
2. 
*/

import java.util.*;
import java.io.*;

class Main{
    
    static final int MAX = 100000; // 수빈이의 위치 최대값
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력 초기화
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());        
        
        // 필요한 변수 초기화
        int[] dist = new int[MAX + 1]; // 방문했을 때의 초 저장 배열
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Deque<Integer> dq = new ArrayDeque<>();
        dist[N] = 0; // 시작 위치 초기화
        dq.add(N);
        
        // 도달할 때까지 반복
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            if (cur == K) break;

            // 순간이동 (비용 0)
            int next = cur * 2;
            if (next <= MAX && dist[next] > dist[cur]) {
                dist[next] = dist[cur];
                dq.addFirst(next);
            }

            // 왼쪽 이동 (비용 1)
            next = cur - 1;
            if (next >= 0 && dist[next] > dist[cur] + 1) {
                dist[next] = dist[cur] + 1;
                dq.addLast(next);
            }

            // 오른쪽 이동 (비용 1)
            next = cur + 1;
            if (next <= MAX && dist[next] > dist[cur] + 1) {
                dist[next] = dist[cur] + 1;
                dq.addLast(next);
            }
        }
        
        // 결과 출력
        System.out.println(dist[K]);
    }
}