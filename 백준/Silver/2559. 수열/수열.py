import sys
input = sys.stdin.readline

n, k = map(int,input().split())
tem_list = list(map(int,input().split()))

pre = 0
pre_sum = [0]

for i in range(n):
    pre += tem_list[i]
    pre_sum.append(pre)

tem_sum = []
for j in range(n-k+1):
    tem_sum.append(pre_sum[k+j]-pre_sum[j])
print(max(tem_sum))
 