'''
1.아이디어
    - 주어진 2개의 배열에서 서로 겹치는 인물을 제거하고 남은 participant 반환하기
        1) 동명이인이 있기 때문에 set() 사용 불가능
        1-2) 두 배열의 차집합을 구하면 되지만, 중복이 있을 경우 처리 불가능
        1-3) 일일이 비교해서 제거하기 & find()를 이용하기 > 시간초과
        >> collections.Counter를 활용하여 등장 횟수까지 저장된 자료구조 활용 > 차집합 처럼 사용
'''

from collections import Counter


def solution(participant, completion):
    
    part_cnt = Counter(participant)
    com_cnt = Counter(completion)

    # 차집합처럼 동작. 값이 0이 아닌 키만 남음
    answer = part_cnt - com_cnt
    return list(answer.keys())[0]
