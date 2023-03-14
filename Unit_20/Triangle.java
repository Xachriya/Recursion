package CIS2206.Unit_20;

/**
 * Prints recursively a triangle
 *
 * @author Ilias Tachmazidis
 * @version September 2022
 */
public class Triangle {

    static int size = 5;
    static char[][] board = new char[size][size];

    /**
     * A recursive function that prints a single row
     * of a triangle on a (n x n) board
     *
     * @param row the row to be updated
     * @param column the column to be updated
     */
    public static void triangleUpdateRow(int row, int column) {
        if (column < 1) { // base case
            return;
        }

        // Bottom left triangle
        board[row-1][column-1] = '*';
        // Bottom right triangle
//        board[row-1][size - column] = '*';
        // Top left triangle
//        board[size - row][column-1] = '*';
        // Top right triangle
//        board[size - row][size - column] = '*';

        // recursive case, progress (through columns)
        triangleUpdateRow(row, column - 1); 
    }

    /**
     * A recursive function that prints a triangle
     * on a (n x n) board
     *
     * @param n the dimension size of the array
     */
    public static void triangle(int n) {
        if (n < 1) { // base case
            return;
        }

        triangleUpdateRow(n,n);

        triangle(n - 1); // recursive case, progress (through rows)
    }

    public static void main(String[] args) {
        // Initialize the board with character ' '
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }

        triangle(size);

        // Print final board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}