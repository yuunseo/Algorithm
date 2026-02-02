import java.util.*;
import java.io.*;

class Main{
    
    static char[][] explode(char[][] map, int R, int C){
        // 폭탄 터진 후, 빈 곳은 다시 폭탄으로 채우기 때문에
        // 폭탄으로 채운 배열에서 시작
        char[][] next = new char[R][C];
        for(int i=0; i<R; i++){
            Arrays.fill(next[i], 'O');
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                // 폭탄을 빈땅으로 바꾸고, 인접 땅 모두 변환
                if (map[y][x] == 'O') {
                    next[y][x] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];
                        if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                            next[ny][nx] = '.';
                        }
                    }
                }
            }
        }
        return next;
        
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 변수 초기화
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        // 초기 map 초기화
        char[][] map = new char[R][C];
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        
        // N초간의 진행상황
        if(N==1){
            print(map); return;
        }
        
        if(N%2 == 0){
            char[][] full = new char[R][C];
            for(int i=0; i<R; i++){
                Arrays.fill(full[i], 'O');
            }
            print(full);
            return;
        }
        
        char[][] once = explode(map, R, C);
        
        if(N%4 == 3){
            print(once);
        }else{
            char[][] twice = explode(once, R, C);
            print(twice);
        }
    }
    
    static void print(char[][] map){ // 최종 결과 출력
        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            sb.append(row).append('\n');
        }
        System.out.println(sb);
    }
}