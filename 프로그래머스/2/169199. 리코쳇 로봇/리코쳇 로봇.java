/*
끝까지 이동이 완료되었을 때, G인 경우에만 성공! G를 지나가는 건 제외
1. 상하좌우로 벽/장애물 만날 때까지 계속 이동하기
2. 벽/장애물 만나면 상하좌우로 이동해보기 -> while 문이 중첩되는데 시간 복잡도 괜찮을까..?
3. BFS로 최단 이동 거리 구하되, G에 도달하지 않고 큐가 비게 되면 실패(-1 반환)
*/
import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        // board를 여러번 참조해야 하므로, 이차원 배열로 변환
        char[][] arr = new char[board.length][board[0].length()];
        int[] start = new int[2];
        int[] end = new int[2];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                arr[i][j] = board[i].charAt(j);
                
                if(arr[i][j] == 'R'){ // 시작 지점 좌표
                    start[0] = i; start[1] = j;
                }else if(arr[i][j] == 'G'){ // 종료 지점 좌표
                    end[0] = i; end[1] = j;
                }
            }
        }
        
        // 시작점부터 이동 시작
        // 상하좌우 이동 배열
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        // 최단 거리 구하기 위해 Queue 생성
        Queue<int[]> q = new LinkedList<>(); // {i,j,count}
        boolean[][] visited = new boolean[board.length][board[0].length()];
        // 시작점부터 시작하기
        q.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        // 반복
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==end[0] && cur[1]==end[1]){  // 종료 지점인 경우, 끝
                    return cur[2];
            }
            
            // 상하좌우로 멈출 때까지 이동
            for(int d=0; d<4; d++){
                int ny = dy[d] + cur[0];
                int nx = dx[d] + cur[1];
                
                while(0<=ny && ny<board.length && 0<=nx && nx<board[0].length() && arr[ny][nx] != 'D'){
                    ny = ny + dy[d];
                    nx = nx + dx[d];
                }
                
                // 멈추면 이전 자리에서 방향 돌리기
                ny -= dy[d];
                nx -= dx[d];
                if(!visited[ny][nx]){ // 이전에 방문하지 않은 경우에만 추가
                   q.add(new int[] {ny,nx,cur[2]+1});
                    visited[ny][nx] = true;
                }
            }
            
        }
        
        
        return answer;
    }
}