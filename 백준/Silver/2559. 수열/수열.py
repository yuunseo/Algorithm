'''
1. 아이디어
-> 투포인터 활용
-> for문으로 처음 k개 값을 저장
-> 다음 인덱스 더하고, 이전 인덱스 빼주기
-> 이때마다 최대값 갱신하기

2. 시간복잡도
-> O(N) = 100,000 (=1e5로 나타낼 수 있음) -> 가능

3. 자료구조
-> 전체 수 저장하는 배열 int[]
-> K개 값 저장하는 수 int

'''

import sys
input = sys.stdin.readline
N,K = map(int, input().split())
nums = list(map(int, input().split()))
each = 0

# 1. K개를 더해주기
for i in range(K):
	each += nums[i]
	
# 맨 처음 K개의 합을 최대로 설정 -> 앞으로 갱신	
maxv = each

# 2. 다음 인덱스(K번째 수)는 더해주고 이전 인덱스(i-K번째 수/맨 처음 값)는 빼주기
for i in range(K,N):
	each += nums[i]
	each -= nums[i-K]
	maxv = max(maxv, each)
	

print(maxv)