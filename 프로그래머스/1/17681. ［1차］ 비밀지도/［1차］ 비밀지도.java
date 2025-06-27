/*
<아이디어>
0. 각 지도에서 10진수 -> 2진수로 해독한다
1. 두 지도를 합쳐서 or 처리한다 -> 하나라도 벽이면 벽이다
2. 완성된 지도로 암호 해독하자
3. 벽이면 1로 해석하고 완성된 이진수를 십진수로 변경하자


import java.util.*;

class Solution {
    public int[] ten2two(int number, int n){
        // 2진수 변환 방법
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        while(number != 1){
            answer.add(0,number%2 );
            number = number / 2;
        }
        answer.add(0,number);
        
        if(answer.size() != n){
            while(answer.size()!=n){
                answer.add(0,0);
            }
        }
        
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = answer.get(i);
            //System.out.println(result[i]);
        }
        
        return result;
        
    }
    
    public int[][] concat_map(int[][] map1, int[][] map2, int num){
        int[][] new_map = new int[num][num];
        
        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                if(map1[i][j] == 1 || map2[i][j] == 1){
                    new_map[i][j] = 1;
                }else{
                    new_map[i][j] = 0;
                }
            }
        }
        
        return new_map;
        
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        // 2진수로 해독하기
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        
        for(int i=0; i<n; i++){
            map1[i] = ten2two(arr1[i],n);
            map2[i] = ten2two(arr2[i],n);
        }
        
        // 합쳐진 지도 생성하기
        int[][] new_map = new int[n][n];
        new_map = concat_map(map1,map2,n);
        
        String temp = "";
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(new_map[i][j] == 1) temp += "#";
                else temp += " ";
            }
            answer[i] = temp;
            temp = "";
        }
        
        return answer;
    }
}
*/

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        /*
        1. 10진수 -> 2진수 -> 합체 -> #와 공백으로 변환
        */
        
        String[] answer = new String[n];
        
        String str = "";
        
        for(int i=0; i<arr1.length; i++){
            str = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = String.format("%"+n+"s",str).replace('1','#').replace('0',' ');
        }
        return answer;
    }
    
}
