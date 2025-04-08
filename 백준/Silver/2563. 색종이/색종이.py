'''
1. 아이디어
- 100*100 행렬 > 0으로 초기화 > 색종이 붙인 곳은 1로 갱신 & 이미 1인 곳은 패쓰
- 색종이는 시작점+10 크기임 (10*10)
  > for - for 2번 써서 정사각형 채워야함!

2. 시간복잡도
- O(100*100) > O(1)

3. 변수
- int[100][100] : 도화지 행렬
- int : 색종이 시작점 좌표, 색종이 개수

'''
import sys
input = sys.stdin.readline

n = int(input())
paper = [[0 for _ in range(100+1)] for _ in range(100+1)]

for i in range(n):
  x,y = map(int,input().split())
  for j in range(10):
    for k in range(10):
      paper[x+j][y+k] = 1
      paper[x+k][y+j] = 1

print(sum(row.count(1) for row in paper))