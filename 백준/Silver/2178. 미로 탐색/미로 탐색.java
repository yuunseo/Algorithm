/*
시작점에서 도착지까지의 최소 칸 수 구하기 -> BFS
1. 시작점에서 이동 가능한 칸을 Queue에 모두 삽입
2. Queue에서 하나씩 꺼내서 인접 칸들을 또 Queue에 삽입
3. 이때 큐에 저장하는 값은 (좌표),이동한 거리 수 를 저장하기
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 기본 맵
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        
        // 방문 배열
        boolean[][] visited = new boolean[N][M];
        // 최소값 구하기 위한 큐
        Queue<int[]> que = new LinkedList<>();
        int cnt = 1;
        que.offer(new int[] {0,0,cnt}); // 시작점 초기화
        visited[0][0] = true;
        
        
        // 시작점에서 도착지점까지 반복
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0];
            int x = cur[1];
            int dist = cur[2];
            
            if(y==N-1 && x==M-1){
                System.out.println(dist);
                return;
            }
            
            // 해당 좌표와 인접한 칸 구하기
            int[] dx = {0,0,-1,1};
            int[] dy = {-1,1,0,0};
            for(int d=0; d<4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if(0>nx || nx>=M || 0>ny || ny>=N) continue; // 범위 초과
                
                // 방문하지 않은 칸과 인접하다면, 큐에 좌표와 이동거리를 삽입
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    visited[ny][nx] = true;
                    que.offer(new int[] {ny,nx,dist+1});
                }
                
                
            }
        }
        
    }
}