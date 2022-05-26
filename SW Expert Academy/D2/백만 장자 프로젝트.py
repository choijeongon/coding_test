
# T = int(input())

# for testcase_index in range(1, T+1):
#     N = int(input())
#     price_list = list(map(int, input().split()))

#     max_value = price_list[-1]

#     profit =0

#     for index in range(N-2, -1, -1):
#         #만약 현재 매매가가 최대값보다 크면 최대값 변경
#         if price_list[index] >= max_value:
#             max_value = price_list[index]
#         # 현재 매매가가 최대값보다 크지 않으면 차익을 profit 변수에 더해준다.
#         else:
#             profit += max_value - price_list[index]
    
#     print('#{} {}'.format(testcase_index, profit))


#2
T = int(input())

for testcase in (range(1, T+1)):
    N = int(input())
    data_list = list(map(int, input().split()))

    benefit = 0
    max_value = 0

    for index in range(N-1, -1, -1):
        if max_value < data_list[index]:
            max_value = data_list[index]
        
        if data_list[index] < max_value:
            benefit += (max_value - data_list[index])
    
    print("#{} {}".format(testcase, benefit))



