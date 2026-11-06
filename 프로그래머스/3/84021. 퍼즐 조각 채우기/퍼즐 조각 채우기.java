import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    static int n;
    static boolean[][] isVisited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        // 빈 공간의 모양 탐색하기
        ArrayList<ArrayList<int[]>> empty_list = new ArrayList<>();
        n = game_board.length;
        isVisited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(game_board[i][j] == 1 || isVisited[i][j]) continue;
                
                empty_list.add(normalize(bfs(i,j, game_board, isVisited, 0)));
            }
        }
    
        
        // 퍼즐 조각 모양 탐색하기
        ArrayList<ArrayList<int[]>> puzzle_list = new ArrayList<>();
        isVisited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(table[i][j] == 0 || isVisited[i][j]) continue;
                
                puzzle_list.add(normalize(bfs(i,j, table, isVisited,1)));
            }
        }
        
        // 맞는 퍼즐 탐색하기
        boolean[] used = new boolean[puzzle_list.size()];

        for(ArrayList<int[]> target : empty_list){
            for(int j=0; j<puzzle_list.size(); j++){
                if(used[j]) continue;

                ArrayList<int[]> rotated = puzzle_list.get(j);
                boolean matched = false;
                for(int r=0; r<4; r++){
                    if(isSame(target, rotated)){
                        matched = true;
                        break;
                    }
                    rotated = rotate(rotated);
                }

                if(matched){
                    used[j] = true;
                    answer += target.size();
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private ArrayList<int[]> rotate(ArrayList<int[]> list) {

        // 1. 도형의 높이 구하기
        int max = -1;
        for(int[] l : list){
            max = Math.max(max, l[0]);
        }
        int height = max + 1;

        // 2. 새로운 좌표 리스트 생성 및 회전
        ArrayList<int[]> new_list = new ArrayList<>();
        for(int[] l : list){
            new_list.add(new int[] {l[1],height - 1 - l[0]});
        }

        // 3. 회전 후 정규화
        return normalize(new_list);
    }
    
    private boolean isSame(
        ArrayList<int[]> a,
        ArrayList<int[]> b
    ) {
        // 1. 두 도형의 칸 개수 비교
        if(a.size() != b.size()) return false;

        // 2. 각 좌표 비교
        for(int i=0; i<a.size(); i++){
            if(a.get(i)[0] == b.get(i)[0] &&
              a.get(i)[1] == b.get(i)[1]) continue;
            else return false;
        }

        // 3. 모두 같으면 true
        return true;
    }
    
    private ArrayList<int[]> normalize(ArrayList<int[]> list){
        int min_col = 51;
        int min_row = 51;
        for(int[] before: list){
            min_col = Math.min(min_col, before[1]);
            min_row = Math.min(min_row, before[0]);
        }
        
        ArrayList<int[]> result = new ArrayList<>();
        for(int[] before: list){
            result.add(new int[] {before[0]-min_row, before[1]-min_col});
        }
        
        result.sort((a,b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        
        return result;
    }
    
    private static ArrayList<int[]> bfs(
            int y, 
            int x,
            int[][] board,
            boolean[][] isVisited,
            int target){
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {y, x});
        isVisited[y][x] = true;
        
        // 필요한 좌표
        ArrayList<int[]> pos = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            // 좌표 추가하기
            pos.add(new int[] {cur[0], cur[1]});
            
            // 다음 좌표 구하기
            for(int d=0; d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
                if(!isVisited[ny][nx] && board[ny][nx] == target){
                    queue.offer(new int[] {ny,nx});
                    isVisited[ny][nx] = true;
                }
            }
        }
        
        return pos;
        
    }
}