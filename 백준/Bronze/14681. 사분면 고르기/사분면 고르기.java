import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int answer = 0;
        
        // 사분면 나누기
        if(x>0 && y>0){
            answer = 1;
        }else if(x>0 && y<0){
            answer = 4;
        }else if(x<0 && y>0){
            answer = 2;
        }else{
            answer = 3;
        }
        
        System.out.print(answer);
    
    
    }
}