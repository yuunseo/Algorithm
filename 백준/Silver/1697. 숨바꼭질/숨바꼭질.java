/*
수빈이 위치 -> 동생 위치 최단 시간 구하기
걷거나 순간이동하는데 거리는 시간은 1초
BFS로 큐에 삽입하면서 가기 -> 좌표+시간
*/

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치
        int cnt = 0;

        Queue<int[]> pos = new LinkedList<>(); // 최소 시간 구하기 위한 큐
        boolean[] visited = new boolean[100001];
        pos.offer(new int[] {N,0});
        visited[N] = true;

        while(!pos.isEmpty()){
            int[] cur = pos.poll();
            int x = cur[0];
            int dist = cur[1];

            if(x == K){
                System.out.println(dist);
                return;
            }

            if(0<= 2*x && 2*x <= 100000 && !visited[2*x]){
                pos.offer(new int[] {2*x, dist+1});
                visited[2*x] = true;    
            }
            if(0<=x-1 && x-1 <= 100000 && !visited[x-1]){
                pos.offer(new int[] {x-1, dist+1});
                visited[x-1] = true;
            }

            if(0<=x+1 && x+1<=100000 && !visited[x+1]){
                pos.offer(new int[] {x+1, dist+1});
                visited[x+1] = true;
            }

        }


    }
}