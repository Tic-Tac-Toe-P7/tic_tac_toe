import java.util.Scanner;

public class TicTacToe {
    private static final char PLAYER_X = 'X';
    
    private static char[][] board = new char[3][3];
    private static char currentPlayer = PLAYER_X;
    private static Scanner putX = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("¡Bienvenido!");
        
        initializeBoard();
        displayBoard();
        
        while (true) {
            
            makeMove();
            displayBoard();
        }
        
        // putX.close(); // Comentado porque nunca se alcanza
    }
    
    /**
     * Inicializa el tablero
     */
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    /**
     * Muestra el tablero
     */
    static void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }
    
    /**
     * Maneja el movimiento del jugador
     */
    static void makeMove() {
        boolean validMove = false;
        
        while (!validMove) {
            System.out.println("Turno de " + currentPlayer);
            System.out.print("Introduce en la fila (0-2): ");
            int row = putX.nextInt();
            System.out.print("Introduce en la columna (0-2): ");
            int col = putX.nextInt();
            
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayer;
                    validMove = true;
                } else {
                    System.out.println("Esa celda ya está ocupada! Prueba con otra.");
                }
            } else {
                System.out.println("Posición inválida! Usa un número entre el 0 y el 2.");
            }
        }
        
        // Cambiar de jugador
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
    
   
    static boolean checkWin(){
        
        for (int i = 0; i < 3; i++) {
            if(board[i][0] != '-' && 
        board[i][0] == board[i][1] && 
        board[i][1] == board[i][2]) {
        return true;
        }
        
    }
    return false;


}
}
