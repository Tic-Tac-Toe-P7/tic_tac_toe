import java.util.Scanner;

public class TicTacToe {
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    
    private static char[][] board = new char[3][3];
    private static char currentPlayer = PLAYER_X;
    private static Scanner putX = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("¡Bienvenido al Tres en Raya!");
        
        initializeBoard();
        displayBoard();
        
        while (true) {
            char playerBeforeMove = currentPlayer; // Guardar el jugador actual antes del movimiento
            makeMove();
            displayBoard();
            
            // Comprobar si hay ganador
            if (checkWinner()) {
                System.out.println("¡Felicidades! El jugador " + playerBeforeMove + " ha ganado!");
                break;
            }
            
            // Comprobar si hay empate
            if (isBoardFull()) {
                System.out.println("¡Es un empate! El tablero está lleno.");
                break;
            }
        }
        
        System.out.println("¡Gracias por jugar!");
        putX.close();
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
        System.out.println("\n  0 1 2");
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
        System.out.println();
    }
    
    /**
     * Maneja el movimiento del jugador
     */
    static void makeMove() {
        boolean validMove = false;
        
        while (!validMove) {
            System.out.println("Turno de " + currentPlayer);
            System.out.print("Introduce la fila (0-2): ");
            int row = putX.nextInt();
            System.out.print("Introduce la columna (0-2): ");
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
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }
    
    /**
     * Comprueba si hay un ganador en el tablero
     * @return true si hay ganador, false si no
     */
    static boolean checkWinner() {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && 
                board[i][0] == board[i][1] && 
                board[i][1] == board[i][2]) {
                return true;
            }
        }
        
        // Comprobar columnas
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && 
                board[0][j] == board[1][j] && 
                board[1][j] == board[2][j]) {
                return true;
            }
        }
        
        // Comprobar diagonal principal (de arriba-izquierda a abajo-derecha)
        if (board[0][0] != '-' && 
            board[0][0] == board[1][1] && 
            board[1][1] == board[2][2]) {
            return true;
        }
        
        // Comprobar diagonal secundaria (de arriba-derecha a abajo-izquierda)
        if (board[0][2] != '-' && 
            board[0][2] == board[1][1] && 
            board[1][1] == board[2][0]) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Comprueba si el tablero está lleno
     * @return true si está lleno, false si no
     */
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Obtiene el jugador que acaba de jugar (el contrario al actual)
     * @return el jugador anterior
     */
    static char getOtherPlayer() {
        return (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }
}