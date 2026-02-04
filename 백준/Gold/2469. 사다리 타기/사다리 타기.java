import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());

        // 최종 결과 문자열
        String finalOrder = br.readLine().trim();

        // 사다리 전체 저장
        String[] ladder = new String[n];
        int unknownIdx = -1;  // '?' 라인의 인덱스

        for (int i = 0; i < n; i++) {
            ladder[i] = br.readLine().trim();
            if (ladder[i].charAt(0) == '?') {
                unknownIdx = i;
            }
        }

        // 1) 초기 순서는 A, B, C, ...
        char[] topDown = new char[k];
        for (int i = 0; i < k; i++) {
            topDown[i] = (char)('A' + i);
        }

        // 위쪽(? 이전) 사다리를 내려간다
        for (int i = 0; i < unknownIdx; i++) {
            topDown = simulateLine(topDown, ladder[i]);
        }

        // 2) finalOrder 상태에서 아래쪽을 올라간다
        char[] bottomUp = finalOrder.toCharArray();

        for (int i = n - 1; i > unknownIdx; i--) {
            bottomUp = simulateLine(bottomUp, ladder[i]);
        }

        // 3) ? 라인 구성
        char[] result = new char[k - 1];
        boolean possible = true;

        for (int i = 0; i < k - 1; i++) {
            if (topDown[i] == bottomUp[i]) {
                result[i] = '*';
            } else if (topDown[i] == bottomUp[i + 1] &&
                       topDown[i + 1] == bottomUp[i]) {
                result[i] = '-';
                // swap topDown so further positions adjust
                char tmp = topDown[i];
                topDown[i] = topDown[i + 1];
                topDown[i + 1] = tmp;
            } else {
                possible = false;
                break;
            }
        }

        if (!possible) {
            // 불가능한 경우 x 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k - 1; i++) sb.append("x");
            System.out.println(sb.toString());
            return;
        }

        // 검증: 완성된 ? 줄로 전체 사다리를 다시 타본다
        char[] check = new char[k];
        for (int i = 0; i < k; i++) check[i] = (char)('A' + i);

        for (int i = 0; i < n; i++) {
            if (i == unknownIdx) check = simulateLine(check, new String(result));
            else check = simulateLine(check, ladder[i]);
        }

        if (!new String(check).equals(finalOrder)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k - 1; i++) sb.append("x");
            System.out.println(sb.toString());
        } else {
            System.out.println(new String(result));
        }
    }

    // 사다리 한 줄을 타는 시뮬레이션 (swap 처리)
    public static char[] simulateLine(char[] arr, String line) {
        char[] newArr = arr.clone();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '-') {
                char tmp = newArr[i];
                newArr[i] = newArr[i + 1];
                newArr[i + 1] = tmp;
                i++; // 한 번 swap 이면 다음 위치 건너뛴다
            }
        }
        return newArr;
    }
}
