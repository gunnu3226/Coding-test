arr1 = []
for i in range(9):
    arr1.append(list(map(int,input().split())))
    
arr1_max = 0
row = 0
col = 0

for j in range(9):
    for k in range(9):
        if arr1[j][k]>=arr1_max:
            arr1_max = arr1[j][k]
            row = j+1
            col = k+1
print(arr1_max)
print(row, col)
             
            