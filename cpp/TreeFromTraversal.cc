#include <cassert>
#include <iostream>
#include <vector>

#include "./rlib/BinaryTreeNode.h"

using std::cout;
using std::endl;
using std::vector;

BinaryTreeNode<int>* treeFromTraversal(vector<int> inorder, vector<int> preorder) {
  return NULL;
}

// vector<int> inorderRecursive() {
//   return NULL;
// }

int main(int argc, char* argv[]) {
  vector<int> inorder;
  inorder.push_back(1);
  inorder.push_back(2);
  inorder.push_back(3);
  inorder.push_back(4);
  inorder.push_back(5);
  inorder.push_back(6);
  vector<int> preorder;
  inorder.push_back(1);
  inorder.push_back(3);
  inorder.push_back(5);
  inorder.push_back(6);
  inorder.push_back(4);
  inorder.push_back(2);
  BinaryTreeNode<int>* root = treeFromTraversal(inorder, preorder);
  return 0;
}