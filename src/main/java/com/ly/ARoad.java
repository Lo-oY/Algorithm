package com.ly;

import java.util.Objects;
import java.util.Stack;

/**
 * @author yong.liang
 * 2018/10/6
 */
public class ARoad {

    private char[][] map;

    public static void main(String args[]) {
        char[][] map = {
                {'*', '*', '+', '*', '*', '*', '+', '*'},
                {'*', '*', '+', '*', '*', '*', '+', '*'},
                {'*', '*', '*', '*', '+', '*', '*', '*'},
                {'*', '+', '+', '+', '*', '*', '*', '*'},
                {'*', '*', '*', '+', '*', '*', '*', '*'},
                {'*', '+', '*', '+', '*', '+', '*', '*'},
                {'*', '+', '+', '+', '*', '+', '+', '*'},
                {'+', '*', '*', '*', '*', '*', '*', '*'},
        };

        ARoad aRoad = new ARoad(map);
        boolean b = aRoad.mazePath(new Point(0, 0, '*'), new Point(7, 7, '*'));
        System.out.println(b);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }

    public ARoad(char[][] map) {
        this.map = map;
    }

    public boolean mazePath(Point start, Point end) {
        Stack<Foot> stack = new Stack<>();
        Point curPos = start;
//        int curStep = Dir.up.ordinal();
        do {
            if (canPass(curPos)) {
                footPrint(curPos);
                stack.push(new Foot(curPos, Dir.right.ordinal()));
                if (curPos.equals(end)) return true;
                curPos = nextPos(curPos, Dir.right.ordinal());
            } else {
                if (!stack.isEmpty()) {
                    Foot pop = stack.pop();
                    while (pop.dir == Dir.up.ordinal() && !stack.isEmpty()) {
                        pop = stack.pop();
                    }
                    if (pop.dir < Dir.up.ordinal()) {
                        pop.dir++;
                        stack.push(pop);
                        curPos = nextPos(pop.point, pop.dir);
                    }
                }
            }
        } while (!stack.isEmpty());
        return false;
    }

    private void footPrint(Point curPos) {
        int x = curPos.x;
        int y = curPos.y;
        if (x < 0 || x > map.length || y < 0 || y > map[x].length)
            return;
        map[x][y] = '#';
    }

    private Point nextPos(Point curPos, int dir) {
        int x = -1, y = -1;
        int cx = curPos.x;
        int cy = curPos.y;
        switch (dir) {
            case 0:
                x = cx;
                y = cy + 1;
                break;
            case 1:
                x = cx + 1;
                y = cy;
                break;
            case 2:
                x = cx;
                y = cy - 1;
                break;
            case 3:
                x = cx - 1;
                y = cy;
                break;
        }

        char value;
        if ((x >= 0 && x < map.length) && (y >= 0 && y < map[x].length))
            value = map[x][y];
        else
            value = ' ';
        return new Point(x, y, value);
    }

    private boolean canPass(Point curPos) {
        return curPos.ch == '*';
    }

    static class Point {
        int x;
        int y;
        char ch;

        public Point(int x, int y, char ch) {
            this.x = x;
            this.y = y;
            this.ch = ch;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y &&
                    ch == point.ch;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, ch);
        }
    }

    static class Foot {
        Point point;
        int dir;

        public Foot(Point point, int dir) {
            this.point = point;
            this.dir = dir;
        }
    }

    public enum Dir {
        right,
        down,
        left,
        up;
    }
}
