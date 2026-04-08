import java.io.*;
import java.util.*;

public class Main {

    static class Robot{
        int x,y,dir;
        Robot(int y, int x, String dir){
            this.x=x; this.y=y;
            switch(dir){ // 동 북 서 남 0 1 2 3
                case "E":
                    this.dir = 0; break;
                case "N":
                    this.dir = 1; break;
                case "W":
                    this.dir = 2; break;
                case "S":
                    this.dir = 3; break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 세로

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 로봇의 개수
        int M = Integer.parseInt(st.nextToken()); // 명령의 개수

        Robot[] robots = new Robot[N+1]; // 로봇 번호와 로봇의 위치 저장
        int[][] map = new int[B][A];
        for(int i=0; i<B; i++){
            Arrays.fill(map[i],0);
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            map[B-y][x-1] = i;
            robots[i] = new Robot(B-y, x-1, dir);
        }

        // 방향 배열 (E-N-W-S)
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String next_dir = st.nextToken();
            int iter = Integer.parseInt(st.nextToken());

            // 로봇 좌표 불러오기
            int x = robots[num].x;
            int y = robots[num].y;
            int dir = robots[num].dir;

            // 로봇 새로운 이동 실행
            if(next_dir.equals("F")){ // 원래 방향으로 직진
                for(int j=0; j<iter; j++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if(nx<0 || ny<0 || nx>=A || ny>=B){
                        System.out.println("Robot "+num+" crashes into the wall");
                        return;
                    }
                    if(map[ny][nx]!=0){
                        System.out.println("Robot "+num+" crashes into robot "+map[ny][nx]);
                        return;
                    }
                    // 로봇 위치 갱신
                    map[y][x] = 0;
                    x = nx;
                    y = ny;
                    map[ny][nx] = num;
                }
            }else if(next_dir.equals("L")){ // 왼쪽으로 방향 전환
                for(int j=0; j<iter; j++){
                    dir = (dir+1)%4;
                }
            }else if(next_dir.equals("R")){ // 오른쪽으로 방향 전환
                for(int j=0; j<iter; j++){
                    dir = dir==0 ? 3 : dir-1;
                }
            }

            robots[num].x = x;
            robots[num].y = y;
            robots[num].dir = dir;
        }



        // 문제가 없으면 OK 출력
        System.out.print("OK");
    }
}