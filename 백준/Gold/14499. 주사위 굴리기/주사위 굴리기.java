import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        int x = Integer.parseInt(st.nextToken()); // 세로
        int y = Integer.parseInt(st.nextToken()); // 가로
        int k = Integer.parseInt(st.nextToken()); // 명령의 개수

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); // 지도 초기화
            }
        }

        // 출력용
        StringBuilder sb = new StringBuilder();
        
        int[] dice = new int[6];
        Arrays.fill(dice,0); // 주사위 배열 0으로 초기화

        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};
        st = new StringTokenizer(br.readLine());


        for(int i=0; i<k; i++){
            int pos = Integer.parseInt(st.nextToken());

            int nx = x + dx[pos];
            int ny = y + dy[pos];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            // 이동
            x = nx;
            y = ny;

            // 주사위 회전
            if(pos == 1){ // 동
                int temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
            } else if(pos == 2){ // 서
                int temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
            } else if(pos == 3){ // 북
                int temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
            } else if(pos == 4){ // 남
                int temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
            }

            // 지도 처리
            if(map[x][y] == 0){
                map[x][y] = dice[5];
            } else {
                dice[5] = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice[0]).append("\n");
        }

        // 출력
        System.out.println(sb);
    }
}