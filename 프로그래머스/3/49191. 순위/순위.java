import java.util.*;

class Solution {
    
    static int n;
    public int solution(int n, int[][] results) {
        this.n = n;
        
        List<Integer>[] win = new ArrayList[n+1]; // 이긴 선수들 모음 
        for(int i=1; i<=n; i++){
            win[i] = new ArrayList<>();
        }
        List<Integer>[] lose = new ArrayList[n+1]; // 패배한 선수들 모음
        for(int i=1; i<=n; i++){
            lose[i] = new ArrayList<>();
        }
        
        for(int[] result: results){
            int winner = result[0];
            int loser = result[1];
            win[winner].add(loser); // winner가 이긴 선수들 모음
            lose[loser].add(winner); // loser가 진 선수들 모음
        }
        
        int answer = 0;
        for(int player = 1; player<=n ;player++){
            int winCount = bfs(player, win, 0); // 선수가 총 이긴 횟수
            int loseCount = bfs(player, lose, 0); // 선수가 총 진 횟수
            
            if(winCount+loseCount == n-1) answer++;
        }
        
        return answer;
    }
    
    static int bfs(int player, List<Integer>[] group, int count){
        Queue<Integer> q = new LinkedList<>();
        q.add(player);
        boolean[] visited = new boolean[n+1];
        visited[player] = true;
        
        int total = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next: group[cur]){
                if(visited[next]) continue;
                q.add(next);
                visited[next] = true;
                total += 1;
            }
            
        }
        
        return total;
        
    }
}