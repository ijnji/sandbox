## Notes (Python 3.x)

```python
x = x & x - 1 # drops the lowest set bit of x
i = x ^ (x & (x - 1)) # index of the lowest set bit
```

### Primitives
```python
abs(-34.5) == 34.5
math.ceil(2.17) == 3.0
math.floor(3.14) == 3.0
min(1, 2) == 1
max(3.14, 4.0) == 4.0
pow(2, 10) == 1024
2 ** 10 == 1024
math.sqrt(225) == 15.0
```

```python
str(42) == '42'
int('42') == 42
float('3.14') == 3.14
float('inf') # psuedo min/max, floats don't have infinite precision
sys.maxint
math.isclose() # float comparison
```

### Bitwise Operations
```python
6 & 4 == 4
1 | 2 == 3
8 >> 1 == 4
~0 == -1
0b1010 ^ 0b0101 == 0b1111
bin(10) == '0b1010'
int(0b1010) == 10
```

### Strings
```python
s = str(9)
s = 'hello'
s[3] = 'l'
s = 'abc' + 'def;'
s[2:4] == 'cd'
'abc' in s
s.strip()
s.startswith(prefix)
s.endswith(suffix)
'apple,peach,pear'.split(',')
','.join('Gauss', 'Prince of Mathematicians') # any iterable can be joined
s.tolower()
'Name name, Rank rank'.format(name='Archimedes', rank=3)
'Hello my name is {0}'.format('Doug')
```

### Arrays
```python
[3, 5, 7, 11]
[1] + [0] * 10
list(range(100))
len(A)
min(A)
max(A)
A[inclusive_start:exclusive_end:step]
A[-1] # last element
a in A # O(n)
```
```python
A.append(42)
A.remove(2) # not index, instead element
A.insert(i, 28) # O(n)
A.pop() # O(1), into end
A.pop(i) # O(n)
del A[i]
```
```python
sorted(A) # new primitives, shallow objects
reversed(A) # returns an iterator
A.sort() # in-place
A.reverse() # in-place
bisect.bisect(A, 6)
bisect.bisect_left(A, 6)
bisect.bisect_right(A, 6)
```
```python
B = A # assign reference
B = list(A) # new primitives, shallow objects
copy.copy(A) # shallow copy
copy.deepcopy(A) # deep copy
```
```python
[x**2 for x in range(6)]
[x**2 for x in range(6) if x % 2 == 0]
[(x, y) for x in [1, 2, 3] for y in [7, 8, 9]] # (1, 7), (1, 8), (1, 9), etc
```

### Stacks
```python
stk = []
stk.append(1)
stk.pop() # 1
```

### Queues
```python
from collections import deque

```

### Random
```python
random.randrange(30) # [0, max-1)
random.randint(min, max) # [min, max]
random.random() # [0.0, 1.0)
random.shuffle(L) # in-place
random.choice(L) # returns random element
```

### Iterators
```python
it = iter([5, 6, 7, 8, 9])
next(it) # 5
for x in it: print(x) # 6, 7, 8, 9
```
