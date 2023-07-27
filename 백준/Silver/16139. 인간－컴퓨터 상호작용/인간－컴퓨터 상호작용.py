import sys
input = sys.stdin.readline
s = list(input().rstrip())
n = int(input().rstrip())

al_list = [[0]*len(s) for _ in range(26)]
for i in range(len(s)):
    al_list[ord(s[i])-ord('a')][i] += 1

for i in range(26):
    for j in range(1,len(s)):
        al_list[i][j] += al_list[i][j-1]
        
for i in range(n):
    a, l, r = input().split()
    tmp = al_list[ord(a)-ord('a')][int(r)]-al_list[ord(a)-ord('a')][int(l)]
    if s[int(l)] == a:
           tmp += 1
    print(tmp)
           
    