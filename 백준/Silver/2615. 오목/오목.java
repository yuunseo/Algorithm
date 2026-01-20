/*
직선 탐구 문제 (그래프 문제 아님 주의 !)
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방향: 오른쪽, 아래, 오른쪽 위 대각선, 오른쪽 아래 대각선
        int[] dx = {1, 0, 1, 1};
        int[] dy = {0, 1, -1, 1};

        String[][] board = new String[19][19];

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = st.nextToken();
            }
        }

        for (int y = 0; y < 19; y++) {
            for (int x = 0; x < 19; x++) {
                String stone = board[y][x];
                if (stone.equals("0")) continue;

                for (int d = 0; d < 4; d++) {
                    int py = y - dy[d];
                    int px = x - dx[d];

                    // 이전 칸에 같은 돌이 있으면 시작점 아님
                    if (0 <= py && py < 19 && 0 <= px && px < 19) {
                        if (board[py][px].equals(stone)) continue;
                    }

                    int cnt = 1;
                    int cy = y;
                    int cx = x;

                    while (true) {
                        cy += dy[d];
                        cx += dx[d];

                        if (cx < 0 || cx >= 19 || cy < 0 || cy >= 19) break;
                        if (!board[cy][cx].equals(stone)) break;

                        cnt++;
                    }

                    // 정확히 5개인지 확인
                    if (cnt == 5) {
                        int ny = cy;
                        int nx = cx;

                        // 다음 칸에 같은 돌 있으면 장목
                        if (0 <= ny && ny < 19 && 0 <= nx && nx < 19) {
                            if (board[ny][nx].equals(stone)) continue;
                        }

                        System.out.println(stone);
                        System.out.println((y + 1) + " " + (x + 1));
                        return;
                    }
                }
            }
        }

        // 승부가 안 난 경우
        System.out.println(0);
    }
}
