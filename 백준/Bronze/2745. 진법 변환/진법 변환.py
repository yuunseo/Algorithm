'''
1. 아이디어
- B진법 수(N) > 10진법으로 바꿔야 함
2. 시간복잡도
- N의 글자수 만큼 진법 변화를 해야 하므로, O(len(N))
'''

import sys
import math
input = sys.stdin.readline

N,B = input().split()
B = int(B)
total = 0

for i in range(len(N)):
  if N[i].isalpha():
    n = ord(N[i])-55 # 'A'~'Z' -> 10 ~ 35
  else:
    n = int(N[i])
  total += (n * math.pow(B,len(N)-i-1))

print(int(total))