/*
소 위치 N번 관찰 (소의 번호, 소의 위치)
총 10마리
위치는좌0우1
즉, 소의 위치가 바뀐 횟수 구하기
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 소 위치 초기화
        int[] cows = new int[10];
        for(int i=0; i<10; i++){
            cows[i] = 9;
        }
        // 소 위치 확인
        int count = 0;
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken()) - 1;
            int pos = Integer.parseInt(st.nextToken());
            
            // 소가 처음 움직이는가?
            if(cows[cow] == 9){
                cows[cow] = pos;
                continue;
            }
            
            // 소가 이전 위치와 다른가?
            if(cows[cow] != pos){
                count ++;
                cows[cow] = pos;
            }
        }
        
        System.out.println(count);
    }
}