''' 챕1. 클래스와 메인 함수.
from typing import List


class Solution:
    def one(self, a:int, b:int)->str:
        pass

    def two(self, c:str, d:List[int])->str:
        pass

if __name__ == "__main__": # 메인 시작하는 문장
    sol = Solution()
    print(sol.one)
    print(sol.two)

'''


''' 챕2. 리스트 다루기와 f출력
# li = [1, 2, 3, 4, 5]

# for n in li:
#     print(n)

# for i in range(len(li)):
#     print(i)

# for i, n in enumerate(li):
#     print(f'i:{i}, n:{n}')

# n = 10
# for i in range(n):
#     print(i)


# li = [i for i in range(int(input()))]  # 리스트 컴프리헨션
# print(li)

# li = 'abcde'
# li2 = 'fghij'
# for s in li:
#     print(s, end='')

# li3 = li+li2
# print(li[3:5])
# 파이썬에서 :(콜론)을 쓸 땐, 왼쪽은 <= (포함)개념, 오른쪽은 < (포함x)개념이다.
# 따라서 index 3, 4만 출력된다.

# for i in range(a, b) 에서 a랑 b도 왼쪽은 <= (포함)개념, 오른쪽은 < (포함x)개념이다.

'''

''' 챕3. 클래스 내 함수 속 self의 개념. None, True, False
from typing import List


# class Solution:
#     def dfs(self, li:List)->None: # self는 클래스 객체 주입 개념이다
#         # null 대신 None을 쓴다.
#         # true 대신 True를 쓴다.
#         # false 대신 False를 쓴다.
#         print('oh')


# # if __name__ == "__main__":
# sol = Solution()
# li = [1,2,3]
# sol.dfs(li)
'''


''' 챕4. deque와 스택 사용법, collections의 활용
# deque 는 double ended queue 라는 뜻으로
# 좌우 삽입 삭제가 가능한 큐임.
# 큐를 쓰지 말고 파이썬은 deque를 쓰는게 무조건 맞음. 효율 굿


# import collections
# li = [1, 2, 3, 4, 5]
# dq = collections.deque(li)
# print(dq.popleft())

# 리스트에 삽입할 땐 .append()를 쓴다.
# stack = []
# push는 append()로 대체
# pop은 그냥 pop

# 정리! 큐랑 스택 정리
# 스택은 리스트를 그냥 사용한다. append() 그리고 pop()
# 큐는 deque를 콜렉션스와 함께 쓴다. append(), popleft() 그리고 pop()


# import collections
# li = ['a', 'b', 'b', 'c', 'c', 'c', 'd', 'd', 'd', 'd']
# c = collections.Counter(li)
# print(c)
# # 찐중요는 여기서 나옴
# print(c.most_common(1)[0][0])

# size = 100
# num = [0] * size
# # print(num)
# num[3] = 4
# print(num)


# import collections
# d = collections.defaultdict(int)
# d[3] += 1
# print(d)
# '''

'''챕5. max()의 활용
# class Solution():
#     def one(self):
#         pass


# if __name__ == "__main__":
#     max_value = 0
#     for i in range(100):
#         max_value = max(max_value, i) # 이걸 사람들이 많이 쓰더라고
#         # if max_value < i:
#         #     max_value = i
'''

'''챕6. 재귀 횟수 제한 해제
import sys
sys.setrecursionlimit(10 ** 6)
'''

'''챕7. input() 속도 향상(백준)
import sys # 이 문장
input = sys.stdin.readline # 이 문장


class Solution():
    def one(self):
        pass


if __name__ == "__main__":
    max_value = 0
    for i in range(100 ** 5):
        inp = input() # 과도한 input 시간오래걸리는걸 해소
        max_value = max(max_value, i)  # 이걸 사람들이 많이 쓰더라고
        # if max_value < i:
        #     max_value = i
'''

''' 챕8. set()
# # set 이라는 딕셔너리가 있음
# # 중복이 없는 집합 딕셔너리
# li = [1, 1, 2, 3, 4]
# print(li)
# li = set(li)
# print(li)
# li = list(set(li))
# print(li)

# 리스트에다가 여러 형 쌉 삽입 쌉 가능
li = ['a', 1, 'b', 2]
print(li)
'''

'''챕9. 입력받기와 range()
# 파이썬에서 한 줄 입력받기, 띄어쓰기 기준
# 1 2 3 입력해서 3 2 1이라고 출력하는 코드 짜고 싶다고 치자

# li = list(map(int, input().split()))
# for l in range(len(li), 0, -1): # range(first, end, ret) first는 시작할 숫자, end는 마지막 숫자, ret은 반복형식
#     print(l)

# 파이썬에서 두 개의 수를 입력받아서 두 개의 변수에 넣을 때
# input_a, input_b = map(int, input().split())
# print(input_a, input_b)
'''


'''챕10. 두 변수 값 바꾸기.
# # 자바는 두 수 자리바꾸기가 번거롭자나
# a, b = 1, 2
# print(a, b)
# a, b = b, a # 자리 바꿀 수 있다.
# print(a, b)

# 파이썬 객체라서 무조건 주소복사임 (리스트 한정)
# a = [1, 2, 3]
# b = a
# print(b)
# a.append(4)
# print(b)

# a = [1, 2, 3]
# b = a[:]
# print(b)
# a.append(4)
# print(b)
'''

'''챕터 11.
# self변형, 생성자, index(), sort()
# class Solution:
#     a = 0

#     def __init__(self, a: int) -> None:
#         self.a = a

#     def one(self):
#         print(self.a)


#     # def two(self):
#         # self.one()
#         # pass
# if __name__ == "__main__":
#     sol = Solution()
#     sol.one()


# lstrip, rstrip 등 등 나머지는 검색해보세요. re도 검색해 보세요
# string = '(a, b)'
# string = string.lstrip('(')
# print(string)
# string = string.rstrip(')')
# print(string)

# 리스트.index()
# li = ['a', 'b', 'c', 'd', 'c']
# print(li.index('c'))
# li.remove('c')
# print(li)
# del li[2]
# print(li)

# 리스트.sort(), sorted()
# a = [3, 1, 5, 4, 9]
# a = sorted(a)
# print(a)
# a = ['b', 'a', 'f']
# a.sort(reverse=True)
# print(a)
'''