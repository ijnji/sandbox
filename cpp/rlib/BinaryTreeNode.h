#ifndef BINARY_TREE_NODE_H_
#define BINARY_TREE_NODE_H_

template <typename T>
struct BinaryTreeNode {
  T data;
  BinaryTreeNode* parent;
  BinaryTreeNode* left;
  BinaryTreeNode* right;
};

#endif