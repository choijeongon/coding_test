

#배열을 문자열로 변경하는 메소드
#1
li = ['a','b','c']
print(''.join(li))

#2
reversed_board = [[0] * 5 for _ in range(5)]
for index in range(5):
    print(''.join(str(n) for n in reversed_board[index]))