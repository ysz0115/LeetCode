import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by YSZ on 2017/2/16.
 */
public class NumberOfIslandsII {
    public int[][] move = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numberOfIsland(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) return result;

        int count = 0;                      // number of islands
        int[] island = new int[m * n];       // one island = one tree
        Arrays.fill(island, -1);

        for(int[] p : positions) {
            int curID = n * p[0] + p[1];     // assume new point is isolated island
            island[curID] = curID;             // add new island
            count++;

            for(int[] mov : move) {
                int x = p[0] + mov[0];
                int y = p[1] + mov[1];
                int nextPos = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || island[nextPos] == -1) continue;

                int nextPosID = findIsland(island, nextPos);
                if(curID != nextPosID) {        // if neighbor is in another island
                    island[curID] = nextPosID;   // union two islands
                    curID = nextPosID;          // curIDrent tree root = joined tree root
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    public int findIsland(int[] island, int id) {
        while(id != island[id]) id = island[id];
        return id;
    }

    public static void main(String[] arg) {
        NumberOfIslandsII noi = new NumberOfIslandsII();
        int[][] p = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        System.out.println(noi.numberOfIsland(3, 3, p));
    }
}
