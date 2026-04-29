/*
양 > 늑대가 참인 동안 반복
왔던 노드 다시 방문할 수 있으면서, 모든 경우의 수 중 양을 최대한 많이 모을 수 있는 경우 선택하기
*/
import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        int num = info.length; // 모든 동물의 개수
        
        // 그래프 초기화
        List<Integer>[] graph = new ArrayList[num];
        for(int i=0; i<num; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 간선 저장 (부모->자식)
        for(int[] edge: edges){
            int parent = edge[0];
            int child = edge[1];
            graph[parent].add(child);
        }
        
        // 0번 노드부터 방문 시작
        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        dfs(0, 0, candidates, graph, info); // (양 카운트, 늑대 카운트, 다음 노드)
        
        return answer;
    }
    
    static void dfs(int sheep_count, int wolf_count, List<Integer> candidates, List<Integer>[] graph, int[] info){
        
        for(int node: candidates){
            // 다음 양, 늑대 카운트
            int next_sheep = sheep_count;
            int next_wolf = wolf_count;
            if(info[node] == 0) next_sheep++;
            else next_wolf++;
            
            // 늑대가 양 이상이면 실패
            if (next_wolf >= next_sheep) {
                continue;
            }
            
            // 정답 갱신
            answer = Math.max(answer, next_sheep);
            
            // 새롭게 갈 수 있는 후보지 업데이트
            List<Integer> new_candidates = new ArrayList<>(candidates);
            new_candidates.remove(Integer.valueOf(node)); // 현재 노드 제외
            new_candidates.addAll(graph[node]); // 현재 자식 추가
            
            // 다음 탐색
            dfs(next_sheep, next_wolf, new_candidates, graph, info);
            
        }
    }
}