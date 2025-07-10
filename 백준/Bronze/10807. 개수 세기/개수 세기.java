import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine();  // ← 개행 문자 제거
        
        String[] numList = scanner.nextLine().split(" ");
        
        String v = scanner.next(); // 찾고 싶은 값 입력
        
        int cnt = 0;
        
        for (int i = 0; i < N; i++) {
            if (numList[i].equals(v)) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}
