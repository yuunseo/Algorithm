/*
링크: https://jungol.co.kr/problem/8022
풀이: 
Q. 보물찾기 놀이가 끝나는 단계를 구하세요.
A. 보물을 숨긴 L과 R사이의 S 위치에서 시작한다.
    S를 조사하고, 오른쪽으로 조사, 왼쪽으로 2칸 이동해 조사,..
    이걸 한 단계씩 매번 이동하면 움직일 경우에는  O(100000000*10000000)이라는 매우 복잡도가 클 것 같음.
    짝수단계는 오른쪽으로 이동-
    홀수단계는 왼쪽으로 이동

    R과 3떨어짐 -> 6단계
    L과 2떨어짐 -> x단계-1
    3단계에서는 -1, 5단계에서는 -2, ... 2x-1 단계에서는 x-1번째로 이동할 수 있음
    2단계에서는 +1, 4단계에서는 +2, ... 2x 단계에서는 x번째로 이동할 수 있음
    즉, 왼쪽과 오른쪽의 거리를 구한 후, 더 적은 단계를 선택하면 됨
*/
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            int LDistance = S-L;
            int RDistance = R-S;

            int LStep = 2 * (LDistance+1) -1;
            int RStep = 2 * (RDistance);

            System.out.println(LStep < RStep ? LStep : RStep);
        }
    }
}
