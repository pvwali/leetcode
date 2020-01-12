import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;

                    Queue<int[]> nbs = new LinkedList<>();
                    nbs.offer(new int[] {r,c});
                    while (!nbs.isEmpty()) {
                        // int qsize = nbs.size();
                        // for (int i = 0; i<qsize; i++) {
                        int[] p = nbs.poll();
                        int pr = p[0]; int pc = p[1];

                        grid[pr][pc] = '0';
                        if (pr+1 < m && grid[pr+1][pc] == '1') {
                            nbs.offer(new int[] {pr+1, pc});
                        }
                        if (pr-1 >= 0 && grid[pr-1][pc] == '1') {
                            nbs.offer(new int[] {pr-1, pc});
                        }
                        if (pc+1 < n && grid[pr][pc+1] == '1') {
                            nbs.offer(new int[] {pr, pc+1});
                        }
                        if (pc-1 >= 0 && grid[pr][pc-1] == '1') {
                            nbs.offer(new int[] {pr, pc-1});
                        }
                        // }
                    }
                }
            }
        }
        return numIslands;
    }

    public static void main(String[] args) {
        NumberOfIslands noi = new NumberOfIslands();

        char[] r1 = new char[] {'1','1','1'};
        char[] r2 = new char[] {'1','0','1'};
        int ans = noi.numIslands(new char[][] {r1, r2});
        System.out.println(ans);
    }
}
