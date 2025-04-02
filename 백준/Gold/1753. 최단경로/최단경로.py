'''
1. 아이디어
- 인접리스트로 간선 저장하기
- 거리배열 초기화하기
- 시작 노드, 힙에 추가하기
- 다익스트라 반복하기
	- 최신 값인지 먼저 확인
	- 간선을 타고 간 비용이 더 작으면, 거리 배열 갱신

2. 시간복잡도
- O(ElgV)
    E < 3e5
    lgV ~< 2e
    = E*lgV = 6e6 < 2e8 (가능)

3. 변수
- (int,int) [] : 인접리스트
- int[]: 거리배열 -> INF로 초기화
- (int,int) : 힙
'''
import heapq
import sys
input = sys.stdin.readline

INF = sys.maxsize
V,E = map(int,input().split())
start_node = int(input())

# 거리 배열 -> 노드의 번호에 맞춰, 노드까지의 거리를 나타냄
dis_list = [INF] * (V+1)

# 인접리스트 -> 간선이 어떤 노드와 연결되어 있는지 나타냄, 인덱스와 노드 번호는 같다
edge_list = [ list() for _ in range(V+1)]

for _ in range(E):
    u,v,w = map(int,input().split())
    edge_list[u].append([w,v])

# 시작점 초기화
dis_list[start_node] = 0

# heap 초기화
heap = [[0,start_node]]

while heap:
    w,v = heapq.heappop(heap) # 현재 위치해 있는 노드를 말한다
    if w != dis_list[v]: continue

    for nw,nv in edge_list[v]: # 현재 위치해 있는 노드와 연결된 다음 노드를 꺼내온다
        if dis_list[nv] > dis_list[v] + nw:
            dis_list[nv] = dis_list[v] + nw
            heapq.heappush(heap, [dis_list[nv],nv])


for dis in dis_list[1:]:
	if dis == INF: print("INF")
	else: print(dis)