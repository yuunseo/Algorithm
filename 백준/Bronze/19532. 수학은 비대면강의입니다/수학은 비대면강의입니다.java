/*
하나의 방정식으로 합쳐서, 성립되는 x와 y 찾기
*/

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 1. abcdef 입력받기
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        scanner.close();
        
        // 2. 연립방정식 공식
        int denominator = a * e - b * d; // 분모
        int x = (c * e - b * f) / denominator;
        int y = (a * f - c * d) / denominator;
        
        // 3. 결과 출력
        System.out.println(x + " " + y);
        
        
        
    }
}