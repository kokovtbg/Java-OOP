package WorkingWithAbstraction.exercise.JediGalaxy;

public class Galaxy {
    private int[][] galaxy;

    public static int[][] drawGalaxy(int rows, int cols) {
        int[][] galaxy = new int[rows][cols];
        int number = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                galaxy[i][j] = number;
                number++;
            }
        }
        return galaxy;
    }

    public static void moveEvil(int[][] galaxy, int startRow, int startCol) {
        while (startRow >= 0 && startCol >= 0) {
            if (startRow < galaxy.length && startCol < galaxy[0].length) {
                galaxy[startRow][startCol] = 0;
            }
            startRow--;
            startCol--;
        }
    }

    public static int movePlayer(int[][] galaxy, int startRow, int starCol) {
        int sum = 0;
        while (startRow >= 0 && starCol < galaxy[0].length) {
            if (startRow < galaxy.length && starCol >= 0) {
                sum += galaxy[startRow][starCol];
            }
            startRow--;
            starCol++;
        }
        return sum;
    }
}
