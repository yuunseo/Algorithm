/*
1. BFS로 덩어리 영역을 구하고 -> 영역의 합 구해서 저장해두기
2. 영역을 구한 애들은 visited 처리해야됨
3. 단, BFS갈 때 구한 visited와 별개로?
*/

import java.util.*;

class Solution {
    
    static int h,w;
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // 영역 구하기 위해 큐 생성
        Queue<int[]> q = new LinkedList<>();
        
        // 2차원 배열로 변경
        h = maps.length;
        w = maps[0].length();
        int[][] map = new int[h][w];
        int[][] island = new int[h][w]; // 땅 기록용 배열
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                char c = maps[i].charAt(j);
                
                if(c == 'X'){ // 바다인 경우, 패쓰
                    map[i][j] = 0;
                    island[i][j] = -1;
                }else{ // 땅인 경우, 식량 개수로 추가
                    map[i][j] = c - '0';
                    q.add(new int[] {i,j}); // 큐에 삽입, 이후 꺼내서 연결된 영역 구함.
                }
            }
        }
        
        // 아무런 땅도 없으면 -1 반환
        if(q.isEmpty()){
            return new int[] {-1};
        }
        
        // 연결된 땅들 구하기
        int idx = 1; // 영역 구분용
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            
            // 1. 이미 섬으로 계산 땅인가?
            if(island[y][x] != 0){
                continue;
            }
            
            // 2. 땅인데, 섬으로 계산되기 전이면 연결된 땅 구하기
            int saveDays = bfs(y, x, island, map, idx);
            result.add(saveDays);
            
            idx++;
        }
        
        // 오름차순 정렬하기
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
    
    private int bfs(int y, int x, int[][] island, int[][] map, int idx){
        Queue<int[]> tempQ = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        
        int total = map[y][x];
        tempQ.add(new int[] {y,x});
        visited[y][x] = true;
        island[y][x] = idx;
        
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        while(!tempQ.isEmpty()){
            // 시작
            int[] cur = tempQ.poll();
            
            // 연결된 땅이 있는지 확인
            for(int d=0; d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                
                if(ny<0 || nx<0 || ny>=h || nx>=w 
                   || visited[ny][nx] || island[ny][nx] != 0) continue;
                
                total += map[ny][nx];
                visited[ny][nx] = true;
                island[ny][nx] = idx;
                tempQ.add(new int[] {ny,nx});
            }
            
        }
        
        return total;
    }
}