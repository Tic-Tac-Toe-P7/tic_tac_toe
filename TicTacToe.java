import java.util.Scanner;

public class TicTacToe {
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final char EMPTY = '-';
    
    private static char[][] board = new char[3][3];
    private static char currentPlayer = PLAYER_X;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("¡Bienvenido al TicTacToe!");
        
        initializeBoard();
        displayBoard();
        
        boolean gameRunning = true;
        while (gameRunning) {
            makeMove();
            displayBoard();
            
            if (checkWin()) {
                System.out.println("¡Jugador " + currentPlayer + " ha ganado!");
                gameRunning = false;
            } else if (isBoardFull()) {
                System.out.println("¡Empate!");
                gameRunning = false;
            } else {
                switchPlayer();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Inicializa el tablero con caracteres vacíos
     */
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
    
    /**
     * Muestra el tablero en consola
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
     * Maneja el movimiento del jugador actual
     */
    static void makeMove() {
        boolean validMove = false;
        
        while (!validMove) {
            System.out.println("Turno de " + currentPlayer);
            System.out.print("Introduce la fila (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Introduce la columna (0-2): ");
            int col = scanner.nextInt();
            
            if (isValidPosition(row, col)) {
                if (board[row][col] == EMPTY) {
                    board[row][col] = currentPlayer;
                    validMove = true;
                } else {
                    System.out.println("Esa celda ya está ocupada! Prueba con otra.");
                }
            } else {
                System.out.println("Posición inválida! Usa un número entre el 0 y el 2.");
            }
        }
    }
    
    /**
     * Verifica si la posición está dentro de los límites del tablero
     */
    static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }
    
    /**
     * Cambia el turno al siguiente jugador
     */
    static void switchPlayer() {
        if (currentPlayer == PLAYER_X) {
            currentPlayer = PLAYER_O;
        } else {
            currentPlayer = PLAYER_X;
        }
    }
    
    /**
     * Verifica si hay un patrón ganador
     * Patrones posibles:
     * Filas: 012, 345, 678
     * Columnas: 036, 147, 258
     * Diagonales: 048, 246
     */
    static boolean checkWin() {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && 
                board[i][1] == currentPlayer && 
                board[i][2] == currentPlayer) {
                return true;
            }
        }
        
        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer && 
                board[1][j] == currentPlayer && 
                board[2][j] == currentPlayer) {
                return true;
            }
        }
        
        // Verificar diagonal principal (0,0) -> (2,2)
        if (board[0][0] == currentPlayer && 
            board[1][1] == currentPlayer && 
            board[2][2] == currentPlayer) {
            return true;
        }
        
        // Verificar diagonal secundaria (0,2) -> (2,0)
        if (board[0][2] == currentPlayer && 
            board[1][1] == currentPlayer && 
            board[2][0] == currentPlayer) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Verifica si el tablero está lleno (empate)
     */
    static boolean isBoardFull() {
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