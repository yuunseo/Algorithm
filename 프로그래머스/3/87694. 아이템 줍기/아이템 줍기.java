/*
1. 서로 다른 직사각형들의 바깥 둘레 구하기
2. 캐릭터의 거리 ~ 아이템의 거리 사이 최단 거리 구하기
*/
import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        // 이동가능한 테두리 구하기
        int[][] map = new int[102][102];
        
        // 2배 증가해서 그리기 
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            // 전체 채우기
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    map[y][x] = 1;
                }
            }
        }
        
        // 내부 지우기
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int y = y1 + 1; y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    map[y][x] = 0;
                }
            }
        }
        
        // 캐릭터 ~ 아이템까지 최단 거리 구하기 (BFS)
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        visited[characterY*2][characterX*2] = true;
        q.add(new int[] {characterX*2, characterY*2,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == itemX*2 && cur[1] == itemY*2){
                return cur[2]/2;
            }
            
            for(int d=0;d<4;d++){
                int ny = cur[1] + dy[d];
                int nx = cur[0] + dx[d];
                if(ny<=0 || nx<=0 || ny>=102 || nx>=102) continue;
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    visited[ny][nx] = true;
                    q.add(new int[] {nx, ny, cur[2]+1});
                }
            }
            
        }
        
        return answer;
    }
}