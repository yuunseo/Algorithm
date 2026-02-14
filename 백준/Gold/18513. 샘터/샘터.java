/*
집과 샘터사이의 거리가 최소가 되게끔, 그 최솟값을 출력하자
샘터의 위치는 고정이고, 집의 위치를 바꿈으로써만 구할 수 있음!

bfs
1. 샘터의 위치를 모두 큐에 넣자 {샘터의 위치 좌표, 불행도 =0}
2. 샘터를 꺼내서 좌우 집을 지을 수 있는지 확인하자 & 방문배열도 필요
3. 이때 집을 짓고 나면 집의 개수 K를 --해주면서, 그러다가 K가 0개되면 멈추기
4. 큐에 모든 집들 꺼내서 불행도 총합 구해서 출력하기

*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 샘터랑 집 초기화
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 샘터의 위치 
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> houses = new LinkedList<>();
        
        // 방문 배열을 초기화 할 수 가 없음 -100000000~100000000이라서
        // 그러니까 Set에다가 방문하면 추가하자
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            visited.add(n);
            houses.add(new int[] {n,0});
        }
        
        // 샘터의 주변부터 집 짓기
        long total = 0;
        while(K>0){
            int[] cur = houses.poll();
            
            // 좌우: 방문했는지 점검
            int left = cur[0]-1;
            int right = cur[0]+1;
            if(!visited.contains(left)){
                visited.add(left);
                houses.add(new int[] {left, cur[1]+1});
                K--; // 집 지었으면 남은 개수 줄이기
                total += cur[1]+1;
                if(K == 0) break;
            }
            if(!visited.contains(right)){
                visited.add(right);
                houses.add(new int[] {right, cur[1]+1});
                K--; 
                total += cur[1]+1;
                if(K == 0) break;
            }
        }
        
        System.out.println(total);
        
    }
}
