def solution(array, commands):
    answer = []
    for index in range(len(commands)):
        temp_array = array[commands[index][0] - 1:commands[index][1]]
        temp_array.sort()
        answer.append(temp_array[commands[index][2]-1])
    return answer