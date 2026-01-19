/*
stack에 넣어서 quack을 하나의 오리로 count하기 (X)
stack이 아닌, 단계별 존재하는 오리의 개수를 구해야함.
즉, 단계별 int[] 배열에 ++ 하는 방식으로 실행하기.
포인트: 방에 있을 수 있는, 동시에 있을 수 있는 오리의 최소의 수를 구하는 것임!
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        
        int answer = 0;
        int[] ducks = new int[5]; // q u a c k
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == 'q'){
                ducks[0] ++;
            }else if(c == 'u'){
                if(ducks[0] == 0) {System.out.println(-1); return;}
                ducks[0]--; ducks[1]++;
            }else if(c == 'a'){
                if(ducks[1] == 0) {System.out.println(-1); return;}
                ducks[1]--; ducks[2]++;
            }else if(c == 'c'){
                if(ducks[2] == 0) {System.out.println(-1); return;}
                ducks[2]--; ducks[3]++;
            }else if(c == 'k'){
                if(ducks[3]==0) {System.out.println(-1); return;}
                ducks[3]--; // 오리 한 마리 종료
            }
            
            int current = ducks[0] + ducks[1] + ducks[2] + ducks[3];
            answer = Math.max(answer, current);
        }
        
        for(int i=0; i<4; i++){
            if(ducks[i] != 0){
                System.out.println(-1);
                return;
            }
        }
        
        System.out.println(answer);
    }
}