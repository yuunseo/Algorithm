import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int answer = Integer.MAX_VALUE; // 출력값
    static boolean[] visited;
    static int[][] S;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // N
        
        S = new int[N+1][N+1]; // S 배열 초기화
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // DFS로 2개의 팀으로 나누는 모든 경우의 수 구하기
        visited = new boolean[N+1]; 
        dfs(1, 0);
        
        

        // 출력: |스타트팀의 능력치 - 링크 팀의 능력치|의 최솟값
        System.out.print(answer);
    }
    
    /*
    dfs(int index, int count)
    - index: 팀을 결정해야 하는 사람의 인덱스
    - count: 지금까지 팀이 결정된 사람의 인원 수 (dfs에서는 하나의 팀 생성)
    */
    static void dfs(int index, int count){
        if(count == N/2){
            // 현재 꾸려진 팀으로 능력치 계산하기
            int start = 0;
            int link = 0;
            for(int i=1; i<=N; i++){
                for(int j=i+1; j<=N; j++){
                    if(visited[i] && visited[j]) start += S[i][j] + S[j][i];
                    else if(!visited[i] && !visited[j]) link += S[i][j] + S[j][i];
                }
            }
            // 능력치의 차이를 answer에 갱신하기
            answer = Math.min(answer, Math.abs(start-link));
            return;
        }
        
        for(int i=index; i<N; i++){
            if(!visited[i]){
                visited[i] = true; // 하나의 팀으로 선택
                dfs(i+1, count+1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}