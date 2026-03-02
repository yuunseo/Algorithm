def money(List, bud):
  start = 0
  end = max(List)
  while(start <=end):
    mon = bud
    mid = (start+end)//2

    for i in range(len(List)):
      if(List[i]<= mid):
        mon -= List[i]
      else:
        mon -= mid

    if(mon<0):
      end = mid-1
    else:
      start = mid+1
    
  return end

def main():
  
  N = int(input())
  List=sorted(list(map(int,input().split())))
  bud = int(input())

  answer= money(List, bud)
  print(answer)

main()