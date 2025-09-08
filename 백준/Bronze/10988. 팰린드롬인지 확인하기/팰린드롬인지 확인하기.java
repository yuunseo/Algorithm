import java.util.Scanner;

/*
1. 소문자로만 주어진 단어 -> 팰린드롬 확인하기(1,0)
2. 투 포인터를 이용해서, 비교하기

*/

class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 1. input string initialization
        String word = scanner.nextLine();
        
        // 2. two pointer 생성하기
        int pt1 = 0;
        int pt2 = word.length()-1;
        
        // 3. two pointer 비교하기
        while(pt1 <= pt2){
            // 3-1. 서로 가리키는 문자가 동일하다면, 다음 인덱스로 이동
            if(word.charAt(pt1) == word.charAt(pt2)){
                pt1 += 1;
                pt2 -= 1;
            }else{
                // 3-2. 서로 가리키는 문자가 다르다면, 0 반환
                System.out.println(0);
                return;
            }
        }
        
        // 3-3. 서로 인덱스가 동일해지면, 팰린드롬 1 반환
        System.out.println(1);
    }
    
}