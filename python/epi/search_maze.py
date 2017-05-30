# Description:
#
# Given a 2D maze where each coordinate is either open space (white), or closed
# space (black), return a path from the starting coordinate to the ending
# coordinate, if possible.

import collections
from rlib.testing import expect

WHITE, BLACK = xrange(2)
C = collections.namedtuple('C', ('x', 'y'))

def search_maze(maze, start, end):
    def get_open_adjacent(cur, maze):
        pre_adj = [C(cur.x, cur.y - 1), C(cur.x + 1, cur.y),
                   C(cur.x, cur.y + 1), C(cur.x - 1, cur.y)]
        post_adj = []
        for a in pre_adj:
            if 0 <= a.x < len(maze) and 0 <= a.y < len(maze[a.x]) and maze[a.y][a.x] == WHITE:
                post_adj.append(a)
        return post_adj

    VISITING, VISITED = xrange(2)
    memo = {}
    stk = [start]
    res = []
    while len(stk) > 0:
        cur = stk.pop()
        memo[cur] = VISITED
        res.append(cur)
        if cur == end: return res
        cur_adj = get_open_adjacent(cur, maze)
        if len(cur_adj) == 0:
            res.pop()
        else:
            for a in cur_adj:
                if a not in memo:
                    memo[a] = VISITING
                    stk.append(a)
    return []

def small_test():
    maze = [
        [WHITE, WHITE, WHITE],
        [WHITE, BLACK, BLACK],
        [WHITE, WHITE, WHITE],
    ]
    start, end = C(0, 0), C(2, 2)
    expect(search_maze(maze, start, end)).to_be([
        C(0, 0), C(0, 1), C(0, 2), C(1, 2), C(2, 2)
    ])

if __name__ == '__main__':
    small_test()
