'''
1. 아이디어
- N개의 주어진 정수 중, 구하려는 정수 v가 몇 번 존재하는지 개수를 print
2. 시간복잡도
- N번 정수 확인하기: O(N)
3. 자료구조
- int N,V
- int[] num_list

'''
import sys
input = sys.stdin.readline

N = int(input())
num_list = list(map(int,input().split()))
V = int(input())
cnt = 0

for i in num_list:
    if i == V:
        cnt += 1
        
print(cnt)