/*
Q. 출발지점(1,1)에서 도착지점(N,M)까지 최단거리로 가는 방법
A. BFS를 이용해서 도착지점에 가는 최단거리 구하기
*/
import java.util.*;

class Solution {
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    public int solution(int[][] maps) {
        
        // 변수 초기화
        int n = maps.length;
        int m = maps[0].length;
        
        // 도착지점에 도달할 수 있으면, 최단거리 찾기
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        // 시작점(0,0)에서 출발
        q.add(new int[] {0,0,1}); 
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            // 도착점이라면 종료
            if(cur[0] == n-1 && cur[1] == m-1){
                return cur[2];
            }
            
            // 시작점에서 갈 수 있는 길 확인하기
            for(int d=0; d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                if(ny<0 || ny>=n || nx<0 || nx>=m) continue; 
                if(maps[ny][nx] == 0) continue;
                
                // 벽이 아닌 길이라면, 이동
                if(!visited[ny][nx]){
                    q.add(new int[] {ny, nx, cur[2]+1});
                    visited[ny][nx] = true;
                }
            }
        }
        
        return -1;
        
    }
}