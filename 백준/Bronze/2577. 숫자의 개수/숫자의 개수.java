/*
1. A*B*C한 값을 문자열로 저장하기
2. for(int i=0; i<10) 돌면서, 문자열에서 몇 개 있는지 count()
3. 그대로 출력
*/
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 1. A, B, C 입력
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int target = A*B*C;
        String targetString = String.valueOf(target);
        
        // 2. for문 돌면서 0부터 9까지 개수 찾기
        for(int i=0; i<10; i++){
            char digit = (char) (i+'0');
            int cnt = 0;
            for(int j=0; j<targetString.length();j++){
                if(targetString.charAt(j) == digit){
                    cnt++;
                }
            }
            // 각각 cnt 출력
            System.out.println(cnt);
        }
    }
}