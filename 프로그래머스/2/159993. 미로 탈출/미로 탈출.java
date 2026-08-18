/*
Q. 레버 칸을 지나, 미로를 나가는 데 걸리는 최단 시간 구하기 (BFS)
A. S -> O -> L -> O -> E
- O 통로 X 벽
- 여러 번 지날 수 있으며, 탈출할 수 없으면 -1 반환
- S -> L 까지 BFS로 최단 경로 구하고
- L -> E 까지 BFS로 최단 경로 구해보자!
*/
import java.util.*;

class Solution {
    static int answer = 0;
    static char[][] arr;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int n;
    static int m;
    
    public int solution(String[] maps) {
        
        // 좌표 저장
        int startX=0; int startY=0;
        int leverX=0; int leverY=0;
        int endX=0; int endY=0;
        
        // 2차원 배열 초기화
        n = maps.length;
        m = maps[0].length();
        arr = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = maps[i].charAt(j);
                
                // 지점 좌표 구하기
                if(arr[i][j] == 'S'){
                    startY=i; startX=j;
                }else if(arr[i][j] == 'L'){
                    leverY=i; leverX=j;
                }else if(arr[i][j] == 'E'){
                    endY=i; endX=j;
                }
            }
        }
        
        // S -> L BFS 구하기
        int leverDistance = bfs(startY, startX, leverY, leverX);
        if(leverDistance<0) return -1;
        answer += leverDistance;
        
        // L -> E BFS 구하기
        int endDistance = bfs(leverY, leverX, endY, endX);
        if(endDistance<0) return -1;
        answer += endDistance;
        
        return answer;
        
    }
    
    private int bfs(int sy, int sx, int ey, int ex){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sy, sx, 0});
        visited[sy][sx] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            // 종료
            if(cur[0] == ey && cur[1] == ex){
                return cur[2];
            }
            
            // 상하좌우 확인하기
            for(int d=0; d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                
                if(ny<0 || nx<0 || 
                   ny>=n || nx>=m ||
                  arr[ny][nx] == 'X' ||
                  visited[ny][nx]) continue;
                
                q.add(new int[] {ny, nx, cur[2]+1});
                visited[ny][nx] = true;
            }
            
        }
        
        return -1;
    }
}