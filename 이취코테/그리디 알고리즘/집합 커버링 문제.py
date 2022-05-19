
'''
나는 라디오 쇼를 시작했다.
미국 50개의 주에 라디오 쇼를 들려주고 싶다.
하나의 방송국마다 청취할 수 있는 영역이 한정되어 있기 때문에
전국에 라디오 방송국을 방문하여 라디오 쇼를 진행할 것이다.
최대한 적은 수의 방송국을 돌아서 전국에 내 라디오를 송출하고싶다.
'''
# 정답 코드

# 방송하고자 하는 주의 목록
states_needed = set(["mt", "wa", "or", "id", "nv", "ut", "ca", "az"])

# 방송국 목록
stations = {}
stations["kone"] = set(["id", "nv", "ut"])
stations["ktwo"] = set(["wa", "id", "mt"])
stations["kthree"] = set(["or", "nv", "ca"])
stations["kfour"] = set(["nv", "ut"])
stations["kfive"] = set(["ca", "az"])

# 내가 방문할 방송국의 목록
final_stations = set()

while states_needed:
    # 1. 아직 방송이 되지 않는 주 중에서 가장 많은 주를 커버하고 있는 방송국을 고른다.
    #  이 방송국을 best_station 이라고 부른다.
    best_station = None
    # 아직 방송되지 않은 주 중에서 해당 방송국이 커버하는 주의 집합
    states_covered = set()

    # station(key), states_for_station(value)
    for station, states_for_station in stations.items():
    # covered는 아직 방송되지 않는 주 중에서 현재 고려하고 있는 방송국이 커버하는 주의 집합
        covered = states_needed & states_for_station

        # 이 방송국이 현재의 best_sation보다 더 많은 도시를 커버하는지 확인
        if len(covered) > len(states_covered):
            best_station = station # 커버한다면 이 방송국이 새로운 best_station
            states_covered = covered
    states_needed -= states_covered
    final_stations.add(best_station)

print(final_stations)


# 방송이 필요한 도시
city_needed = set(["광명","부천","공주","김포","천안","안동","구미","경주"])
print(city_needed)
# {'광명', '부천', '공주', '김포', '천안', '안동', '구미', '경주'}
 
# 방송국은 주요대도시에 5군데 있고 주요대도시방송국은 지역도시의 방송을 커버한다.
stations = {}
stations["서울"] = set(["김포","천안","안동"])
stations["인천"] = set(["부천","김포","광명"])
stations["세종"] = set(["공주","천안","구미"])
stations["대구"] = set(["천안","안동"])
stations["부산"] = set(["구미","경주"])
 
print(stations)
'''
{
 '서울': {'김포', '천안', '안동'},
 '인천': {'부천', '김포', '광명'},
 '세종': {'공주', '천안', '구미'},
 '대구': {'천안', '안동'},
 '부산': {'구미', '경주'}
}
'''
 
final_stations = set()
 
# 모든 방송국을 하나씩 보면서 아직 방송이 되지 않는 도시 중에서
# 가장 많은 도시를 커버하고 있는 방송국을 고른다.
# 이 방송국을 best_station이라고 하겠다.
 
while city_needed:
    best_station = None
    city_covered = set() # city_covered는 아직 방송되지 않은 도시 중에서 해당 방송국이 커버하는 도시의 집합이다.
    for station, states_for_station in stations.items():
        print("station: " + station)
        for state in states_for_station:
            print("states_for_station: "+ state)
        covered = city_needed & states_for_station # {"광명","부천","공주","김포","천안","안동","구미","경주"} & {"김포","천안","안동"}
        for state in covered:
            print("covered state: " + state)
        if len(covered) > len(city_covered): # 이 방송국이 현재의 best_sation보다 더 많은 도시를 커버하는지 확인
            best_station = station # 커버한다면 이 방송국이 새로운 best_station
            city_covered = covered
            
    final_stations.add(best_station)
    city_needed -= city_covered # city_needed가 완전히 빌때까지 반복한다.
 
print(final_stations)
# {'인천', '세종', '서울', '부산'}
