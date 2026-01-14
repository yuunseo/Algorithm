import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 최소, 최댓값 초기화
            int min = Integer.MAX_VALUE;
            int max =Integer.MIN_VALUE;
            
            // N번 순회하면서 min, max 갱신
            for(int j=0; j<N; j++){
                int x = Integer.parseInt(st.nextToken());
                min = Math.min(x,min);
                max = Math.max(x,max);
            }
            
            // queue의 맨 처음과 뒤 (최소, 최대) 값을 출력
            System.out.println(min + " "+ max);
            
        }
    }
}