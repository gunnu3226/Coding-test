n = int(input())
long_list = list(map(int,input().split()))
price_list = list(map(int,input().split()))

price = price_list[0]
total = 0

for i in range(len(long_list)):
    if price > price_list[i+1]:  #현재 주유소가 다음 주유소보다 비싸면 다음 주유소로 가격 초기화
        total += price*long_list[i]
        price = price_list[i+1]
    elif price <= price_list[i+1]:    #현재 주유소가 다음 주유소보다 싸면 가격 초기화x
        total += price*long_list[i]
                
print(total)
        
    