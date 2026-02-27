import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 판 크기 입력
        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 스티커 개수
        int N = Integer.parseInt(br.readLine());
        int[][] sticker = new int[N][2];

        // 스티커 크기 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sticker[i][0] = Integer.parseInt(st.nextToken()); // 높이
            sticker[i][1] = Integer.parseInt(st.nextToken()); // 너비
        }
        
        int answer = 0;
        
        for(int i=0; i<N-1; i++){
            int sum =0;
            for(int j=i+1; j<N; j++){
                // 첫 번째 스티커 회전 여부
                for (int r1 = 0; r1 < 2; r1++) {
                    int h1 = (r1 == 0) ? sticker[i][0] : sticker[i][1];
                    int w1 = (r1 == 0) ? sticker[i][1] : sticker[i][0];

                    // 두 번째 스티커 회전 여부
                    for (int r2 = 0; r2 < 2; r2++) {
                        int h2 = (r2 == 0) ? sticker[j][0] : sticker[j][1];
                        int w2 = (r2 == 0) ? sticker[j][1] : sticker[j][0];

                        // 1. 가로로 나란히 배치
                        if (h1 <= H && h2 <= H && w1 + w2 <= W) {
                            answer = Math.max(answer, h1 * w1 + h2 * w2);
                        }

                        // 2/ 세로로 나란히 배치
                        if (w1 <= W && w2 <= W && h1 + h2 <= H) {
                            answer = Math.max(answer, h1 * w1 + h2 * w2);
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
        
        
    }
}