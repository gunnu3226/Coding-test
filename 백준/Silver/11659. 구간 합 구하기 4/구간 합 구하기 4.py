import sys
input = sys.stdin.readline

n, m = map(int,input().split())
sum_list = list(map(int,input().split()))
pre = [0]
pre_sum = 0

for i in range(n):
    pre_sum += sum_list[i]
    pre.append(pre_sum)
    
for j in range(m):
    i, j = map(int,input().split())
    answer = pre[j] - pre[i-1]
    print(answer)
    
    