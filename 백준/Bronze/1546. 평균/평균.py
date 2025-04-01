import sys
input = sys.stdin.readline

N = int(input())
score_list = list(map(int,input().split()))
maxV = max(score_list)

for i in range(N):
    score_list[i] = (score_list[i]/maxV*100)

print(sum(score_list)/N)