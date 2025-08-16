import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int n = 3;
        char[][] board = new char[n][n];

        // Initialize the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Tic Tac Toe is ready for play!\n");

        System.out.print("What is your name, player 1: ");
        String p1 = in.nextLine();

        System.out.print("What is your name, player 2: ");
        String p2 = in.nextLine();

        boolean player1 = true;
        boolean gameEnded = false;

        while (!gameEnded) {
            drawBoard(board);

            if (player1) {
                System.out.println(p1 + "'s Turn (x):");
            } else {
                System.out.println(p2 + "'s Turn (o):");
            }

            char c = player1 ? 'x' : 'o';
            int row, col;

            while (true) {
                System.out.print("Enter a row number (0-2): ");
                row = in.nextInt();
                System.out.print("Enter a column number (0-2): ");
                col = in.nextInt();

                if (row < 0 || col < 0 || row >= n || col >= n) {
                    System.out.println("This position is off the bounds of the board! Try again.");
                } else if (board[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position! Try again.");
                } else {
                    break;
                }
            }

            board[row][col] = c;

            if (playerHasWon(board) == 'x') {
                drawBoard(board);
                System.out.println(p1 + " has won!");
                gameEnded = true;
            } else if (playerHasWon(board) == 'o') {
                drawBoard(board);
                System.out.println(p2 + " has won!");
                gameEnded = true;
            } else {
                if (boardIsFull(board)) {
                    drawBoard(board);
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    player1 = !player1;
                }
            }
        }

        in.close();
    }

    // Draws the Tic Tac Toe board
    public static void drawBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Checks for a win
    public static char playerHasWon(char[][] board) {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }
        // Columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }
        // Diagonal (top-left to bottom-right)
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        // Diagonal (top-right to bottom-left)
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return ' ';
    }

    // Checks if board is full
    public static boolean boardIsFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
