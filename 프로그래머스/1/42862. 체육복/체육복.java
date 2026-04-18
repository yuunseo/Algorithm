import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 탐욕법; 현재 상황에서 최선의 선택을 한다
        // try1. for문으로 인덱스를 주었는데, 두 배열이 길이가 달라서 index-error
        // try2. List로 만들어서 빌려준 친구는 제외한다.
        // + 두 배열 중 같은 학생은 제외한다.
        // try3. 
        
        // 수업을 들을 수 있는 학생 수
        int canClass = n-lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 체육복이 없는 학생들의 리스트 생성
        List<Integer> lostList = new ArrayList<>();
        for (int std : lost) {
            lostList.add(std);
        }
        // 여분 체육복을 갖는 학생들의 리스트 생성
        List<Integer> reserveList = new ArrayList<>();
        for (int std : reserve) {
            reserveList.add(std);
        }
        
        // 두 리스트에서 중복하는 학생들 제외 & 수업 들을 수 있는 학생 수 증가
        for (int std : lost) {
            if (reserveList.contains(std)) {
                lostList.remove(Integer.valueOf(std));
                reserveList.remove(Integer.valueOf(std));
                canClass++;
            }
        }
        
        
         // 여분의 체육복을 빌려주는 과정
        for (int i = 0; i < reserveList.size(); i++) {
            int std = reserveList.get(i);
            if (lostList.contains(std - 1)) {
                canClass++;
                lostList.remove(Integer.valueOf(std - 1));
            } else if (lostList.contains(std + 1)) {
                canClass++;
                lostList.remove(Integer.valueOf(std + 1));
            }
        }
        
        return canClass;
    }
}