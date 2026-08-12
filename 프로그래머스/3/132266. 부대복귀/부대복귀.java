/*
Q. 최단시간으로 부대에 복귀하는 시간 반환하기
A. roads- 지도
    destinaion- 목적지
    sources- 부대원들의 위치
    answer[]- sources 순서대로 돌아올 수 있는 최단 시간 반환하기
*/
import java.util.*;

class Solution {
    
    static int[] result;
    static boolean[] visited;
    static int[][] map;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        // 인접 배열 초기화
        /*
        예시 형태:
        map[1] = [2, 4]
        map[2] = [4, 5]
        map[3] = []
        map[4] = [2, 5]
        map[5] = [2, 4]
        */
        List<Integer>[] map = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            map[i] = new ArrayList<>();
        }

        for(int[] road : roads){
            int start = road[0];
            int end = road[1];

            map[start].add(end);
            map[end].add(start);
        }
        
        // 목적지부터의 거리 배열 초기화
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        // BFS로 최단거리 구하기
        Queue<Integer> queue = new LinkedList<>();

        queue.add(destination); // 목적지에서 시작
        dist[destination] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next : map[cur]){
                if(dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                queue.add(next);
            }
        }
        
        // sources 순서대로 정답 넣기
        int[] result = new int[sources.length];

        for(int i = 0; i < sources.length; i++){
            result[i] = dist[sources[i]];
        }

        return result;
    
    }
    
    
}