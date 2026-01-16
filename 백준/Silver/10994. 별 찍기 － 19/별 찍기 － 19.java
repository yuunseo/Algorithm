import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int size = 4 * num - 3;
        StringBuilder sb = new StringBuilder();  
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                // d란, 네 방향 중 테두리를 가장 빨리 만나는 칸 수
                // 즉, d라는 거리란 테두리까지의 거리이자 겹 수(1이라면 안으로 1겹째)
                int d = Math.min(Math.min(i,j),Math.min(size-1-i, size-1-j));
                // 짝수라면 * 홀수라면 공백 (홀수 겹째에서는 모두 공백!)
                if(d%2==0){
                    sb.append('*');
                }else{
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
         System.out.print(sb);
    }
}