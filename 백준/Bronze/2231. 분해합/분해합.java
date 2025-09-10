/*
123 : 자연수 M (N의 생성자, 없거나 여러 개일 수 있음, 가장 작은 생성자를 구하자.)
123+1+2+3 : 129 : 자연수 M의 분해합 N
=> 자연수 N의 가장 작은 생성자 출력 (현재 내가 되기까지 어떤 자릿수와 숫자를 합쳤는지 그 원래 숫자를 구하는 거.)
=> 분해합으로부터 원본을 찾아내야 하는데, 아이디어가 떠오르지 않는다..
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 자연수(분해합) N 입력 (생성자인 M은 N보다 작음)
        int N = scanner.nextInt();
        scanner.close();

        // 2. 1부터 N까지 모든 수 확인해서 생성자 M 구하기
        for (int M = 1; M <= N; M++) {
            int sum = M;
            int temp = M;

            // M의 각 자리수를 sum에 더하기
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            // 분해합이 N이면 M 출력
            if (sum == N) {
                System.out.println(M);
                return; // 가장 작은 M 찾으면 끝
            }
        }

        // 없으면 0 출력
        System.out.println(0);
    }
}
