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

        boolean[] visited = new boolean[100001]; // 방문 배열
        int[] dist = new int[100001]; // 거리 배열
        
        Queue<Integer> pos = new LinkedList<>(); // 최소 시간 구하기 위한 큐
        pos.offer(N);
        visited[N] = true;
        dist[N] = 0;

        while(!pos.isEmpty()){
            int x = pos.poll();

            if(x == K){
                System.out.println(dist[x]);
                return;
            }
            
            int[] next = {x*2, x-1, x+1};
            
            for(int nx : next){
                if(nx<0 || nx>100000) continue;
                if(visited[nx]) continue;
                
                visited[nx] = true;
                dist[nx] = dist[x]+1;
                pos.offer(nx);
            }
        }
    }
}