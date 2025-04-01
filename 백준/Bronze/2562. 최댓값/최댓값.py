num=[]
while(True):
    num.append(int(input()))
    if(len(num)==9):
        break
print(max(num),num.index(max(num))+1)
