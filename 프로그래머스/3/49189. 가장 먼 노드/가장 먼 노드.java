import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        int answer = 0; // 최종 노드 개수
        int[] nodes = new int[n+1]; // 1~n번 노드까지의 거리 저장 배열
        Arrays.fill(nodes, -1);
        
        List<Integer>[] arr = new ArrayList[n+1];
        for(int i=1; i<=n ;i++){
            arr[i] = new ArrayList<>();
        }
        for(int[] e: edge){
            int a = e[0];
            int b = e[1];
            arr[a].add(b);
            arr[b].add(a);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1,0}); // (시작점, 간선의 개수)
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int nod = cur[0];
            int count = cur[1];
            nodes[nod] = count;
            
            for(int next: arr[nod]){
                if(visited[next]) continue;
                
                q.add(new int[] {next, count+1});
                visited[next] = true;
            }
            
        }
        
        int maxVal = -1;
        for(int num: nodes){
            if(num != Integer.MAX_VALUE ){
                maxVal = Math.max(maxVal, num);
            }
            
        }
        
        for(int num: nodes){
            if(num == maxVal) answer++;
        }
        
        return answer;
    }
}
