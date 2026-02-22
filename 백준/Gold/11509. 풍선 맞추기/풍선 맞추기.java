import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 현재 각 높이에 있는 "화살 수"를 저장할 배열
        int[] arrows = new int[1_000_001];
        
        int result = 0;
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            // 현재 풍선을 맞출 수 있는 화살이 이미 있다면
            if (arrows[h] > 0) {
                arrows[h]--;
                // 풍선을 맞췄으므로 화살은 h-1 위치로 이동
                if (h - 1 >= 0) {
                    arrows[h - 1]++;
                }
            } else {
                // 화살이 없으면 새로운 화살 필요
                result++;
                if (h - 1 >= 0) {
                    arrows[h - 1]++;
                }
            }
        }
        
        System.out.println(result);
    }
}