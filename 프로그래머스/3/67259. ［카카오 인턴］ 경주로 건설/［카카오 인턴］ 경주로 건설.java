import java.util.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][][] cost = new int[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        // 시작 (방향 없음 → 둘 다 0 처리)
        q.add(new int[]{0,0,0,0}); 
        q.add(new int[]{0,0,1,0});
        
        cost[0][0][0] = 0;
        cost[0][0][1] = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int y = cur[0];
            int x = cur[1];
            int dir = cur[2];
            int curCost = cur[3];
            
            for(int d=0; d<4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
                if(board[ny][nx] == 1) continue;
                
                int nextDir = (d < 2) ? 0 : 1;
                
                int newCost = curCost + 100;
                if(dir != nextDir) newCost += 500;
                
                if(cost[ny][nx][nextDir] > newCost){
                    cost[ny][nx][nextDir] = newCost;
                    q.add(new int[]{ny, nx, nextDir, newCost});
                }
            }
        }
        
        return Math.min(cost[n-1][n-1][0], cost[n-1][n-1][1]);
    }
}