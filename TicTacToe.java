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

    static char compPlayerMovement = 'x';
        if(compPlayerMovement = 'x' && 'o'){

        }else 


        System.out.println("");
    



      /*
       * function name : winPattern
       * 123
       * 456
       * 789
       * 
       */


}