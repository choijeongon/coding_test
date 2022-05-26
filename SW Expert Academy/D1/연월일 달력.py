# t = input()

# count = 1

# dic = {}

# for index in range(int(t)):
#     data = input()


#     year = data[0:4]
#     month = data[4:6]
#     day = data[6:8]

#     if int(month) > 12 or int(month) < 1:
#         dic[index+1] = '-1'
#         continue

#     if int(month) == 1 or int(month) == 3 or int(month) == 5 or int(month) == 7 or int(month) == 8 or int(month) == 10 or int(month) == 12:
#         if int(day) < 1 or int(day) > 31:
#             dic[index+1] = '-1'
#             continue
#     elif int(month) == 4 or int(month) == 6 or int(month) == 9 or int(month) == 11:
#         if int(day) < 1 or int(day) > 30:
#             dic[index+1] = '-1'
#             continue
#     elif int(month) == 2:
#         if int(day) < 1 or int(day) > 28:
#             dic[index+1] = '-1'
#             continue
#     result = year + '/' + month + '/' + day
#     dic[index+1] = result

# while count <= int(t):
#     print('#' + str(count) + " " + str(dic[count]))
#     count += 1

T = int(input())

result_map = {}

for i in range(T):
    data = input()
    year = data[0:4]
    month = data[4:6]
    day = data[6:]

    result = ''

    if int(month) < 1 or int(month) > 12:
        result_map[i+1] = '-1'
        continue

    if int(month) == 1 or int(month) == 3 or int(month) == 5 or int(month) == 7 or int(month) == 8 or int(month) == 10 or int(month) == 12:
        if int(day) < 1 or int(day) > 31:
            result_map[i+1] = '-1'
            continue
    
    if int(month) == 4 or int(month) == 6 or int(month) == 9 or int(month) == 11:
        if int(day) < 1 or int(day) > 30:
            result_map[i+1] = '-1'
            continue
    
    if int(month) == 2:
        if int(day) < 1 or int(day) > 28:
            result_map[i+1] = '-1'
            continue
    
    result_map[i+1] = year + '/' + month + '/' + day

for i in range(T):
    print("#" + str(i+1) + " " + result_map[i+1])
    
