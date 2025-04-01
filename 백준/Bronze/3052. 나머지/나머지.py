result=[]
for i in range(10):
    a = int(input())
    result.append(a%42)
print(len(set(result)))