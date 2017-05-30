class BinaryTreeNode:
    
    def __init__(self, data = None, left = None, right = None, parent = None):
        self.data = data
        self.left = left
        self.right = right
        self.parent = parent

if __name__ == '__main__':
    root = BinaryTreeNode(1)
    print root