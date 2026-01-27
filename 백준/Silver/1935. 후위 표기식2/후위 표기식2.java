/*
후기표위식:
피연산자 → stack에 push
연산자 → 숫자 2개 pop해서 계산 후 push
*/

import java.util.*;
import java.io.*;

class Main{
    static double operation(double a, double b, char op){
        switch(op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                return 0;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String formula = br.readLine();
        
        Stack<Double> stack = new Stack<>();
        
        // 숫자를 순서대로 저장
        double[] values = new double[N];
        for(int i = 0; i < N; i++){
            values[i] = Double.parseDouble(br.readLine());
        }
        
        for(int i=0; i<formula.length(); i++){
            char c = formula.charAt(i);
            if('A' <= c && c <= 'Z'){
                stack.push(values[c-'A']); // 저장한 숫자 값과 알파벳 매칭
            }
            else{
                double b = stack.pop();
                double a = stack.pop();
                stack.push(operation(a,b,c));
            }
                
        }
        
        System.out.printf("%.2f\n", stack.pop());
        
    }
}