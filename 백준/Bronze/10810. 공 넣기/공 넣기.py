'''
1. 아이디어
- 공을 담을 리스트를 만들고, 해당 인덱스와 바구니 번호를 일치시킨다.
    - 몇 번씩 담는다면, 해당 인덱스의 값에 더한다.
2. 시간복잡도
- M번 바구니에 넣을 것이므로: O(M)
- i~j번째 바구니에 모두 넣을 것이므로: O(j-i+1) <= O(N)
- O(M+N) ~= 200번 연산(가능)
3. 자료구조
- int N,M
- int[] basket
'''

import sys
input = sys.stdin.readline

N,M = map(int,input().split())
basket = [0] * (N+1)

for _ in range(1,M+1):
    i,j,k = map(int, input().split())
    for idx in range(i,j+1):
        basket[idx] = k
        
print(" ".join(map(str,basket[1:])))