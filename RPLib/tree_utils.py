#!/usr/bin/env python3

from collections import deque
from rlib.binary_tree_node import BinaryTreeNode

def buildTree(datas):
    root = BinaryTreeNode()
    que = deque([root])
    for d in datas:
        n = que.popleft()
        n.data = d
        n.left = BinaryTreeNode()
        n.right = BinaryTreeNode()
        que.append(n.left)
        que.append(n.right)
    return trimTree(root)

def trimTree(root):
    if root.data == None: return None
    que = deque([root])
    while len(que) > 0:
        n = que.popleft()
        if n.left != None:
            if n.left.data == None: n.left = None
            else: que.append(n.left)
        if n.right != None:
            if n.right.data == None: n.right = None
            else: que.append(n.right)
    return root

def buildTreeWithParent(datas):
    return linkParents(buildTree(datas))

def linkParents(root):
    que = deque([root])
    while len(que) > 0:
        n = que.popleft()
        if n.left != None:
            n.left.parent = n
            que.append(n.left)
        if n.right != None:
            n.right.parent = n
            que.append(n.right)
    return root
