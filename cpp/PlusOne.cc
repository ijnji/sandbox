#include <iostream>
#include <vector>

using namespace std;

vector<int> plusOne(vector<int> A) {
  A.back()++;
  for (size_t i = A.size() - 1; i > 0 && A[i] == 10; i--) {
    A[i] = 0;
    A[i - 1]++;
  }
  if (A[0] == 10) {
    A[0] = 0;
    A.insert(A.begin(), 1);
  }
  return A;
}

void show(vector<int> A) {
  for (size_t i = 0; i < A.size(); i++) {
    cout << A[i];
  }
  cout << endl;
}

void smallTest() {
  // vector<vector<int>> stims;
  // stims.push_back({9, 9});
  // stims.push_back({0});
  // stims.push_back({1, 2, 3});
  vector<vector<int>> stims = {
    {9, 9},
    {0},
    {1, 2, 3}
  };
  for (size_t i = 0; i < stims.size(); i++) {
    show(plusOne(stims[i]));
  }
}

int main(int argc, char* argv[]) {
  smallTest();
  return 0;
}