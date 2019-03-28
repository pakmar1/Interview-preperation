class Solution {
        class Record {
        int distance;
        int houseReached;
        public Record() {
            distance = 0;
            houseReached = 0;
        }
    }
    
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return -1;
        } 
        int m = grid[0].length;
        Record[][] result = new Record[n][m];

        int houseToReach = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = new Record();
                if (grid[i][j] == 1) {
                    houseToReach++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                   if(!bfs(grid, i, j, result, houseToReach)) {
                       return -1;
                   }
                }
            }
        }
        
        int shortestDistance = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Record curRecord = result[i][j];
                if (curRecord.houseReached == houseToReach) {
                    if (shortestDistance == -1) {
                        shortestDistance = curRecord.distance;
                    } else {
                        shortestDistance = Math.min(shortestDistance, curRecord.distance);
                    }
                }
            }
        }
        
        return shortestDistance;
    }

    class Spot {
        int x;
        int y;
        int disToOrigin;
        public Spot(int x, int y, int disToOrigin) {
            this.x = x;
            this.y = y;
            this.disToOrigin = disToOrigin;
        }
    }
    
    private boolean bfs(int[][] grid, int i, int j, Record[][] result, int houseToReach) {
        int n = grid.length; 
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Spot> q = new LinkedList<>();
        q.offer(new Spot(i, j, 0));
        boolean isOrigin = true;
        int reached = 1;
        while (!q.isEmpty()) {
            Spot cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if (x >= n || x < 0 || y >= m || y < 0 || visited[x][y] == true) {
                continue;
            }
            
            if (grid[x][y] == 0) {
                result[x][y].houseReached += 1;   
                result[x][y].distance += cur.disToOrigin;
            } 
            if (grid[x][y] == 1 && !isOrigin) {
                reached++;
            }
            if (grid[x][y] == 0 || isOrigin) {
                q.offer(new Spot(x-1, y, cur.disToOrigin+1));
                q.offer(new Spot(x+1, y, cur.disToOrigin+1));
                q.offer(new Spot(x, y-1, cur.disToOrigin+1));
                q.offer(new Spot(x, y+1, cur.disToOrigin+1));
            }
            isOrigin = false;
            visited[x][y] = true;
        }
        return reached == houseToReach;
    }
}
