package bfs_dfs;

public class LC489RobotRoomCleaner {
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    public void cleanRoom(Robot robot) {

    }

    public static void main(String[] args) {
        System.out.println(" ====== Success! =====");
    }
}
