#1
# t = input()

# letter_list = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
# number_li = list(range(1, 27))

# string_list = ''

# for value in list(t):
#     for check in letter_list:
#         if(check == value):
#             string_list += str(number_li[letter_list.index(check)])
#             string_list += ' '

# print(string_list)
#2
# letter = input()

# li = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")

# input_list = list(letter)

# for val in input_list:
#     print(li.index(val)+ 1, end=' ')


#3
letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

input_value = input()

for value in input_value:
    for index in range(len(letter)):
        if value == letter[index]:
            print(index+1, end= ' ')