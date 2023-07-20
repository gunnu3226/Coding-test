n, k = map(int,input().split())
coin_list = []
for i in range(n):
    coin_list.append(int(input()))
coin_list.reverse()
n = 0
for coin in coin_list:
    n += k//coin
    k %= coin
    if k == 0:
        break
print(n)

        