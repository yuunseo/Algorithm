import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int answer = 0;

    // 열, 대각선 체크 배열
    static boolean[] col;     // 같은 열
    static boolean[] diag1;   // ↘ 대각선 (row + col)
    static boolean[] diag2;   // ↙ 대각선 (row - col + N)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];

        dfs(0); // 0번째 행부터 시작

        System.out.println(answer);
    }

    // row번째 행에 퀸을 놓는 함수
    static void dfs(int row) {
        // 종료 조건: 모든 행에 퀸 배치 완료
        if (row == N) {
            answer++;
            return;
        }

        // 현재 행에서 가능한 열 탐색
        for (int c = 0; c < N; c++) {

            // 놓을 수 없는 경우 skip
            if (col[c] || diag1[row + c] || diag2[row - c + N]) continue;

            // 퀸 배치
            col[c] = true;
            diag1[row + c] = true;
            diag2[row - c + N] = true;

            // 다음 행으로 이동
            dfs(row + 1);

            // 백트래킹 (원상복구)
            col[c] = false;
            diag1[row + c] = false;
            diag2[row - c + N] = false;
        }
    }
}