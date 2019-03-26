/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    int[][] dirs = new int[][]{{-1, 0}, { 0, -1 }, { 1, 0 }, {0, 1}};
    //                            UP       LEFT     DOWN      RIGHT
    Robot r;
    Set<String> s = new HashSet<String>();
    
    public void cleanRoom(Robot robot) {
        r = robot;
        cleanRoom(0, 0, 0);
    }
    
    private void cleanRoom(int direction, int x, int y) {
        String t = x + "->" + y;
        // if I was already here, return.
        if (s.contains(t)) return;
        s.add(t);
		// clean current position
        r.clean();      
        
		// for each one of the directions
        for (int i = 0; i < dirs.length; i++) {
            int nextDirection = (direction + i) % dirs.length;
            if (r.move()) {
                // if I was able to move one, keep going down the rabbit hole..
                cleanRoom(nextDirection, x + dirs[nextDirection][0], y + dirs[nextDirection][1]);
                // After returning from the rabbit hole, go back to where I started at 
                // and adjust my position back to what it was
                r.turnLeft();
                r.turnLeft();
                r.move();
                r.turnLeft();
                r.turnLeft();
            }
			// try turning to the next direction
            r.turnLeft();
        }
    }
}
