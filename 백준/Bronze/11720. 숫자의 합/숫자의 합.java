import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String nums = scanner.next();
        int answer = 0;
        
        for(int i=0; i<nums.length(); i++){
            answer += nums.charAt(i)-'0';
        }
        System.out.println(answer);
    }
}