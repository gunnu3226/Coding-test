n = int(input())
mitting = []
for i in range(n):
    mitting.append(tuple(map(int,input().split())))
    
mitting.sort(key = lambda x : (x[1],x[0]))
end_time = 0
ans = 0
for mit in mitting:
    if mit[0]>=end_time:
        ans += 1
        end_time = mit[1]

print(ans)