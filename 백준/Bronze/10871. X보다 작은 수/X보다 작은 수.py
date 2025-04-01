'''
1. 아이디어
- N개의 정수를 1차원 배열에 넣어, 하나씩 꺼낸 후 > X보다 작다면 정답 리스트에 추가하기
2. 시간복잡도
- N개의 정수 모두 확인하기: O(N)
3. 자료구조
- int N,X
- int[] num_list
'''

import sys
input = sys.stdin.readline

V,X = map(int, input().split())
num_list = list(map(int,input().split()))
rs_list = list()

for num in num_list:
    if num < X:
        rs_list.append(num)
        
print(" ".join(map(str,rs_list))) # join은 문자열 리스트만 처리 가능하기에 map으로 변환해 준다.