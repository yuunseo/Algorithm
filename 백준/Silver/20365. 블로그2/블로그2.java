/*
1. 연속된 색이 많은 색은 먼저 다 칠해버리고
2. 한개씩 띄엄띄엄 있는 것들은 나중에 하나씩 칠하는 게 더 효율적임

1.1~N개까지 모두 읽으면서, 연속되는 길이가 더 큰 애 구하기

*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] chars = new char[N];
        int idx = 0;
        
        String str = br.readLine();
        String[] blue = str.split("R");
        String[] red = str.split("B");
        
        int blueLen = 0;
        int redLen = 0;
        for(String s: blue){
            if(!s.equals("")) blueLen++;
        }
        for(String s: red){
            if(!s.equals("")) redLen++;
        }
        
        // 더 적은 덩어리를 나중에 칠하기
        if(blueLen < redLen){
            System.out.println(1+blueLen);
            return;
        }else{
            System.out.println(1+redLen);
            return;
        }
        
        
    }
}