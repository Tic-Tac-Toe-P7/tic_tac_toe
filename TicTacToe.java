import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        Scanner putX = new Scanner(System.in);

    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

        System.out.println("Binevenido!");

       while(){
        System.out.println("te toca: " + player);
        System.out.print("escribe fila y columna: ");
        String rowCol = putX.nextLine();  
        
        displayBoard();

        




    }

        putX.close();
    

    }
    /*
     * function name : table
     * char[][]
     */
static char[] board = new char[3][3];

initializeBoard();
displayBoard();

static void initializeBoard() {
    for (int i= 0; i<3; i++) {
        for (int j = 0 < 3; j++) {
            board[i][j] = '-';
        }
    }

static void displayBoard() {
    System.out.printIn("  0 1 2");
    for (int i = 0; i < 3; i++) {
        System.out.printIn(i + " ");
        for (int j = 0; j < 3; j++) {
            System.out.printIn(board[i][j] + " ");
        }
        System.out.printIn();
        if (i < 2) {
            System.out.printIn("  -----");
        }
    }
}

     /*
      * function name : compPlayerMovement
      *(math.random)
      */

static void makeMove() {
    //de quien es el turno
    System.out.printIn("Turno de"+ currentPlayer );
    //que el jugador introduzca la fila y la columna
    System.out.print("Introduce en la fila (0-2): ");
    int row = putX.nextInt();
    System.out.print("Introduce en la columna (0-2): ");
    int col = putX.nextInt();

    //colocar la marca
    board[row][col] = currentPlayer;
}


    static char compPlayerMovement = 'X';
        if(currentPlayer == 'X') {
         currentPlayer ='O';}

        else{
        currentPlayer = 'x';
        }

    boolean validMove = false ;

        while (validMove) {
            System.out.println("turno de " + currentPlayer);
            makeMove ();
        }if (row >= 0 && row < 3 && column >=0 && column <3) {

        }if ( board [row][column] = ' ') {
            board [row][column] = currentPlayer;
            validMove = true;
        }

        // cambiar de jugador otra vez
        if(currentPlayer=='X')
        {
            currentPlayer = 'O';
        }else
        {
            currentPlayer = 'X';
        }

        // mensajes de error
    }else{System.out.println("Esa celda ya está ocupada! Prueba con otra.");}
    }else{System.out.println("Posición inválida! Usa un número entre el 0 y el 2.");

    }}}



        System.out.println("");

}



      /*
       * function name : winPattern
       * 123
       * 456
       * 789
       * 
       */


}