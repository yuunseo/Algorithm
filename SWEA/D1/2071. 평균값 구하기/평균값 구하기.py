T = int(input())
for test in range(1,T+1):
    nums = list(map(int,input().split()))
    avg = round(sum(nums)/len(nums))
    print(f"#{test} {avg}")