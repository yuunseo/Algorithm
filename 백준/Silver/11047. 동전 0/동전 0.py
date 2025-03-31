'''
1.idea
- list > reverse(큰 수 부터 차감해야 하니까)
- for loop > K에서 차감
2. time complexcity
- O(N)
3. data structure

'''

import sys
input = sys.stdin.readline

N, K = map(int, input().split())
value_list = [int(input()) for _ in range(N)]
value_list.reverse()

cnt = 0
for i in value_list:
	cnt += K//i #나눈 몫만큼 횟수에 더해주고
	K %= i #나눈 나머지 만큼 갱신하고
		
print(cnt)