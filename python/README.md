
## Notes

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
```
* Floats don't have infinite precision so `float('inf')` and `float('3.14')` can be a psuedo max/min-int.
* `sys.maxint` is also available.
* Consider `math.isclose()` for float comparisons on very large values.
* `x = x & x - 1` drops the lowest set bit of x.
* `i = x ^ (x & (x - 1))` is the position of lowest set bit.

### Random
```python
random.randrange(30) # [0, max-1)
random.randint(8, 16) # [min, max]
random.random() # [0, 1.0)
random.shuffle(L) # in-place
random.choice(L) # returns random element
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
* `bin(10) == '0b1010'`
