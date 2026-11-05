import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 각 노드별 연결된 노드 저장을 위한 자료구조 초기화
        ArrayList<Integer>[] graph = new ArrayList[n+1]; // 1~n 노드를 위해
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        // graph 초기화
        for(int[] e: edge){
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1); // -1이면 방문 안 함을 의미
        queue.offer(1);
        distance[1] = 0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            // 다음 노드로 이동
            if(graph[cur].size() == 0) continue;
            
            for(int next: graph[cur]){
                if(distance[next] == -1){
                    queue.offer(next);
                    distance[next] = distance[cur] + 1;
                }
            }
        }
        
        // 최장 거리 계산
        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, distance[i]);
        }

        // 최장 거리 노드 개수 계산
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(distance[i] == max){
                answer++;
            }
        }

        // 결과
        return answer;
    }
        
}
