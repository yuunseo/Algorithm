'''
1. 아이디어
    - 1~30번 중, 주어진 28을 없애면 남은 2개가 발견될 것!
    - 1~30에 0이 담긴 리스트를 생성하고, 있는 번호에는 1을 추가
    - 최종 리스트에서 순서대로 print
2. 시간복잡도
    - list 생성하기: O(N)
    - N번 확인하기: O(N)
    - 0인 값 찾기: O(N)
3. 자료구조
    - int[] num_list
'''

import sys
input = sys.stdin.readline

num_list = [0 for _ in range(31)]

for _ in range(28):
    n = int(input())
    num_list[n] = 1 

first_idx = num_list.index(0,1) # 0번 인덱스 제외하고 1번 인덱스부터 찾기
second_idx = num_list.index(0,first_idx+1) # 이전에 나온 인덱스 제외하고 이후부터 찾기

print(first_idx)
print(second_idx)