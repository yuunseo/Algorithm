'''
1. 아이디어
- N*M 의 크기 행렬 2개 연산
- 이때, 같은 인덱스에 있는 원소들끼리 연산할 것!

2. 시간복잡도
- N*M 번 접근 -> O(N*M) = 100*100 = 10,000

3. 변수
- int: N,M
- int[][] : list1, list2

'''
import sys
input = sys.stdin.readline

N,M = map(int,input().split())

list_1 = [ list(map(int,input().split())) for i in range(N)]
list_2 = [ list(map(int,input().split())) for i in range(N)]

for i in range(N):
    for j in range(M):
      print(list_1[i][j] + list_2[i][j],end=" ")
    print()