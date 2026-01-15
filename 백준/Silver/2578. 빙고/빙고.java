import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 빙고판
        int[][] maps = new int[26][2]; // 1~25개의 수의 좌표를 넣을 수 있도록
        // 정답 체크판
        int[] row = new int[6];
        int[] col = new int[6];
        int[] diag = new int[3];
        
        for(int i=1; i<=5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1 ;j<=5; j++){
                int num = Integer.parseInt(st.nextToken());
                maps[num][0] = i;
                maps[num][1] = j;
                
            }
        }
        
        // 개수 카운트
        int cnt = 0;
        
        // 사회자가 부르는 수 
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ;j<5; j++){
                cnt++;
                int num = Integer.parseInt(st.nextToken());  
                int r = maps[num][0];
                int c = maps[num][1];
                row[r]++;
                col[c]++;
                if(r==c){ // 인덱스가 동일한 칸은 대각선 칸임
                    diag[1]++;
                }
                if(r+c == 6){
                    diag[2]++;
                }
                
                int bingo = 0;
                for(int k=1; k<=5; k++){
                    if(row[k]==5) bingo++;
                    if(col[k]==5) bingo++;
                }
                if(diag[1]==5) bingo++;
                if(diag[2]==5) bingo++;
            
                if(bingo>=3){
                    System.out.println(cnt);
                    return;
                }
            }
            
            
        }
        
        
        
    }
}