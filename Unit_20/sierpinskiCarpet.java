package CIS2206.Unit_20;

/**
 * Class for generating a Sierpinski carpet, a fractal pattern made up of repeating squares within squares.
 */
public class sierpinskiCarpet {

    // 2D array of strings to store the carpet
    static String[][] carpet;
    // Size stores the dimension size of the carpet
    static int size;

    /**
     * Constructs a new sierpinskiCarpet with the given size. Initializes the carpet array with the given size and fills it with asterisks.
     * @param s The size of the carpet.
     */
    public sierpinskiCarpet(int s) {
        this.size = s;
        carpet = new String[size][size];
        int i = 0;
        int j = 0;
        while (i < s) {
            j = 0;
            while (j < s) {
                this.carpet[i][j] = " * ";
                j++;
            }
            i++;
        }
    }

    /**
     * Makes the middle square of a given size at a given position in the carpet array empty.
     * @param current_size The size of the square to empty.
     * @param x The x-coordinate of the top-left corner of the square.
     * @param y The y-coordinate of the top-left corner of the square.
     */
    public static void makeEmpty(int current_size, int x, int y) {
        int i = y + current_size / 3;
        int j = 0;
        while (i <= y + 2 * (current_size / 3) - 1) {
            j = x + current_size / 3;
            while (j <= x + 2 * (current_size / 3) - 1) {
                carpet[i][j] = "   ";
                j++;
            }
            i++;
        }
    }

    /**
     * Recursively divides the carpet into smaller squares and empties the middle one.
     * @param carpet The 2D array representing the carpet.
     * @param x The x-coordinate of the top-left corner of the current square.
     * @param y The y-coordinate of the top-left corner of the current square.
     * @param current_size The size of the current square.
     */
    public static void create(String[][] carpet, int x, int y, int current_size) {
        // Empty the center block
        makeEmpty(current_size, x, y);

        // If size is less than one, return
        if (current_size <= 1) {
            return;
        }
        int i = 0;
        int j = 0;
        // Loops to go through all the 9 blocks
        while(i<current_size)
        {
            j = 0;
            while (j < current_size) {
                // Recursive function to move to the 3n-1x3n-1 block
                create(carpet, i + y, j + x, current_size / 3);
                j += (current_size / 3);
            }
            i += (current_size / 3);
        }
    }

    /**
     * Prints out the Sierpinski carpet to the console.
     * @param size The size of the carpet.
     */
    public static void print(int size) {
        // Loops through all the array and prints it
        int i = 0;
        int j = 0;
        String output = "";
        while (i < size) {
            j = 0;
            output = "";
            while (j < size) {
                output += carpet[i][j];
                j++;
            }
            System.out.println(output);
            i++;
        }
    }

    public static void main(String[] args) {
        sierpinskiCarpet board = new sierpinskiCarpet(243);
        System.out.println("\n carpet 3X3\n");
        create(carpet, 0, 0, 3);
        print(3);
        System.out.println("\n carpet 9X9\n");
        create(carpet, 0, 0, 9);
        print(9);
        System.out.println("\n carpet 27X27\n");
        create(carpet, 0, 0, 27);
        print(27);
        System.out.println("\n carpet 81X81\n");
        create(carpet, 0, 0, 81);
        print(81);
        System.out.println("\n carpet 243X243\n");
        create(carpet, 0, 0, 243);
        print(243);
    }
}
