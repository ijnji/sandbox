// Description:
//
// Given a start and end point in an NxM maze, find a path through
// the maze from start to end. Indices in the maze colored black
// are walls.

package moe.ijnji.epi;

import java.util.*;

public class SearchMaze {

    public static class Coordinate {

        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Coordinate that = (Coordinate)o;
            if (x != that.x || y != that.y) {
                return false;
            }
            return true;
        }
    }

    public enum Color { WHITE, BLACK }

    public static class Entry {

        public Coordinate coord;
        public int pos;

        public Entry(Coordinate c, int p) {
            this.coord = c;
            this.pos = p;
        }

    }

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate s, Coordinate e) {
        List<Coordinate> path = new ArrayList<>();
        Deque<Entry> stk = new ArrayDeque<>();
        int[][] vis = new int[maze.size()][maze.get(0).size()];
        stk.push(new Entry(s, 1));
        while (stk.size() > 0) {
            Entry ent = stk.pop();
            Coordinate cur = ent.coord;
            int pos = ent.pos;

            if (maze.get(cur.x).get(cur.y).equals(Color.BLACK))
                continue;

            while (path.size() >= pos)
                path.remove(path.size() - 1);

            path.add(cur);
            maze.get(cur.x).set(cur.y, Color.BLACK);

            if (cur.equals(e))
                return path;

            List<Coordinate> adjs = getNextAdj(maze, cur);
            for (Coordinate a : adjs)
                stk.push(new Entry(a, pos + 1));
        }
        return Collections.emptyList();
    }

    private static List<Coordinate> getNextAdj(List<List<Color>> maze, Coordinate cur) {
        List<Coordinate> result = new ArrayList<>();

        Coordinate top = getAdj(maze, cur, 0, 1);
        if (top != null)
            result.add(top);

        Coordinate down = getAdj(maze, cur, 0, -1);
        if (down != null)
            result.add(down);

        Coordinate left = getAdj(maze, cur, -1, 0);
        if (left != null)
            result.add(left);

        Coordinate right = getAdj(maze, cur, 1, 0);
        if (right != null)
            result.add(right);

        return result;
    }

    private static Coordinate getAdj(List<List<Color>> maze, Coordinate cur, int dx, int dy) {
        int x = cur.x + dx;
        if (x < 0 || x >= maze.size())
            return null;

        int y = cur.y + dy;
        if (y < 0 || y >= maze.get(0).size())
            return null;

        Color clr = maze.get(x).get(y);
        if (clr == Color.BLACK)
            return null;

        Coordinate next = new Coordinate(x, y);
        if (maze.get(next.x).get(next.y).equals(Color.BLACK))
            return null;

        return next;
    }

}