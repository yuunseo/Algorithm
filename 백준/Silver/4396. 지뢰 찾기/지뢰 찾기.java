/*
n*n개 중 m개의 지뢰가 존재함
*를 발견하면 lose, 0을 발견하면 상하좌우대각선 중 지뢰의 개수 공개
x, 즉 열리지 않은 칸을 모두 열었을 때의 결과를 출력하기
재방문 할 일은 없고, 지뢰를 검사하는 거라서 재방문을 해야되는 상황.
따라서 for문을 돌면서 char[][] 순회함과 동시에, 현재 Idx에서의 상하좌우, 대각선 검사 필요
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        // 기존 맵
        char[][] maps = new char[n][n];
        for(int i=0; i<n; i++){
            maps[i] = br.readLine().toCharArray();
        }
        
        // 플레이 맵
        char[][] plays = new char[n][n];
        for(int i=0; i<n; i++){
            plays[i] = br.readLine().toCharArray();
        }
        
        // 지뢰 개수 맵
        char[][] mines = new char[n][n];
        
        // 승패
        boolean lose = false;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // 승패 확인하기
                if(plays[i][j] == 'x' && maps[i][j] == '*'){
                    lose=true;
                }
                
                if(plays[i][j] == 'x' && maps[i][j] == '.'){
                    // 지뢰 개수 확인하기
                    mines[i][j] = (char)(checkMine(i, j, maps, n) + '0');
                }else{
                    mines[i][j] = maps[i][j];
                }
            }
        }
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(plays[i][j] == 'x'){
                    // 플레이어가 오픈하는 땅 중에서, 지뢰라면 공개 아니면 개수 공개
                    if(maps[i][j] == '*'){
                        System.out.print('*');
                    }else{
                        System.out.print(mines[i][j]);
                    }
                }else{
                    // 이미 열린 땅 혹은 지뢰 중에서, 진 게임이라면 지뢰 공개
                    // 아니라면 땅 그대로 공개 .
                    if(lose && maps[i][j] == '*'){
                        System.out.print('*');
                    }else{
                        System.out.print('.');
                    }
                }
            }
            System.out.println();
        }
    }
    
    private static int checkMine(int y, int x, char[][] maps, int n){
        int cnt = 0;
        int[] dx = {-1,0,1,1,1,0,-1,-1};
        int[] dy = {-1,-1,-1,0,1,1,1,0};
        
        for(int d=0; d<8; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            
            if(0<=nx && nx<n && 0<=ny && ny<n){
                if(maps[ny][nx] == '*') cnt++;
            }
        }
        
        return cnt;
    }
}