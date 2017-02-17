import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by YSZ on 2017/2/17.
 */
public class RemoveIslandConnectionLessThanK {
    private int[][] move = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int m;
    private int n;
    private void remove(int[][] island, int k) {
        m = island.length; n = island[0].length;
        if (m == 0 || n == 0) return;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("new");
                if (island[i][j] != 1) continue;
                island[i][j] = 2;
                q.add(new int[] {i, j});
                int count = 0;
                int[] curPos = {-1, -1};
                while (!q.isEmpty()) {
                    System.out.println("Q size " + q.size());
                    curPos = q.poll();
                    count ++;
                    System.out.println("Count " + count + " " + curPos[0] + " " + curPos[1]);
                    island[curPos[0]][curPos[1]] = 2;
                    printIsland();
                    for (int[] mov : move) {
                        int nx = mov[0] + curPos[0], ny = mov[1] + curPos[1];
                        if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                        if (island[nx][ny] == 1) {
                            island[nx][ny] = 2;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
                if (count < k && curPos[0] != -1 && curPos[1] != -1) {
                    System.out.println("Small count " + count);
                    setZeroFrom(island, curPos[0], curPos[1]);
                }
            }
        }
    }

    private void setZeroFrom(int[][] island, int i, int j) {
        System.out.println("m " + m + " n " + n + " i " + i + " j " + j);
        if (i >= m || j >= n || i < 0 || j < 0) {
//            System.out.print("out " + i + " " + j);
            return;
        }
        if (island[i][j] != 0) {
            island[i][j] = 0;
            for (int[] mov : move) {
                int nx = i + mov[0], ny = j + mov[1];
                setZeroFrom(island, nx, ny);
            }
        }
    }

    private int[][] island = {
            {1, 1, 1, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 1, 1, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0},
    };

    private void printIsland() {
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print("\t" + island[i][j]);
            }
        }
        System.out.println();
    }

    public static void main(String[] arg) {
        RemoveIslandConnectionLessThanK rrrrr = new RemoveIslandConnectionLessThanK();
        rrrrr.remove(rrrrr.island, 3);
        rrrrr.printIsland();
    }
}
