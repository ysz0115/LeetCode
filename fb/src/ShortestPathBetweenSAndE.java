import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * Created by YSZ on 2017/2/17.
 */
public class ShortestPathBetweenSAndE {
    private int INF = 10000;
    private int xs = 0;
    private int ys = 1;
    private int xe = 9;
    private int ye = 8;
    private int m = 10;
    private int n = 10;
    private int[][] distance = new int[m][n];
    private int[][] move = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private char[][] maze = {
        {'#', 'S', '#', '#', '#', '#', '#', '#', 'o', '#'},
        {'o', 'o', 'o', 'o', 'o', 'o', '#', 'o', 'o', '#'},
        {'o', '#', 'o', '#', '#', 'o', '#', '#', 'o', '#'},
        {'o', '#', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
        {'#', '#', 'o', '#', '#', 'o', '#', '#', '#', '#'},
        {'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', 'o', '#'},
        {'#', '#', '#', '#', '#', '#', '#', '#', 'o', '#'},
        {'o', 'o', 'o', '#', 'o', 'o', 'o', 'o', 'o', 'o'},
        {'o', '#', '#', '#', '#', 'o', '#', '#', '#', 'o'},
        {'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', 'G', '#'}
    };

    private int findShortest(char[][] maze) {
        iniDistance();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {xs, ys});
        int dis = 0;
        distance[xs][ys] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curDis = distance[cur[0]][cur[1]];
            for (int[] mov : move) {
                int nx = cur[0] + mov[0], ny = cur[1] + mov[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                if (maze[nx][ny] == '#') {
                    continue;
                }
                if (distance[nx][ny] != INF) {
                    continue;
                }
                distance[nx][ny] = curDis + 1;
                q.add(new int[] {nx, ny});
            }
        }
        return distance[xe][ye];
    }

    private void iniDistance() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = INF;
            }
        }
    }

    private void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print("\t" + grid[i][j]);
            }
        }
        System.out.println();
    }

    public static void main(String[] arg) {
        ShortestPathBetweenSAndE shorrr = new ShortestPathBetweenSAndE();
        shorrr.printGrid(shorrr.distance);
        System.out.println(shorrr.findShortest(shorrr.maze));
        shorrr.printGrid(shorrr.distance);
    }
}
