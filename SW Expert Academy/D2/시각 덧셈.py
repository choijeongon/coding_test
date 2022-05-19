
T = int(input())

result_map = {}

for index in range(T):
    first_time, first_minute, sencond_time, second_minute = map(int, input().split())
    
    time = 0
    minute = first_minute + second_minute

    if minute >= 60:
        time += minute // 60
        minute = minute % 60
    
    time += (first_time + sencond_time)

    if time >= 13:
        time -= 12
    
    result_map[index+1] = str(time) + " " + str(minute)


for index in range(T):
    print("#" +  str(index+1)+ " "+ result_map[index+1])