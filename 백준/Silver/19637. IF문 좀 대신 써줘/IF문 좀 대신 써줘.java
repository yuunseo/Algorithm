import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 칭호 초기화
        int[] power = new int[N];
        String[] title = new String[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }
        
        // 캐릭터 전투력 초기화
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(br.readLine());
            
            int left = 0;
            int right = N-1;
            
            while(left < right){
                int mid = (left+right)/2;
                
                if(power[mid] >= num){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            
            sb.append(title[left]).append("\n");
            
        }
        
        // 결과 출력
        System.out.println(sb);
        
    }
}