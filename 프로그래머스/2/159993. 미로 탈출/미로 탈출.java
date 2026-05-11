import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int w = maps[0].length();
        int h = maps.length;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        // 2차원 배열로 치환하기
        int[][] arr = new int[h][w];
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];
        for(int i=0; i<h; i++){
            String str = maps[i];
            for(int j=0; j<w; j++){
                if(str.charAt(j) == 'O') arr[i][j] = 1;
                else if(str.charAt(j) == 'X') arr[i][j] = 0;
                else if(str.charAt(j) == 'S'){
                    arr[i][j] = 2;
                    start = new int[] {i,j};
                }
                else if(str.charAt(j) == 'E'){
                    arr[i][j] = 3;
                    end = new int[] {i,j};
                }else if(str.charAt(j) == 'L'){
                    arr[i][j] = 4;
                    lever = new int[] {i,j};
                }
            }
        }
        
        // S -> L 최단거리 구하기
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        q.add(new int[] {start[0],start[1],0});
        visited[start[0]][start[1]] = true;
        int start_to_lever = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int d=0; d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                
                if(ny<0 || nx<0 || nx>=w || ny>=h) continue;
                if(visited[ny][nx] || arr[ny][nx] == 0) continue;
                
                if(arr[ny][nx] == 4){ // 레버 도착 시 종료
                    start_to_lever = cur[2]+1;
                    break;
                }else{
                    q.add(new int[] {ny,nx,cur[2]+1}); // 다음 칸으로 이동
                    visited[ny][nx] = true;
                }
                
            }
            if(start_to_lever != -1) break;
        }
        
        // 레버에서 출구까지 최단거리
        Queue<int[]> q2 = new LinkedList<>();
        boolean[][] visited2 = new boolean[h][w];
        q2.add(new int[] {lever[0],lever[1],0});
        visited2[lever[0]][lever[1]] = true;
        int lever_to_end = -1;
        while(!q2.isEmpty()){
            int[] cur = q2.poll();
            
            for(int d=0; d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                
                if(ny<0 || nx<0 || nx>=w || ny>=h) continue;
                if(visited2[ny][nx] || arr[ny][nx] == 0) continue;
                
                if(arr[ny][nx] == 3){ // 출구 도착 시 종료
                    lever_to_end = cur[2]+1;
                    break;
                }else{
                    q2.add(new int[] {ny,nx,cur[2]+1}); // 다음 칸으로 이동
                    visited2[ny][nx] = true;
                }
                
            }
            if(lever_to_end != -1) break;
        }
        
        if(start_to_lever == -1 || lever_to_end == -1) return -1;
        
        return start_to_lever + lever_to_end;
    }
}