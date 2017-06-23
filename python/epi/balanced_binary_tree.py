#!/usr/bin/env python3
#
# Description:
#
# Check if a binary tree is height balanced, defined as the difference between
# the shortest branch and the longest branch is not longer than 1.

from rlib.binary_tree_node import BinaryTreeNode
from rlib.testing_utils import expect

def check_balance(root):
    def check_recurse(root):
        if root is None: return (True, 0)
        lb = check_recurse(root.left)
        if lb[0] is False: return (False, 0)
        rb = check_recurse(root.right)
        if rb[0] is False: return (False, 0)
        h = max(lb[1], rb[1]) + 1
        return (False if abs(lb[1] - rb[1]) > 1 else True, h)
    return check_recurse(root)[0]

def small_test():
    root = BinaryTreeNode(3)
    root.left = BinaryTreeNode(2)
    root.left.left = BinaryTreeNode(1)
    root.right = BinaryTreeNode(5)
    root.right.left = BinaryTreeNode(4)
    root.right.right = BinaryTreeNode(6)
    expect(check_balance(root)).to_be(True)
    root.right.left.left = BinaryTreeNode(7)
    root.right.left.left.left = BinaryTreeNode(8)
    root.right.left.left.right = BinaryTreeNode(9)
    expect(check_balance(root)).to_be(False)

if __name__ == '__main__':
    small_test()
