/*
bfs로 상하좌우위아래 판별
*/

import java.util.*;
import java.io.*;

class Main{

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[] dh = {1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        // map
        int[][][] tomatos = new int[H][N][M];
        int nonTomatos = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    int cur = Integer.parseInt(st.nextToken());
                    if(cur == 0) nonTomatos ++;
                    if(cur == 1) q.add(new int[] {h,i,j,0});
                    tomatos[h][i][j] = cur;
                }
            }
        }

        // 계산하기
        int days = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            days = Math.max(days, cur[3]);

            // 인접 토마토 점검 - 상하좌우
            for(int d=0; d<4; d++){
                int ny = cur[1] + dy[d];
                int nx = cur[2] + dx[d];

                if(nx<0 || nx>=M || ny<0 || ny>=N) continue;

                if(tomatos[cur[0]][ny][nx] == 0){
                    tomatos[cur[0]][ny][nx] = 1;
                    nonTomatos --;
                    q.add(new int[] {cur[0],ny,nx, cur[3]+1});
                }
            }

            // 인접 토마토 점검 - 위아래
            for(int h=0; h<2; h++){
                int nh = cur[0] + dh[h];

                if(nh<0 || nh>=H) continue;

                if(tomatos[nh][cur[1]][cur[2]] == 0){
                    tomatos[nh][cur[1]][cur[2]] = 1;
                    nonTomatos --;
                    q.add(new int[] {nh,cur[1],cur[2], cur[3]+1});
                }
            }
        }
        // 결과 출력
        if(nonTomatos>0){
            System.out.println(-1);
        }else{
            System.out.println(days);
        }
    }

}