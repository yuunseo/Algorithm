T = int(input())
answer = ""
for test in range(1,T+1):
    a,b = map(int,input().split())
    if a<b: 
        answer = "<"
    elif a>b: 
        answer = ">"
    else: 
        answer = "="
    print(f"#{test} {answer}")