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

#함수형태의 코드
n, k = map(int,input().split())
coin_list = []
for i in range(n):
    coin_list.append(int(input()))
coin_list.reverse()

def coin_min(k, coin_list):
    n = 0
    for coin in coin_list:
        n += k // coin
        k %= coin
        if k == 0:
            break
    return n
print(coin_min(k,coin_list))
