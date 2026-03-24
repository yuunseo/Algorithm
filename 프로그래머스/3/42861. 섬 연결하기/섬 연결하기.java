import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 간선 기준으로 오름차순 정렬
        Arrays.sort(costs, (a,b)->a[2]-b[2]);
        
        // 같은 그룹인지 판별하기 위한 배열
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        // 최소 간선부터 선택
        int count = 0;
        for(int[] cost: costs){
            int a = cost[0];
            int b = cost[1];
            int val = cost[2];
            
            // 두 섬이 연결되어 있는가?
            if(findParent(parent, a) != findParent(parent,b)){
                // 연결되지 않았으면, 연결하고 비용 갱신
                union(parent,a,b);
                answer += val;
                count++;
            }
            
            if(count == n-1) break; // 모든 섬이 연결 되었으면 종료
            
        }
        
        return answer;
    }
    
    static int findParent(int[] parent, int cur){
        if(parent[cur] == cur) return cur;
        return parent[cur] = findParent(parent, parent[cur]) ;
    }
    
    static void union(int[] parent, int a, int b){
        int pa = parent[a];
        int pb = parent[b];
        
        if(pa != pb){
            parent[pb] = pa;
        }
    }
    
}