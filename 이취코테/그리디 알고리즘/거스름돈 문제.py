# 1. 거스름돈 문제
'''
당신은 음식점의 계산을 도와주는 점원이다. 
카운터에는 거스름돈으로 사용할 500원,100원,50원,10원짜리 동전이 무한히 존재한다고 가정한다. 
손님에게 거슬러 줘야 할 돈이 N원일 때 거슬러줘야할 동전의 최소 개수를 구하라. 
단 N은 항상 10의 배수이다.
'''

# 내 코드
'''
money = 4360

five_hundred_coin = 500
one_hundred_coin = 100
fifty_coin = 50
ten_coin = 10

count = 0

one_count = money // five_hundred_coin
count += one_count
one_namuze = money % five_hundred_coin

two_count = one_namuze // one_hundred_coin
count += two_count
two_namuze = one_namuze % one_hundred_coin

three_count = two_namuze // fifty_coin
count += three_count
three_namuze = two_namuze % fifty_coin

four_count = three_namuze // ten_coin
count += four_count

print(count)
'''

# 정답 코드

# n = 4360
# count = 0

# coin_type = [500, 100, 50, 10]

# for coin in coin_type:
#     count += n // coin
#     n %= coin

# print(count)


