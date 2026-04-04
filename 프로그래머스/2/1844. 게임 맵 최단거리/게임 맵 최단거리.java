import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length; // 게임맵 크기
        int m = maps[0].length;
        int answer = -1; // 최단거리
        
        int[] dx = {0,0,-1,1}; // 이동 배열
        int[] dy = {-1,1,0,0};
        
        int[][] minArr = new int[n][m];
        minArr[0][0] = 1; 
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            
            
            
            // 종료 조건
            if(y==n-1 && x==m-1){
                answer = minArr[y][x];
            }
            
            for(int d=0;d<4;d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if(ny<0 || nx<0 || nx>=m || ny>=n) continue;
                
                if(!visited[ny][nx] && maps[ny][nx] != 0){
                    q.add(new int[] {ny,nx});
                    visited[ny][nx] = true;
                    minArr[ny][nx] = minArr[y][x] + 1;
                }
            }
            
        }
        
        return answer;
        
    }
}