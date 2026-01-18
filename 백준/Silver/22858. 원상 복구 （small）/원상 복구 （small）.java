/*
숫자 P1,...,PN, 카드는 총 N개
수열 D1,...,DN
Di번째 카드를 i번째로 이동하기 = 셔플
K번 셔플한 카드의 정보 & D의 정보
원래 카드의 배치를 구하시오

내가 놓친 것
- 역순으로 가야 하는데 
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //카드 개수 N과 셔플한 횟수 K
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // K번 셔플한 후 카드 배치 배열
        st = new StringTokenizer(br.readLine());
        int[] S = new int[N+1];
        for(int i=1; i<=N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }
        
        // 수열 D 배열
        st = new StringTokenizer(br.readLine());
        int[] D = new int[N+1];
        for(int i=1; i<=N; i++){
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = new int[N+1];
        for(int cnt=0; cnt<K; cnt++){
            
            // 셔플 1사이클에 따른 동작 
            for(int i=1; i<=N; i++){
                int card = S[i];
                temp[D[i]] = card;
            }
            System.arraycopy(temp, 1, S, 1, N);
        }
        
        // 정답 출력
        for(int i=1; i<=N; i++){
            System.out.print(S[i]+" ");
        }
        
    }
}