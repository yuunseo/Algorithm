/*
지도 1*N, 구사과의 위치는 모름, 각 칸에서 이동 가능한 곳을 다 
DFS로 갈 수 있는 영역의 개수를 구하면 될 것같은데
1. 맨 처음 칸부터 dfs로 연결된 영역을 찾는다
2. 방문 배열도 쓰고, 이전에 한번 갔던 곳을 만날 때 멈추기
3. 다음 한번도 안 들린 땅으로 이동 
 - 만약 다음 칸이 이동했던 땅이라면, 영역 개수 증가 안함
 - 만약 다음 칸이 한번도 안 갔던 땅이라면, 영역 개수 증가+1 && dfs 시작
 - 모든 땅이 방문 했으면 종료
 4. 최종 영역의 개수 출력
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] go = br.readLine().toCharArray();
        
        // 자료구조 초기화
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++){
            visited[i] = false;
        }
        int cnt = 0;
        
        // 영역의 개수 파악
        int idx = 0;
        while(0<=idx && idx<N){
            
            // 다음 땅이 가본 적 없고, 어느 영역과도 연결되어 있지 않으면 새로운 영역 cnt++
            if(!visited[idx]){
                if(go[idx] == 'E' && !visited[idx+1]){
                    cnt++;
                }else if(go[idx] == 'W' && !visited[idx-1]){
                    cnt++;
                }
                // 그런데 다른 영역과 연결되어 있으면 pass
            }
            
            // 그 땅이랑 연결된 땅 구하기
            while(!visited[idx]){
                // 방문하지 않은 땅으로 이동하는 경우, 영역개수 +1
                visited[idx] = true;
                if(go[idx] == 'E'){
                    idx++;
                }else if(go[idx] == 'W'){
                    idx--;
                }
            }
            
            // 다음 땅으로 이동하기
            idx++;
        }
        
        // 모든 땅 다 갔으면 출력
        System.out.println(cnt);
        
        
    }
}