n = int(input())
peoples = list(map(int,input().split()))
peoples.sort()
time = 0
for i in range(len(peoples)):
    time += peoples[i]*(n-i)
print(time)  


