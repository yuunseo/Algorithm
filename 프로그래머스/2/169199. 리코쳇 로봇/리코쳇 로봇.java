/*
Q. R에서 시작해서 D에 부딪히면서 G에 도달하는 최소 이동 횟수를 구하세요.
A. 한번 이동할 때, 상하좌우를 결정한 다음 D 혹은 범위를 벗어날 때까지 이동한 후, 
    해당 위치가 이동한 새로운 위치이다.
*/
import java.util.*;

class Solution {
    
    static int[][] maps;
    static int n, m;
    static int[] dy = new int[] {-1,1,0,0};
    static int[] dx = new int[] {0,0,-1,1};
    
    public int solution(String[] board) {
        
        // board를 2차원 배열화하기
        n = board.length;
        m = board[0].length();
        maps = new int[n][m];
        
        int[] start = new int[2];
        int[] end = new int[2];
        
        for(int i=0; i<n; i++){
            String str = board[i];
            for(int j=0; j<m; j++){
                char c = str.charAt(j);
                
                // 출발, 도착지점 저장
                if(c == 'R'){
                    start[0] = i; start[1] = j;
                }else if(c == 'G'){
                    end[0] = i; end[1] = j; 
                }
                
                if(c == 'D' ) maps[i][j] = 0; // 지나갈 수 없음
                else maps[i][j] = 1; // 지나갈 수 있음
                
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        // 시작점에서부터 출발하기
        q.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            // 도착지 확인
            if(cur[0] == end[0] && cur[1] == end[1]) return cur[2];

            for(int d=0; d<4; d++){
                // 방향 결정 (현재 위치에서 시작, 다음 위치로 이동 못 할 수도 있기 때문)
                int ny = cur[0];
                int nx = cur[1];

                // 방향대로 직진 (벽 혹은 범위를 넘어갈 때까지 직진)
                while(canMove(ny+dy[d], nx+dx[d])){
                    ny += dy[d];
                    nx += dx[d];
                }

                if(!visited[ny][nx]){
                    q.add(new int[] {ny, nx, cur[2]+1});
                    visited[ny][nx] = true;
                }
            }

        }
        
        return -1;
    }
    
    /* canMove: 다음 위치로 이동할 수 있는지 참거짓을 반환하는 함수*/
    private boolean canMove(int newY, int newX) {
        return 0 <= newY && newY < n
                && 0 <= newX && newX < m
                && maps[newY][newX] == 1;
    }
    
    
}