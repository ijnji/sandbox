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
* `Double.compare(x, 1.23) == 0` over `x == 1.23`
* `Math.*`: `abs(-34.5)`, `ceil(2.17)`, `floor(3.14)`, `min(x, -4)`, `max(3.14, y)`, `pow(2.71, 3.14)`, `sqrt(225)`
* `Random.*`: `nextInt(16)`, `nextBoolean()`, `nextDouble()`

### Arrays
```java
int one[] = new int[]{1, 2, 3};
int two[][] = new int[3][];
int len = two.length;
```
* `Arrays.*`: `binarySearch(A, 5)`, `copyOf(A)`, `copyOfRange(A, 1, 5)`, `equals(A, B)`, `fill(A, 42)`, `find(A, 28)`, `sort(A)`, `sort(A, cmp)`, `toString()`

### Strings
```java
StringBuilder sb = new StringBuilder();
sb.append("a");
char c = sb.charAt(1);
sb.delete(startInclusive, endExclusive);
sb.deleteCharAt(1);
sb.insert(offset, "bc"); // also with most primitives and objects
sb.reverse();
sb.replace(startInclusive, endExclusive, "hello");
sb.toString();
```
```java
String s = "orange";
char c = s.charAt(1);
int i = s.compareTo("banana"); // 13 (lexicographically)
String ct = s.concat("apple");
boolean b1 = s.contains("ran");
boolean b2 = s.endsWith("range");
boolean b3 = s.equalsIgnoreCase("Orange");
int i1 = s.indexOf("e"); // also with char
int i2 = s.indexOf("r", offset); // also with char
int i3 = s.lastIndexOf("o"); // also with char
int l = s.length();
String sp1 = s.replace("range", "ption"); // also with char
String sp2 = s.replaceAll("[a-z]", "*");df
String sp3 = s.replaceFirst("[a-z]");
String[] spl1 = "the rabbit goes over the hill".split("\\s");
String[] spl2 = "the rabbit goes over the hill".split("\\s", limit);
boolean b4 = s.startsWith("or");
boolean b5 = s.startsWith("or", offset);
String ss1 = s.substring(startInclusive);
String ss2 = s.substring(startInclusive, endExclusive);
char[] chs = s.toCharArray();
String lr = s.toLowerCase();
String ur = s.toUpperCase();
String tm = s.trim();
```
```java
String s = "abc";
int cp = s.codePointAt(1);
```
* `Character.*`:`codePointAt(input, startInclusive)`, `toChars(codePoint)`, `charCount(codePoint)`
