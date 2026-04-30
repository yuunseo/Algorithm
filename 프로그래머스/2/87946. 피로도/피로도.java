class Solution {
    static int answer = 0; 

    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        
        // 탐험 시작
        dfs(k, dungeons, visited, 0);
        
        return answer;
    }

    static void dfs(int k, int[][] dungeons, boolean[] visited, int cnt) {
        // 매 단계마다 현재까지 탐험한 던전 수의 최댓값을 갱신
        answer = Math.max(answer, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            // 1. 방문하지 않았고 2. 현재 피로도가 최소 필요 피로도 이상인 경우
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true; // 방문 처리
                
                // 다음 던전 탐색
                dfs(k - dungeons[i][1], dungeons, visited, cnt + 1);
                
                visited[i] = false; // 복구 (백트래킹)
            }
        }
    }
}