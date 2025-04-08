'''
1. 아이디어
- 각 한 줄 씩 세서, 가장 긴 문자열에 맞춰 행렬을 생성
- 행렬 생성 후, ij -> ji 순서로 읽어오면 된다
2. 시간복잡도
- 행렬만큼 읽음 -> O(15*15) -> O(1)
3. 변수
- int total = 5
- int[][] = 문자 행렬
'''

import sys
input = sys.stdin.readline

def is_valid_char(c):
  return (
      ('A' <= c <= 'Z') or 
      ('a' <= c <= 'z') or 
      ('0' <= c <= '9')
  )

maxLength = 0

List = [list(input().split()) for i in range(5)]

for idx,li in enumerate(List):
  maxLength = max(maxLength,len(li[0]))
  List[idx] = list(li[0])

answer = [["" for j in range(maxLength)] for i in range(5)]

for i in range(5):
    for j in range(len(List[i])):
        answer[i][j] = List[i][j]

str = ""
for i in range(maxLength):
  for j in range(5):
    if is_valid_char(answer[j][i]):
      str += answer[j][i]

print(str)