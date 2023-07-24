n,m = map(int,input().split())
arr1 = []
arr2 = []

for i in range(n):
    arr1.append(list(map(int,input().split())))
    
for j in range(n):
    arr2.append(list(map(int,input().split())))

for k in range(n):
    result = [arr1[k][l]+arr2[k][l] for l in range(m)]
    print(*result)