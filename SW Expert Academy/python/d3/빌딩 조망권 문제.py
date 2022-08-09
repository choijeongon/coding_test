
for testcase in range(1, 11):
    width = int(input())
    building_list = list(map(int, input().split()))
    count = 0

    for index in range(2, width-2):
        max_building = max(building_list[index-2], building_list[index-1], building_list[index+1], building_list[index+2])

        if building_list[index] > max_building:
            count += building_list[index]-max_building

    print("#{} {}".format(testcase, count))



