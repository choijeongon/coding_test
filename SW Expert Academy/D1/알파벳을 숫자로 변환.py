t = input()

letter_list = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
number_li = list(range(1, 27))

string_list = ''

for value in list(t):
    for check in letter_list:
        if(check == value):
            string_list += str(number_li[letter_list.index(check)])
            string_list += ' '

print(string_list)