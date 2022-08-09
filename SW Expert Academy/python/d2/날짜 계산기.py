
T = int(input())

for index in range(1, T+1):
    first_month, first_day, second_month, second_day = map(int, input().split())
    count = 0

    # 동일 월일경우 날짜만 계산
    if first_month == second_month:
        count = abs(first_day-second_day)+1
    else:
        for month in range(first_month+1, second_month):
            if month == 2:
                count += 28
            elif month == 3 or month == 5 or month == 7 or month == 8 or month == 10 or month == 12:
                count += 31
            elif month == 4 or month == 6 or month == 9 or month == 11:
                count += 30
        if first_month == 1 or first_month == 3 or first_month == 5 or first_month == 7 or first_month == 8 or first_month == 10 or first_month == 12:
            count += (31 - first_day) 
        elif first_month == 2:
            count += (28 - first_day)
        elif first_month == 4 or first_month ==6 or first_month ==9 or first_month ==11:
            count += (30 - first_day)
        count += (second_day+1)
    
    print("#{} {}".format(index, count))