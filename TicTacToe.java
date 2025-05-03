import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private boolean makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }
    
    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }
    
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            game.printBoard();
            System.out.printf("Player %c, enter row (0-2) and column (0-2): ", game.currentPlayer);
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            if (game.makeMove(row, col)) {
                if (game.checkWin()) {
                    game.printBoard();
                    System.out.printf("Player %c wins!%n", game.currentPlayer);
                    break;
                }
                if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("It's a tie!");
                    break;
                }
                game.currentPlayer = (game.currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        scanner.close();
    }
}