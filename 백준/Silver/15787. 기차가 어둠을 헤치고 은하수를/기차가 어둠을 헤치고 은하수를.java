/*
20개의 일렬 좌석
1~N번 기차, M개의 명령
if(i is empty): i[x]=1
if(i is not empty): i[x] = 0
if() 한 칸씩 뒤로 (맨 되는 하차)
if() 한 칸씩 앞으로 (맨 앞은 하차)
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] train = new boolean[N+1][21];
        
        for(int idx=0; idx<M; idx++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            
            
            if(num == 1){
                int x = Integer.parseInt(st.nextToken());
                if(!train[i][x]){
                    train[i][x] = true;
                }
            }else if(num == 2){
                int x = Integer.parseInt(st.nextToken());
                if(train[i][x]){
                    train[i][x] = false;
                }
            }else if(num == 3){
                for(int seat=19; seat>=1; seat--){
                    train[i][seat+1] = train[i][seat];
                }
                train[i][1] = false;

            }else if(num == 4){
                for(int seat=2; seat<=20; seat++){
                    train[i][seat-1] = train[i][seat];
                }
                train[i][20] = false;
            }
            
            
        }
        
        // 은하수 건너기
        Set<String> cnt = new HashSet<>();
        for(int idx=1; idx<=N; idx++){
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<=20; i++){
                sb.append(train[idx][i] ? '1' : '0');
            }
            cnt.add(sb.toString());
        }
        
        System.out.println(cnt.size());
    }
    
}