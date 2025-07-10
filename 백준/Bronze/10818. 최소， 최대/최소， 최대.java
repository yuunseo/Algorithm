import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine();
        String[] numStringList = scanner.nextLine().split(" ");
        List<Integer> numList = Arrays.stream(numStringList).map(Integer::parseInt).collect(Collectors.toList());
        
        int max, min;
        max = Collections.max(numList);
        min = Collections.min(numList);
        
        System.out.print(min+" "+max);
    
    }
}