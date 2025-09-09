import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/*
전공 평점을 계산하는 프로그램
전공 평점 = (학점 * 과목 평점)/전공과목의 총합
P는 제외
*/
class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 0. 학점별 점수 넣어두기
        Map<String, Float> scores = new HashMap<>();
        scores.put("A+", 4.5f);
        scores.put("A0", 4.0f);
        scores.put("B+", 3.5f);
        scores.put("B0", 3.0f);
        scores.put("C+", 2.5f);
        scores.put("C0", 2.0f);
        scores.put("D+", 1.5f);
        scores.put("D0", 1.0f);
        scores.put("F", 0.0f);
        
        // 1. 20개의 과목 하나씩 점수 확인하기
        int cnt = 20;
        float total = 0;
        float totalNum = 0;
        for(int i = 0; i < 20; i++){
            String[] parts = scanner.nextLine().split(" ");
            float num = Float.parseFloat(parts[1]);
            String score = parts[2];
            
            if(score.equals("P")) continue;
            
            total += num * scores.get(score);
            totalNum += num;
        }
        
        // 2. 평균값 계산
        System.out.printf("%.6f\n", total/totalNum);
        
        
    }
}