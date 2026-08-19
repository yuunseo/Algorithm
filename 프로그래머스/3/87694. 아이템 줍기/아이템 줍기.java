/*
1. 직사각형들이 차지하는 칸 구하기 
2. 테두리만 남겨두고, 내부는 지우기 (2배)
3. 테두리로만 이동하면서, 최단 경로 찾기
*/
import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // 변수 2배 초기화
        int startY = characterY * 2;
        int startX = characterX * 2;
        int endY = itemY * 2;
        int endX = itemX * 2;
        
        // 지도
        int[][] map = new int[102][102];
        
        // 지도 그리기
        for(int i=0; i<rectangle.length; i++){
            int[] rec = rectangle[i];
            
            for(int x = rec[0]*2 ; x<=rec[2]*2 ; x++){
                for(int y = rec[1]*2 ; y<= rec[3]*2; y++){
                    map[y][x] = 1;
                }
            }
        }
        
        // 테두리만 남기기
        for(int i=0; i<rectangle.length; i++){
            int[] rec = rectangle[i];
            
            for(int x = rec[0]*2+1; x<rec[2]*2; x++){
                for(int y = rec[1]*2+1; y< rec[3]*2; y++){
                    map[y][x] = 0;
                }
            }
        }
        
        // 시작점에서 아이템까지 BFS
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        // 시작점 넣기
        q.add(new int[] {startY, startX, 0});
        visited[startY][startX] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            // 종료
            if(cur[0] == endY && cur[1] == endX){
                return cur[2]/2;
            }
            
            for(int d=0; d<4; d++){
                int ny = dy[d] + cur[0];
                int nx = dx[d] + cur[1];
                
                if(ny<=0 || nx<=0 || ny>=102 || nx>=102 ||
                  visited[ny][nx] || map[ny][nx] == 0) continue;
                
                q.add(new int[] {ny, nx, cur[2]+1});
                visited[ny][nx] = true;
            }
        }
        
        return 0;
        
    }
}