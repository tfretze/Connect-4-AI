import java.util.*;
import java.util.Random;
public class Connect4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board b = new Board();
        Boolean gameOver = false;
        int turn = new Random().nextInt(2);
        b.printBoardMatrix();
        int player = 0;
        int AI = 1;


        while(!gameOver){
            int selection;
            if(turn == player){
                System.out.print("\u001B[31m" + "Player 2 Make your selection(0-6): ");
                do {
                    selection = input.nextInt();
                }while(!b.isValidMove(selection));
                System.out.println();

                if(b.isValidMove(selection)){
                    b.placePiece(selection, 2);

                }
                if(b.checkWin(2)){
                    System.out.println("\u001B[34m" + "Player 2 wins");
                    gameOver = true;
                }

            }else{
                System.out.println("player 1 AI makes a move");
                System.out.println("Score:" + b.minimax(9, Integer.MIN_VALUE, Integer.MAX_VALUE, true));
                System.out.println("Column: " + b.getColumnScore().getColumn());
                selection = b.getColumnScore().getColumn();

//                selection = b.getBestMove(2);

//                two player mode
//                System.out.print("\u001B[34m"+"Player 2 Make your selection(0-6): ");
//                do {
//                    selection = input.nextInt();
//                }while(!b.isValidMove(selection));
//                System.out.println();
//
                if(b.isValidMove(selection)){
                    b.placePiece(selection, 1);

                }
                if(b.checkWin(2)){
                    System.out.println("\u001B[31m" + "Player 1 wins");
                    gameOver = true;
                }

            }
            turn += 1;
            turn = turn % 2;
            b.printBoardMatrix();
        }
    }
}
