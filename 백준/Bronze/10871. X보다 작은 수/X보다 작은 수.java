import java.util.Scanner;
import java.util.Arrays;

public class Main{
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int N,X;
        String[] list1 = scanner.nextLine().split(" ");
        N = Integer.parseInt(list1[0]); X = Integer.parseInt(list1[1]);
        
        String[] list2 = scanner.nextLine().split(" ");
		Arrays.stream(list2).map(Integer::parseInt).filter(n -> n<X).forEach(n->System.out.print(n+" "));
        
        
        
    }
}