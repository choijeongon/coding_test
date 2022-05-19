import math

T = int(input())

result_map = {}

for index in range(T):
    A, B = map(int, input().split())

    count = 0

    for value in range(A, B+1):
        original_value = str(value)
        reversed_value = original_value[::-1]
        doub = math.sqrt(value)
        doub_value = str(int(doub))
   
        reversed_doub_value = doub_value[::-1]
        
        if doub == int(doub):
            if original_value == reversed_value and doub_value == reversed_doub_value:
                count += 1

    result_map[index+1] = count

for index in range(T):
    print("#" + str(index+1) + " " + str(result_map[index+1]))
