import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 1. 하나씩 입력받아서 List에 추가하기
        List<Integer> numList = new ArrayList<>();
        int N = scanner.nextInt();
        
        for(int i=0; i<N; i++){
            numList.add(scanner.nextInt());
        }
        
        // 2. List에서 정렬하기
        Collections.sort(numList);
        
        // 3. 순서대로 출력하기 (기본이 오름차순)
        for(int i=0; i<numList.size(); i++){
            System.out.println(numList.get(i));
        }
    }
}