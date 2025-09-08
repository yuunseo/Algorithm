import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 1. word 불러오기
        String word = scanner.next();
        
        // 2. 알파벳-크로아티아 문자 치환하기
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(String c: croatia){
            word = word.replace(c,"X");
        }
        
        // 3. 최종 글자수 반환하기
        System.out.println(word.length());
        
    }
    
}