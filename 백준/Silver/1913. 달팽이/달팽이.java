/*
맵, 좌표같은 문제라면, 방향 배열을 활용하기
- 상 우 하 좌 
int[] dx = {0, 1, 0, -1}
int[] dy = {-1, 0, 1, 0}
- 방향 바꾸는 횟수
1번 가고 방향, 1번 가고 방향, 
2번 가고 방향, 2번 가고 방향, 
...
N-1번 가고 방향, N-1번 가고 방향,
N번 가는 중, N^2 만나면 stop

*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 3~999
        scanner.nextLine();
        int target = scanner.nextInt(); // N^2 이하 자연수
        StringBuilder sb = new StringBuilder();
        
        // 1. 표 출력
        int[][] maps = new int[N][N];
        int x = N/2;
        int y = N/2;
        int num = 1;
        maps[y][x] = num;
        int step = 1;
        int dir = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        
        // target이 1인 경우
        if (num == target) {
            sb.append((y + 1) + " " + (x + 1));
        }
        
        while(num != N*N){
            // 같은 스텝으로 2번 이동 및 방향 전환
            
            for(int i=0; i<2; i++){
                // step칸 이동
                for(int j=0; j<step && num<N*N; j++){
                    x += dx[dir];
                    y += dy[dir];
                    // +1값 대입
                    num++;
                    maps[y][x] = num;
                    
                    // target 찾기
                    if(num == target){
                        sb.append((y+1)+" "+(x+1));
                    }
                   
                }
                // 방향 전환
                dir = (dir + 1) % 4;
            }
            step++;

        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(maps[i][j]+" ");
            }
            System.out.println();
        }
  
        // 2. target의 좌표
        System.out.println(sb);
        
    }
}