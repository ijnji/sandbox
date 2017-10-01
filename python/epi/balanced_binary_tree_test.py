#!/usr/bin/env python3

import pytest

from rlib.binary_tree_node import BinaryTreeNode
from epi.balanced_binary_tree import check_balance

def test_small():
    root = BinaryTreeNode(3)
    root.left = BinaryTreeNode(2)
    root.left.left = BinaryTreeNode(1)
    root.right = BinaryTreeNode(5)
    root.right.left = BinaryTreeNode(4)
    root.right.right = BinaryTreeNode(6)
    assert(check_balance(root) == True)
    root.right.left.left = BinaryTreeNode(7)
    root.right.left.left.left = BinaryTreeNode(8)
    root.right.left.left.right = BinaryTreeNode(9)
    assert(check_balance(root) == False)
