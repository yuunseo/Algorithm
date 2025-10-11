import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        // buffred reader로 한 줄씩 읽어오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            if(A==0 && B==0){
                break;
            }else{
                System.out.println(A+B);
            }
        }
        
    }
}