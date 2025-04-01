'''
1. 아이디어
> MST 기본 문제(외우기!!)
- 간선을 인접리스트에 넣기
- 힙에 시작 노드 넣기 ~ 힙이 빌 때까지 다음 작업을 반복
	- 힙의 최소 값 꺼내서, 해당 노드 방문 안했다면
		- 방문 표시, 해당 비용 추가, 연결된 간선들 힙에 추가
		
2. 시간복잡도
> MST = O(ElgE)

3. 자료구조
> 간선 저장되는 인접 리스트 (비용, 노드 번호)
> 힙 (비용, 노드번호)
> 방문 여부 bool[]
> MST 결과 값 int

'''
import heapq
import sys
input = sys.stdin.readline

V,E = map(int, input().split())
edge = [[] for _ in range(V+1)] # 1번 인덱스부터 사용할라고 V+1까지 해줌.
chk = [False] * (V+1)
rs = 0

for i in range(E):
	a,b,c = map(int, input().split())
	edge[a].append([c,b]) # 양방향 간선이므로 양방향 다 넣어줘야함.
	edge[b].append([c,a])
	
	
heap = [[0,1]] # 아무 시작 점이나 골라서 추가하기. 시작 점이므로 비용은 0

while heap: # 힙이 존재하는 동안 반복
	w, each_node = heapq.heappop(heap)
	if chk[each_node] == False:
		chk[each_node] = True
		rs += w
		for next_edge in edge[each_node]: # 아까 꺼낸 node에 붙어있는 간선들을 보는 거임.
			if chk[next_edge[1]] == False: # next_edge 안에는 [w,V]형태로 저장되어 있으니 V 꺼내서 확인.
				heapq.heappush(heap, next_edge)
				
print(rs)