public class Main {
    public static void main(String[] args) {

        boolean[] check = new boolean[10001];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10000; i++) {
            int sum = i;

            // 생성자 계산 (함수 제거)
            for (int x = i; x > 0; x /= 10) {
                sum += x % 10;
            }

            if (sum <= 10000) {
                check[sum] = true;
            }
        }

        // 결과 출력 (StringBuilder 사용)
        for (int i = 1; i <= 10000; i++) {
            if (!check[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }
}