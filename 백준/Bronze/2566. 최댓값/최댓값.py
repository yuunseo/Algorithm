'''
1. 아이디어
- 9*9 행렬을 돌면서, 최대값 갱신 & 인덱스 갱신

2. 시간복잡도
- 9*9개 돌아야 하므로 -> O(1)

3. 변수
- int[][] 
'''

import sys
input = sys.stdin.readline

matrx = [list(map(int,input().split())) for i in range(9)]
maxV = 0
maxI = 0
maxJ = 0

for n in range(len(matrx)):
  for idx, num in enumerate(matrx[n]):
    if maxV <= num: 
      maxV = num
      maxI = n+1
      maxJ = idx+1

print(maxV)
print(maxI,maxJ)    