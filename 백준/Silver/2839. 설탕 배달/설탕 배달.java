/*
더 적은 봉지로 N그램 설탕 가져가기
1. BFS처럼, 5그램으로 넣을 때 3그램으로 넣ㅇ을 때를 기억하면서
2. 총합이 N이면서 봉지가 최소인 걸 구해야함!

i = 5그램의 개수
j = 3그램의 개수
[i][j] = 총 그램의 합계
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 가능한 개수 조합 배열 채우기
        int[][] sweet = new int[N][N]; 
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sweet[i][j] = i*5 + j*3;
                
                if(sweet[i][j] == N){
                    pq.add(i+j);
                }
            }
        }
        
        // 최소의 봉지 개수 구하기
        if(pq.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(pq.poll());
        }
        
        
    }
}