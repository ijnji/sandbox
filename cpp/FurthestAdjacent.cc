// Description:
//
// Give an array of positive integers, let pairs of integers form an interval.
// Define adjacent pairs as pairs where no other integers in the array fall
// within said interval. Write a function to find the largest difference in
// indices among all adjacent pairs in the array.

#include <cassert>
#include <climits>
#include <iostream>
#include <map>
#include <cmath>
#include <vector>

using namespace std;

int furthestAdjacent(vector<int> values) {
  int lo = INT_MAX, hi = INT_MIN;
  map<int, vector<int>> m;
  for (int i = 0; i < values.size(); i++) {
    int v = values[i];
    lo = min(lo, v);
    hi = max(hi, v);
    if (!m[v]) m[v] = {};
    m[v].push_back(i);
  }
  return 0;
}

void smallTest() {
  // int valuesA[] = {0, 3, 3, 7, 5, 3, 11, 1};
  // assert(furthestAdjacent(valuesA) == 7);
  // int valuesB[] = {1, 4, 7, 3, 3, 5};
  // assert(furthestAdjacent(valuesB) == 7);
  vector<int> values;
  values = {0, 3, 3, 7, 5, 3, 11, 1};
  assert(furthestAdjacent(values) == 7);
  values = {1, 4, 7, 3, 3, 5};
  assert(furthestAdjacent(values) == 4);
}

void hello() {
  cout << "hello!" << endl;
}

int main(int argc, char* argv[]) {
  smallTest();
  return 0;
}
