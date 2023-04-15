## Notes

### Strings

```c++
// Reverse string as copy
#include <string>
std::copy(s.rbegin(), s.rend(), std::back_inserter(s));
```

### Arrays

```c++
#include <array>
std::array<int, 5> a = {9, 7, 5, 3, 1}; // Initializer list
std::array<int, 5> a2 {9, 7, 5, 3, 1}; // Uniform initialization
std::array a3 {1, 2, 3, 4}; // C++17 length can be inferred
#include <algorithm>
std::sort(a3.begin(), a3.end());
```

### Vector

```c++
#include <vector>
std::vector<int> v; // Default initialization
std::vector<int> v2 = {1, 2, 3, 4}; // Initializer list
std::vector<int> v3 {1, 2, 3, 4}; // Uniform/brace initialization
std::vector<int> v4(4); // Direct initialize with size 4
v2.at(0) = 1; // Bounds checks
v2[10] = 1; // No bounds check
```

### Custom Comparisons

```c++
#include <algorithm>
class comparator_less_than {
public:
    bool operator()(const Person &p1, const Person &p2) {
        return p1.name < p2.name);
    }
};
int main() {
    // Via functor
    std::sort(vec.begin(), vec.end(), comparator_less_than());
}
```

```c++
struct Person {
    bool operator<(const Person &other) {
        return (name < other.name);
    }
};
int main() {
    // Via operator < overload
    std::sort(vec.begin(), vec.end());
}
```

```c++
int main() {
    // Via lambda
    std::sort(vec.begin(), [](const Person &p1, const Pereson &p2) {
        return (p1.name < p2.name);
    });
}
```

### Custom Print
```c++
#include <iostream>
class Person {
    // Friend function if protected members are needed
    friend std::ostream& operator<<(std::ostream &s, const Person &p);
};
// Overload for custom class
std::ostream& operator<<(std::ostream &s, const Person &p) {
    return s << "(" << p.name << ", " << p.age << ")";
}
```

## Regex
```c++
string s{"Some people, when confronted with a problem, think I know, I'll use regular expressions."};
regex p("\\w+");
// Constructor for rvalue regex is explicitly deleted - it must be named :O
auto ibegin = sregex_iterator(s.begin(), s.end(), p);
auto iend = sregex_iterator();
for (auto it = ibegin; it != iend; ++it) {
    smatch m = *it;
    cout << m.str() << endl;
}
```

## TODO
- Recursive map/set print function with type deduction?
- String split to vector