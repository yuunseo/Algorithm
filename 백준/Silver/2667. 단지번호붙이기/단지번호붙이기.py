'''
1. 아이디어
	-> 2중 for문 > 값 == 1 && False -> DFS
	-> DFS를 통해 찾은 값 저장 > 정렬> 출력
2. 시간복잡도
	-> DFS: V+E
	-> V = n*n
	-> E = 4*n*n
	-> V+E = n*n + 4*n*n = 5*n*n = 5*625 = 3,125 -> 사용 가능
3. 자료구조
	-> 그래프를 저장할 2차원 배열 int[][]
	-> 방문 여부: bool[][]
	-> 결과 값 저장 배열: int[]
'''

import sys
input = sys.stdin.readline

n = int(input())
grp = [list(map(int,input().strip())) for i in range(n)]
chk = [[False]*n for i in range(n)]
result = []
each = 0 # BFS와는 달리, 전역변수로 설정해서 바로 크기를 설정하는 것이 더 나음. DFS는 함수로 리턴하지 않을 것이니까!

# 4방향 살펴보기 위해
dy = [0,1,0,-1]
dx = [1,0,-1,0]

def dfs(y,x):
	global each
	each += 1 # 이어진 영역을 1개 찾을 때 마다 +1
	for k in range(4):
		ny = y + dy[k]
		nx = x + dx[k]
		if 0<=ny<n and 0<=nx<n: # 4방향을 확인할 때는, 꼭 범위에 초과하지 않는지 확인 필요!!
			if grp[ny][nx]==1 and chk[ny][nx]== False:
				chk[ny][nx] = True
				dfs(ny,nx) # 재귀호출 시작 !! 


for j in range(n):
	for i in range(n):
		if grp[j][i] == 1 and chk[j][i] == False:
			# 방문 후 체크
			# DFS로 크기 구하기
			# DFS 크기 배열에 저장하기
			chk[j][i] = True
			each = 0 # 새로운 재귀 시작 전, 0으로 초기화 필요!
			dfs(j,i)
			result.append(each)
			

result.sort()			
print(len(result))
for i in result:
	print(i)
