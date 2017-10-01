#!/usr/bin/env python3
#
# Description:
#
# Check if a binary tree is height balanced, defined as the difference between
# the shortest branch and the longest branch is not longer than 1.

# from rlib.binary_tree_node import BinaryTreeNode

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
