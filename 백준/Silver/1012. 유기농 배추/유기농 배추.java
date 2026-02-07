/*
하나의 영역에 한 마이만 있으면 되므로, 필요한 지렁이의 마리 수 구하기 = 영역의 개수 구하기
BFS
1. 전체 지도 만들어두기, 배추 큐 만들기
2. 배추 큐에서 하나씩 -> 방문하지 않은 배추라면 새로운 큐에 삽입
3. 큐에서 하나씩 꺼내면서 인접한데 1인 칸을 큐에 다시 삽입
4. 큐가 비었을 때, 영역 cnt+1
5. 배추 큐 비었으면 종료, cnt 출력

*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로
            int N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추의 개수
            
            
            int[][] map = new int[N][M]; // 배추 지도
            boolean[][] visited = new boolean[N][M]; // 방문 배열
            int cnt = 0; // 영역의 개수
            Queue<int[]> pos = new LinkedList<>(); // 배추 큐
            
            // 배추 지도, 배추 큐 채우기
            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                map[y][x] = 1;
                pos.offer(new int[] {y,x});
            }
            
            // 배추 큐 빌 때까지 반복
            while(!pos.isEmpty()){
                int[] cur = pos.poll();
                if(!visited[cur[0]][cur[1]]){
                    visited[cur[0]][cur[1]] = true;
                    Queue<int[]> dummy = new LinkedList<>(); // 영역 큐
                    dummy.offer(cur);
                    
                    while(!dummy.isEmpty()){
                        int[] dum = dummy.poll();
                        int x = dum[1];
                        int y = dum[0];
                        int[] dx = {0,0,-1,1};
                        int[] dy = {-1,1,0,0};
                        
                        for(int d=0; d<4; d++){
                            int ny = y+dy[d];
                            int nx = x+dx[d];
                            if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
                            if(!visited[ny][nx] && map[ny][nx] == 1){
                                visited[ny][nx] = true;
                                dummy.offer(new int[] {ny,nx});
                            }
                        }
                    }
                    
                    cnt++; // 하나의 영역이 종료되면 영역 개수 증가
                }
            }
            
            sb.append(cnt).append("\n");
        }
        
        // 결과 출력
        System.out.println(sb);
    }
}