T = int(input())

for test in range(1,T+1):
    num_list = list(map(int,input().split()))
    print(f"#{test} {max(num_list)}")