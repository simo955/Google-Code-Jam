# input() reads a string with a line of input, stripping the ' ' (newline) at the end.
# This is all you need for most Code Jam problems.
t = int(input()) # read a line with a single integer
for i in range(1, t + 1):
    n = int(input())# read a list of integers, 2 in this case
    s= str(input())
    s1=s.replace('S', 'X')
    s1=s1.replace('E', 'S')
    s1=s1.replace('X', 'E')


    print("Case #{}: {}".format(i,s1))
      # check out .format's specification for more formatting options
      
      
    