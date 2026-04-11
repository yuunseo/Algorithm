public class Main {

    public static void main(String[] args) {
        boolean[] check = new boolean[10001];

        // 1부터 10000까지 생성자 계산
        for (int i = 1; i <= 10000; i++) {
            int num = d(i);

            if (num <= 10000) {
                check[num] = true;
            }
        }

        // 생성되지 않은 수(셀프 넘버) 출력
        for (int i = 1; i <= 10000; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }

    // 생성자 함수
    public static int d(int n) {
        int sum = n;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}