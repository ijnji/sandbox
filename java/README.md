## Notes

### Primitives
```java
int a = 6 & 4; // 2 == 0b100
int b = 1 | 2; // 3 == 0b11
int c = 0xF000_0000 >> 4; // -16777216 == 0xFF00_0000
int d = 0xF000_0000 >>> 4; // 251658240 == 0x0F00_0000
int e = 1 << 10; // 1024 == 0x400
int f = ~0; // -1 == 0xFFFF_FFFF
int g = 0xFF ^ 0xAA; // 0x55
```
```java
int it = Integer.MIN_VALUE; // -2147483648
float ft = Float.MAX_VALUE; // -2.14748365E9
double dl = Double.SIZE; // 64 (bits)
boolean bl = Boolean.TRUE; // true
```
```java
double dl = Double.valueOf("1.23");
boolean bl = Boolean.valueOf(true);
int it = Integer.parseInt("42");
String sfl = Float.toString(-1.23);
```
* `Double.compare(x, 1.23) == 0)` over `x == 1.23`
* `Math.*`: `abs(-34.5)`, `ceil(2.17)`, `floor(3.14)`, `min(x, -4)`, `max(3.14, y)`, `pow(2.71, 3.14)`, `sqrt(225)`
* `Random.*`: `nextInt(16)`, `nextBoolean()`, `nextDouble()`
