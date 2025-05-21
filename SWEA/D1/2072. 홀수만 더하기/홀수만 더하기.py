T = int(input())
for test in range(1,T+1):
    nums = [i for i in list(map(int,input().split())) if i%2!=0]
    print(f"#{test} {sum(nums)}")