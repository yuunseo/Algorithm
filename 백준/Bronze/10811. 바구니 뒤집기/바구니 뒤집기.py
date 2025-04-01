'''
1. 아이디어
    - 1~N개의 바구니를 만들고, M번 범위에 맞게 뒤집는다.
2. 시간복잡도
    - N개의 바구니 만들기: O(N)
    - 역순만들기: O(N)
    - 출력하기: O(N)
3. 자료구조
int[] basket
'''

import sys
input = sys.stdin.readline

N,M = map(int,input().split())
basket = [i for i in range(N+1)]

for _ in range(M):
    i,j = map(int, input().split())
    basket[i:j+1] = basket[i:j+1][::-1]

print(" ".join(map(str,basket[1:])))