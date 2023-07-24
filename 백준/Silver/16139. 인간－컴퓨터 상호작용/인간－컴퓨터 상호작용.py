word = input()
n = int(input())
for i in range(n):
    al, l, r = input().split()
    l = int(l)
    r = int(r)
    ans = 0
    for j in range(l,r+1):
        if word[j]==al:
            ans += 1
    print(ans)
     
            
            