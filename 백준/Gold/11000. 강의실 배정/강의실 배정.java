import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2]; // i번째 수업의 시작시간, 종료시간
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[i][0] = s;
            list[i][1] = t;
        }
        
        // 시작 시간이 이른 강의부터 정렬 (오름차순)
        Arrays.sort(list, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        // 강의들을 순서대로 비교시작
        // 현재 강의의 종료 시간보다 늦게 시작하는 수업이 있는지 확인
        // 있으면, 다음 강의로 이동해서 다시 비교
        // 이때 비교 대상: 현재 종료 시간 vs 다음 시작 시작
        // 늦게 시작하지 않는 다면, 비교 대상 큐에 추가하기
        
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(list[0][1]); // 가장 먼저 비교할 종료 시간 추가
        
        for(int i = 1; i < N; i++){
            if(pq.peek() <= list[i][0]){
                pq.poll(); // 재사용
            }
            pq.offer(list[i][1]);
        }
        
        System.out.println(pq.size());
        
    }
}
