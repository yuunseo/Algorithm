import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
A.sort() #이진 탐색을 위한 정렬
M = int(input())
B = list(map(int, input().split()))

# 1. A 배열 정렬하기
# 2. B에 든 M개의 배열 하나씩 보면 서, A에서 이진 탐색하기

def search(st,en,target):
	if st==en:
		# 가장 마지막 나눈 범위임. 이때 값이 있으면 T 없으면 F가 됨.
		if A[st] == target:
			print("1")
		else:
			print("0")
		return
		
	mid = (st+en)//2
	if A[mid]<target:
		search(mid+1,en,target)
	else:
		search(st,mid,target)
		
		
for num in B:
	search(0, N-1, num)