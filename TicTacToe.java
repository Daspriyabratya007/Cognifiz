import java.util.Scanner;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static char[][] board = new char[3][3];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            initializeBoard();
            boolean gameWon = false;
            boolean isXTurn = true;

            while (true) {
                printBoard();
                char currentPlayer = isXTurn ? PLAYER_X : PLAYER_O;
                System.out.println("Player " + currentPlayer + "'s turn.");

                int row, col;
                while (true) {
                    System.out.print("Enter row (0, 1, or 2): ");
                    row = scanner.nextInt();
                    System.out.print("Enter column (0, 1, or 2): ");
                    col = scanner.nextInt();

                    if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
                        break;
                    } else {
                        System.out.println("This position is invalid or already taken. Try again.");
                    }
                }

                board[row][col] = currentPlayer;

                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                    break;
                }

                if (checkDraw()) {
                    printBoard();
                    System.out.println("The game is a draw!");
                    break;
                }

                isXTurn = !isXTurn;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
