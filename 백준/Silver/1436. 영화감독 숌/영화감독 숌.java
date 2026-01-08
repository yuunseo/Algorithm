/*
최소 666 이상 연속으로 들어가는 문자열 -> 종말의 수
666,1666,2666,3666,4666,5666,
6666 vs 6660 > 6660
6661
6662
6663
. . .
직접 세기 위해서는 N번째에 맞는 수를 찾아야 하는데 매번 직접 세면 10,000번 걸림(충분함)
*/

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        int idx = 665;
        while(cnt < N){
            idx++;
            if(String.valueOf(idx).contains("666")){
                cnt++;
            }
            
        }
        
        System.out.println(idx);
        
    }
}