h, m = input().split()
h = int(h)
m = int(m)

if(m >= 45):
    print(h,m-45)
else:
    if(h==0):
        print(23,60-(45-m))
    else:
        print(h-1,60-(45-m))