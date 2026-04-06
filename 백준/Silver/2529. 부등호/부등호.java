import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        Stack<Integer> max_stack = new Stack<>();
        Stack<Integer> min_stack = new Stack<>();

        int max_start = 9;
        int min_start = 0;

        // 핵심: i <= k 까지 돈다 (숫자는 k+1개)
        for(int i = 0; i <= k; i++){
            
            // 항상 push 먼저
            max_stack.push(max_start--);
            min_stack.push(min_start++);

            // 구간 끝이면 pop
            if(i == k || arr[i].equals(">")){
                while(!max_stack.isEmpty()){
                    max.append(max_stack.pop());
                }
            }

            if(i == k || arr[i].equals("<")){
                while(!min_stack.isEmpty()){
                    min.append(min_stack.pop());
                }
            }
        }

        System.out.println(max.toString());
        System.out.println(min.toString());
    }
}