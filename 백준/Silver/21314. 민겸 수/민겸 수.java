/*
가장 큰 수: 연속된 M의 개수가 많을수록 좋음 + K랑 붙을 수 있으면 붙는게 더 큼
가장 작은 수: 떨어뜨릴 수 있는 모든 M과 K는 분리하기.
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        // 입력
        String str = br.readLine();
        int len = str.length();

        // 최댓값 찾기
        int countM = 0;
        StringBuilder max = new StringBuilder();

        for(int i=0; i<len; i++){
            if(str.charAt(i) == 'M'){
                countM ++;
            }else{
                max.append("5");
                for(int j=0; j<countM; j++){
                    max.append("0");
                }
                countM =0;
            }
        }

        for(int i=0; i<countM; i++){
            max.append("1");
        }

        // 최솟값 찾기
        StringBuilder min = new StringBuilder();
        countM = 0;
        for(int i=0; i<len; i++){
            if(str.charAt(i) == 'M'){
                countM ++;
            }else{
                if(countM > 0){
                    min.append("1");
                    for(int j=1; j<countM; j++){
                        min.append("0");
                    }
                    countM =0;
                }
                 min.append("5");
            }
        }
        
        // 남은 M 처리
        if(countM > 0){
            min.append("1");
            for(int j=1; j<countM; j++){
                min.append("0");
            }
        }

        System.out.println(max);
        System.out.println(min);
        
    }

    
}