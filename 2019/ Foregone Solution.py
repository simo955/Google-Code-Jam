#Solution for the first problem of Google Code Jam 2019
#Test 1 and 2 passed
def prob1(n):
    x1= round(n/4)
    x2= n-x1
    s1 = set(str(x1))
    s2 = set(str(x2))
    if x1 > 10000:
        while '4' in s1 or '4' in s2:
            x1=x1-1111
            x2=x2+1111
            s1 = set(str(x1))
            s2 = set(str(x2))
    else:  
        while '4' in s1 or '4' in s2:
            x1=x1-1
            x2=x2+1
            s1 = set(str(x1))
            s2 = set(str(x2))

    return x1, x2

# input() reads a string with a line of input, stripping the ' ' (newline) at the end.
# This is all you need for most Code Jam problems.
t = int(input()) # read a line with a single integer
for i in range(1, t + 1):
    n = int(input())# read a list of integers, 2 in this case
    n1,n2 = prob1(n)
    print("Case #{}: {} {}".format(i, n1 , n2 ))
      # check out .format's specification for more formatting options
      
     