/*
Q. N*N 정사각형 경주로 (0으로 이동 가능), 상하좌우 2칸 이상 같은 위치면 직선도로
A. 최소 비용으로 도착하는 직선도로 개수, 코너 개수 구하기!
    - 최소 비용 거리 구하기: 다익스트라, 최단 거리더라도 최소 비용을 찾아야 함
    - 직선 도로 구하기: 다음 땅으로 이동했을 때, 이전 땅의 방향과 현재 땅의 방향 비교하기
*/
import java.util.*;

class Solution {
    
    static int[] dy = new int[] {-1,1,0,0};
    static int[] dx = new int[] {0,0,-1,1};
    static int straight = 100;
    static int corner = 500;
    
    public int solution(int[][] board) {
        
        // 변수 초기화
        int n = board.length;
        
        // cost[y][x][방향(상하좌우)]
        // 해당 방향으로 (y, x)에 도착했을 때의 최소 비용
        // 3번째 인덱스에서는 상하좌우 칸을 만들어두고, 맟는 방향에 기록할 예정
        int[][][] cost = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        // 경로 구하기
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,-1,0}); // y, x, 이전 방향, 현재까지의 비용
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int prev = cur[2];
            int totalCost = cur[3];
            
            for(int d=0; d<4; d++){ // 다음으로 이동할 위치 구하기
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if(ny<0 || nx<0 || ny>=n || nx>=n ||
                  board[ny][nx] == 1) continue;
                
                int nextCost; // 다음 위치로 이동
                
                // 첫 이동이거나 || 같은 방향이면 + 직선 도로
                if (prev == -1 || prev == d) {
                    nextCost = totalCost + straight;
                } else {
                    // 방향이 바뀌면 + 직선 도로 + 코너
                    nextCost = totalCost + corner + straight;
                }
                 
                /*
                 * 같은 위치라도 들어온 방향에 따라
                 * 이후 비용이 달라질 수 있으므로 방향별로 비교한다.
                 * nextCost가 더 작다면, 갱신
                 */
                if (nextCost < cost[ny][nx][d]) {
                    cost[ny][nx][d] = nextCost;
                    q.add(new int[] {ny, nx, d, nextCost});
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;

        // 도착점에 각 방향으로 도착한 비용 중 최솟값
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, cost[n - 1][n - 1][d]);
        }

        return answer;
      
    }
}