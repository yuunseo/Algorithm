/*
N개의 돌을 2명이 번갈아가면서 가져간다 1개 혹은 3개씩
마지막 돌을 가져가는 사람이 이긴다
상근이가 먼저, 이기는 사람은 누굴까?


N==1, SK
N==2, CY
N==3, SK
N==4, CY
N==5, SK
N==6, CY
N==7, SK
이렇게 서로 번갈아가면서 이기게 됨
즉, N%2 -> 1 SK, N%2 -> 0 CY
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        System.out.println((N%2 == 1 ? "SK" : "CY"));
        
        
    }
}