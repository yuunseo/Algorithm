import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,1});
        visited[0][0] = true;
        
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int len = cur[2];
            
            if(y==n-1 && x==m-1){
                return len;
            }
            
            for(int d=0; d<4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
                if(!visited[ny][nx] && maps[ny][nx] == 1){
                    q.add(new int[] {ny, nx, len+1});
                    visited[ny][nx] = true;
                }
            }
            
        }
        
        return -1;
    }
}