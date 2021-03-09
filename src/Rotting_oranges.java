import

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_oranges {
    int dirs[] = {0, 1, 0, -1, 0};
    public int orangesRotting(int[][] grid) {
        int n = grid.length, nr, nc, r, c, ans = 0, freshOranges = 0;
        if (n <= 0) return 0;
        int m = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (grid[i][j] == 2) queue.add(i*m+j);
                if (grid[i][j] == 1) freshOranges++;
            }
        }
        if (freshOranges == 0) return 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size--> 0) {
                int top = queue.poll();
                r = top / m;
                c = top % m;
                for(int i=0;i<dirs.length-1;i++) {
                    nr = r + dirs[i];
                    nc = c + dirs[i+1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.add(nr * m + nc);
                        freshOranges--;
                    }
                }
            }
            ans++;
        }
        return freshOranges != 0 ? -1 : ans-1;
    }
}
