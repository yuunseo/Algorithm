// 한 줄 입력의 경우 바로 br.readline
// 한 줄에 여러 개의 입력이 있다면 st.nextToken

import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        
        // buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input T
        int T = Integer.parseInt(br.readLine());
        
        // loop T - A and B
        int A,B;
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            System.out.println(A+B);
        }
    }
}