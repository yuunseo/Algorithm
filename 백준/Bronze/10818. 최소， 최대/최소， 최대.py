'''
1. 아이디어
- N개의 정수가 있을 때, 그 중 최대/최소를 찾는다 > min/max 함수 활용 가능
2. 시간복잡도
- min/max(): O(N)
3. 자료구조
- int N
- int[] num_list
'''

import sys
input = sys.stdin.readline

N = int(input())
num_list = list(map(int,input().split()))
print(min(num_list), max(num_list))