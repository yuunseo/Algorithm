/*
최소 동전 개수, 2원과 5원
1. 큰 값으로 최대한 나누고 남은만큼 2원으로 채우기
2. 2로 채워지지 않으면, 5원으로 나눈 개수를 하나씩 줄이고 2원을 늘려서 맞추기
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 로직 작성
        int five = N/5;
        while (five >= 0) {
            int remain = N - (five * 5);

            if (remain % 2 == 0) {
                int two = remain / 2;
                System.out.println(five + two);
                return;
            }
            five--;
        }

        System.out.println(-1);
    }
}
