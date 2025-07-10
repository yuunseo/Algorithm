import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int N,X;
        String[] list1 = scanner.nextLine().split(" ");
        N = Integer.parseInt(list1[0]); X = Integer.parseInt(list1[1]);
        
        String[] list2 = scanner.nextLine().split(" ");
                
        for(int i=0; i<N; i++){
            if(Integer.parseInt(list2[i]) < X){ // 문자열이지만, 아스키코드로 크기 비교 가능
                System.out.print(list2[i]+" ");
            }
        }
        
        
        
    }
}