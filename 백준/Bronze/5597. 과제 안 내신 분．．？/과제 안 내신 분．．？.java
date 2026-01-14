import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 값을 저장할 자료구조 int 배열 초기화
        int[] int_array = new int[31];
        for(int i=0; i<int_array.length; i++){
            int_array[i] = 0;
        }
        
        // 입력을 통해 자료구조의 인덱스에 맞게 값을 변경(존재하면 1 아니면 0 그대로)
        for(int i=0; i<28; i++){
            int idx = Integer.parseInt(br.readLine());
            int_array[idx] = 1;
        }
        
        // 0인 값을 for문으로 찾아 출력
        for(int i=1; i<int_array.length; i++){
            if(int_array[i]==0){
                System.out.println(i);
            }else{
                continue;
            }
        }
    }
}