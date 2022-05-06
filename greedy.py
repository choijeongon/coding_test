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
'''
n = 4360
count = 0

coin_type = [500, 100, 50, 10]

for coin in coin_type:
    count += n // coin
    n %= coin

print(count)
'''

# 2. 집합 커버링 문제
'''
나는 라디오 쇼를 시작했다.
미국 50개의 주에 라디오 쇼를 들려주고 싶다.
하나의 방송국마다 청취할 수 있는 영역이 한정되어 있기 때문에
전국에 라디오 방송국을 방문하여 라디오 쇼를 진행할 것이다.
최대한 적은 수의 방송국을 돌아서 전국에 내 라디오를 송출하고싶다.
'''
# 정답 코드

# 방송하고자 하는 주의 목록
# states_needed = set(["mt", "wa", "or", "id", "nv", "ut", "ca", "az"])

# # 방송국 목록
# stations = {}
# stations["kone"] = set(["id", "nv", "ut"])
# stations["ktwo"] = set(["wa", "id", "mt"])
# stations["kthree"] = set(["or", "nv", "ca"])
# stations["kfour"] = set(["nv", "ut"])
# stations["kfive"] = set(["ca", "az"])

# # 내가 방문할 방송국의 목록
# final_stations = set()

# while states_needed:
#     # 1. 아직 방송이 되지 않는 주 중에서 가장 많은 주를 커버하고 있는 방송국을 고른다.
#     #  이 방송국을 best_station 이라고 부른다.
#     best_station = None
#     # 아직 방송되지 않은 주 중에서 해당 방송국이 커버하는 주의 집합
#     states_covered = set()

#     for station, states_for_station in stations.items():
#     # covered는 아직 방송되지 않는 주 중에서 현재 고려하고 있는 방송국이 커버하는 주의 집합
#         covered = states_needed & states_for_station

#         if len(covered) > len(states_covered):
#             best_station = station
#             states_covered = covered
#     states_needed -= states_covered
#     final_stations.add(best_station)

# print(final_stations)


# 방송이 필요한 도시
# city_needed = set(["광명","부천","공주","김포","천안","안동","구미","경주"])
# print(city_needed)
# # {'광명', '부천', '공주', '김포', '천안', '안동', '구미', '경주'}
 
# # 방송국은 주요대도시에 5군데 있고 주요대도시방송국은 지역도시의 방송을 커버한다.
# stations = {}
# stations["서울"] = set(["김포","천안","안동"])
# stations["인천"] = set(["부천","김포","광명"])
# stations["세종"] = set(["공주","천안","구미"])
# stations["대구"] = set(["천안","안동"])
# stations["부산"] = set(["구미","경주"])
 
# print(stations)
# '''
# {
#  '서울': {'김포', '천안', '안동'},
#  '인천': {'부천', '김포', '광명'},
#  '세종': {'공주', '천안', '구미'},
#  '대구': {'천안', '안동'},
#  '부산': {'구미', '경주'}
# }
# '''
 
# final_stations = set()
 
# # 모든 방송국을 하나씩 보면서 아직 방송이 되지 않는 도시 중에서
# # 가장 많은 도시를 커버하고 있는 방송국을 고른다.
# # 이 방송국을 best_station이라고 하겠다.
 
# while city_needed:
#     best_station = None
#     city_covered = set() # city_covered는 아직 방송되지 않은 도시 중에서 해당 방송국이 커버하는 도시의 집합이다.
#     for station, states_for_station in stations.items():
#         print("station: " + station)
#         for state in states_for_station:
#             print("states_for_station: "+ state)
#         covered = city_needed & states_for_station # {"광명","부천","공주","김포","천안","안동","구미","경주"} & {"김포","천안","안동"}
#         for state in covered:
#             print("covered state: " + state)
#         if len(covered) > len(city_covered): # 이 방송국이 현재의 best_sation보다 더 많은 도시를 커버하는지 확인
#             best_station = station # 커버한다면 이 방송국이 새로운 best_station
#             city_covered = covered
            
#     final_stations.add(best_station)
#     city_needed -= city_covered # city_needed가 완전히 빌때까지 반복한다.
 
# print(final_stations)
# {'인천', '세종', '서울', '부산'}


# 3. 큰 수의 법칙
length, count, continuous_limit = map(int, input().split())

data = list(map(int, input().split()))

print("length: " + str(length))
print("count: " + str(count))
print("continuous_limit: " + str(continuous_limit))
print(data)

max_value = 0
result = 0
saved_continuous_limit = continuous_limit

data.sort(reverse=True)
second_value = data[1]
# print(data)
# print(data[1])

for value in data:
    max_value = max(max_value, value)

# print(str(max_value))

while count > 0:
    if(continuous_limit == 0):
        result += second_value
        continuous_limit = saved_continuous_limit
        count -= 1
        continue
    result += max_value
    count -= 1
    continuous_limit -= 1

print("result: " + str(result))

