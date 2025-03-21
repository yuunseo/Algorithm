'''
1.아이디어
-> 백트래킹 재귀함수 내에서 for를 돌면서 숫자를 선택 > 이때 방문 여부도 확인 필요
-> 재귀함수가 M개씩 선택을 할건데, 이때 print > 재귀 호출 . . .
2.시간복잡도
->  N!의 시간 복잡도를 갖게 된다 문제 내 N은 최대 8이므로 가능.
3.자료구조
-> 방문확인여부할 배열 bool[]
-> 결과 저장할 배열 int[]

'''

import sys
input = sys.stdin.readline

N,M = map(int,input().split())
rs = [] # rs란 result의 약자
chk = [False] * (N+1) #왜 N+1이냐면, index=1부터 접근하고 싶은데 N개일 경우 0~N-1까지니까, +1해서 편하게 1~N로 접근할 수 있도록 한 방법임.

#재귀함수 생성
def recur(num):
  if num == M: # 
    print(' '.join(map(str,rs)))
    return
  for i in range(1,N+1):
    if chk[i]==False:
      chk[i]=True
      rs.append(i)
      recur(num+1)
      # 하지만, M보다 개수가 커질 경우 실패임. 그러니 갔다 오는 path로 만들어야 됨.
      chk[i] = False
      rs.pop()


recur(0)