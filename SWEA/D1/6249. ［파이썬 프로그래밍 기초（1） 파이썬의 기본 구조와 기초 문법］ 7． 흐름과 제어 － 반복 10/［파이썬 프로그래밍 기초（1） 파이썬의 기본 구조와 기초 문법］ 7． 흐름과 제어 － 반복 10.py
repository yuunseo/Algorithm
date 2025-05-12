numString = input()

num_dict = {str(i):0 for i in range(10)}

for c in numString:
    num_dict[c] += 1

for i in num_dict.keys():
    print(i,end=" ")
print()
for i in num_dict.values():
    print(i,end=" ")
print()