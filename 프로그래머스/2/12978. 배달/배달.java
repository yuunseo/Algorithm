/*
Q. 1번 마을에서 출발해서 총 K 시간 이하로 배달 가능한 마을의 개수는?
   단, 1번 마을도 포함한다.

A. 1번 마을부터 각 마을까지의 최소 거리를 dist 배열에 저장한다.

   아직 최단 거리가 확정되지 않은 마을 중
   거리가 가장 가까운 마을을 하나 선택하고,
   해당 마을을 거쳐 다른 마을로 가는 거리가 더 짧다면 갱신한다.

   모든 마을을 확인한 뒤 dist 값이 K 이하인 마을의 개수를 구한다.
*/
import java.util.*;

class Solution {
    
    // static - 여러 메소드와 공유해서 사용하기 위함
    static int[][] map; 
    static int[] dist;
    static boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 양방향 거리 배열
        map = new int[N+1][N+1]; // 1번부터 N번 마을
        // 연결되지 않은 마을은 큰 값으로 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][i] = 0;
        }

        for(int[] r: road){
            int a = r[0];
            int b = r[1];
            int c = r[2];
            
            map[a][b] = Math.min(map[a][b], c);
            map[b][a] = Math.min(map[b][a], c);
        }
        
        // 1번마을로부터의 거리 배열
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; // 출발점
        
        // 1번 마을과 연결된 마을로 이동해서 거리를 출력하는 함수
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            nextVillage(N);
        }

        // K 이하인 마을 개수 구하기
        for(int i=1; i<=N; i++){
            if(dist[i] <= K) answer ++;
        }

        return answer;
    }
    
    private void nextVillage(int N){
        
        int cur = -1;
        int minDistance = Integer.MAX_VALUE;
        
        // 방문하지 않은 마을 찾기
        for(int i=1; i<=N; i++){
            if(!visited[i] && dist[i] < minDistance){ 
                minDistance = dist[i];
                cur = i;
            }
        }
        
        // 방문할 수 있는 마을이 없으면, 종료
        if(cur == -1) return;
        
        // 최단 거리인 마을은 확정짓기 
        visited[cur] = true;
        
        // 다음 마을로 이동하기
        for(int next=1; next<=N; next++){
            if(visited[next]) continue; // 이미 방문했으면 건너뛰기
            
            if(map[cur][next] == Integer.MAX_VALUE){
                continue; // 연결되지 않았으면 건너뛰기
            }
            
            int newDistance = dist[cur] + map[cur][next];
            
            if(newDistance < dist[next]){
                dist[next] = newDistance;
            }
        }
    }
}