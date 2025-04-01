'''
1. idea
-> for loop: 3~N
->An-1 + An-2 = An
-> total%10007 -> print

2. time complecity
-> O(N)

3. data structure
-> int[], int(result)

'''

import sys
input = sys.stdin.readline

n = int(input())
num_list = [0,1,2]

for i in range(3,n+1):
	num_list.append((num_list[i-2]+num_list[i-1])%10007)

print(num_list[n])