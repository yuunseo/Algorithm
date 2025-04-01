'''
1. 아이디어
    - 공을 담을 바구니를 list로 생성한다(index는 1부터 할 수 있게 N+1개)
    - 두개의 바구니의 공을 꿔 넣고 바구니 속 공 출력 -> 
2. 시간복잡도
    - M번 스위치해야함: ?
3. 자료구조
    - int N,M
    - int[] basket
'''

import sys
input = sys.stdin.readline

N,M = map(int,input().split())
basket = [i for i in range(N+1)] #0~N번 인덱스 생성

for _ in range(M):
    i,j = map(int,input().split())
    temp = basket[j]
    basket[j] = basket[i]
    basket[i] = temp

print(" ".join(map(str,basket[1:])))