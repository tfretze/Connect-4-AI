//import java.util.*;
//import java.util.Random;
//public class Board {
//    private int[][] boardMatrix;
//    private final int ROWCOUNT = 6;
//    private final int COLUMNCOUNT = 7;
//    private Pair p = new Pair();
//    private int[][] perftBoard;
//    private int[][] testBoard;
//
//
//    public Board(){
//        boardMatrix = new int[6][7];
//        for(int i = 0; i < ROWCOUNT; i++){
//            for(int j = 0; j < COLUMNCOUNT; j++){
//                boardMatrix[i][j] = 0;
//            }
//        }
//        perftBoard = new int[6][7];
//        for(int i = 0; i < ROWCOUNT; i++){
//            for(int j = 0; j < COLUMNCOUNT; j++){
//                perftBoard[i][j] = 0;
//            }
//        }
////        testBoard = new int[][]{{1,1,1,2,1,1,1},{2,0,2,1,1,0,2},{2,0,2,2,2,0,1},{1,0,1,1,0,0,2},{2,0,2,2,0,0,2},{2,0,2,1,0,0,1}};
////        boardMatrix = testBoard;
//    }
//
//    public void printBoardMatrix(){
//        for(int i = ROWCOUNT - 1; i >= 0; i--){
//            for(int j = 0; j < COLUMNCOUNT; j++){
//                if(boardMatrix[i][j] == 1){
//                    System.out.print("\u001B[37m | " +("\u001B[31m"+(boardMatrix[i][j])));
//                }
//                else if(boardMatrix[i][j] == 2){
//                    System.out.print("\u001B[37m | " +("\u001B[34m"+(boardMatrix[i][j])));
//                }
//                else{
//                    System.out.print("\u001B[37m | " + ("\u001B[37m"+(boardMatrix[i][j])));
//                }
//            }
//            System.out.println(" | ");
//        }
//        System.out.println("\u001B[37m" + " |___|___|___|___|___|___|___|");
//    }
//
//    public int getNextOpenRow(int[][] board, int move){
//        for(int i = 0; i < ROWCOUNT; i++){
//            if(board[i][move] == 0){
//                return i;
//            }
//        }
//        return 0;
//    }
//
//    public void updatePerftBoard(int row, int column, int playerMove){
//        perftBoard[row][column] = playerMove;
//    }
//
//    public void dropPlayerPiece(int row, int column, int playerMove){
//        boardMatrix[row][column] = playerMove;
//    }
//
//    public void dropAIPiece(int[][] board, int row, int column, int playerMove){
//        board[row][column] = playerMove;
//    }
//
//    public Boolean checkWin(int[][] board, int playerPiece){
//        //check rows
//        for(int i = 0; i < ROWCOUNT; i++) {
//            for (int j = 0; j < COLUMNCOUNT - 3; j++) {
//                if (board[i][j] == playerPiece && board[i][j + 1] == playerPiece &&
//                    board[i][j + 2] == playerPiece && board[i][j + 3] == playerPiece) {
//                    return true;
//                }
//            }
//        }
//
//        //check columns
//        for(int i = 0; i < ROWCOUNT - 3; i++) {
//            for (int j = 0; j < COLUMNCOUNT; j++) {
//                if (board[i][j] == playerPiece && board[i+1][j] == playerPiece &&
//                    board[i+2][j] == playerPiece && board[i+3][j] == playerPiece) {
//                    return true;
//                }
//            }
//        }
//
//        //check negative diagonal
//        for(int i = 0; i < ROWCOUNT-3; i++) {
//            for (int j = 3; j < COLUMNCOUNT; j++) {
//                if (board[i][j] == playerPiece && board[i+1][j-1] == playerPiece &&
//                    board[i+2][j-2] == playerPiece && board[i+3][j-3] == playerPiece) {
//                    return true;
//                }
//            }
//        }
//
//        //check positive diagonal
//        for(int i = 0; i < ROWCOUNT - 3; i++) {
//            for (int j = 0; j < COLUMNCOUNT - 3; j++) {
//                if (board[i][j] == playerPiece && board[i+1][j+1] == playerPiece &&
//                    board[i+2][j+2] == playerPiece && board[i+3][j+3] == playerPiece) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    public Boolean isValidMove(int[][] board, int move) {
//        return move >= 0 && move < 7 && board[ROWCOUNT-1][move] == 0;
//    }
//
//
//
//    public ArrayList<Integer> getValidLocations(int[][] board){
//        ArrayList<Integer> validLocations= new ArrayList<Integer>();
//        for(int i = 0; i < COLUMNCOUNT; i++){
//            if(isValidMove(board, i)){
//                validLocations.add(i);
//            }
//        }
//        return validLocations;
//    }
//
//    public int scorePos(int[][] board, int piece){
//        int score = 0;
//        int oppPiece = 2;
//
//
//        //centre scoring
//        for(int i = 0; i < ROWCOUNT; i++){
//            if(board[i][3] == piece){
//                score += 3;
//            }
//        }
//
//        //horizontal scoring
//        for(int i = 0; i<ROWCOUNT; i++){
//            for(int j = 0; j< COLUMNCOUNT - 3; j++){
//
//                int myPieceCount = 0;
//                int oppPieceCount = 0;
//                int emptyCount = 0;
//                for(int k = 0; k < 4; k++){
//                    if(board[i][j+k] == piece){
//                        myPieceCount++;
//                    }else if(board[i][j+k] == 0){
//                        emptyCount++;
//                    }else if(board[i][j+k] == oppPiece){
//                        oppPieceCount++;
//                    }
//                }
//                score += scoreCount(myPieceCount, oppPieceCount, emptyCount);
//            }
//        }
//
//        //vertical scoring
//        for(int i = 0; i< ROWCOUNT - 3; i++){
//            for(int j = 0; j< COLUMNCOUNT; j++){
//
//                int myPieceCount = 0;
//                int oppPieceCount = 0;
//                int emptyCount = 0;
//                for(int k = 0; k < 4; k++){
//                    if(board[i+k][j] == piece){
//                        myPieceCount++;
//                    }else if(board[i+k][j] == 0){
//                        emptyCount++;
//                    }else if(board[i+k][j] == oppPiece){
//                        oppPieceCount++;
//                    }
//                }
//                score += scoreCount(myPieceCount, oppPieceCount, emptyCount);
//            }
//        }
//
//        //Negative diagonal
//        for(int i = 0; i< ROWCOUNT - 3; i++){
//            for(int j = 3; j < COLUMNCOUNT; j++){
//
//                int myPieceCount = 0;
//                int oppPieceCount = 0;
//                int emptyCount = 0;
//                for(int k = 0; k < 4; k++){
//                    if(board[i+k][j-k] == piece){
//                        myPieceCount++;
//                    }else if(board[i+k][j-k] == 0){
//                        emptyCount++;
//                    }else if(board[i+k][j-k] == oppPiece){
//                        oppPieceCount++;
//                    }
//                }
//                score += scoreCount(myPieceCount, oppPieceCount, emptyCount);
//            }
//        }
//
//        //Positive diagonal
//        for(int i = 0; i< ROWCOUNT - 3; i++){
//            for(int j = 0; j< COLUMNCOUNT - 3; j++){
//
//                int myPieceCount = 0;
//                int oppPieceCount = 0;
//                int emptyCount = 0;
//                for(int k = 0; k < 4; k++){
//                    if(board[i+k][j+k] == piece){
//                        myPieceCount++;
//                    }else if(board[i+k][j+k] == 0){
//                        emptyCount++;
//                    }else if(board[i+k][j+k] == oppPiece){
//                        oppPieceCount++;
//                    }
//                }
//                score += scoreCount(myPieceCount, oppPieceCount, emptyCount);
//            }
//        }
//        return score;
//    }
//
//    public int scoreCount(int myPieceCount, int oppPieceCount, int emptyCount){
//        int score = 0;
//
//        if(myPieceCount == 3 && emptyCount == 1) {
//            score += 5;
//        }else if(myPieceCount == 2 && emptyCount == 2){
//            score += 2;
//        }
//
//        if(oppPieceCount == 3 && emptyCount == 1){
//            score -= 4;
//        }
//        return score;
//    }
//
//
//    public Boolean isTerminalNode(int[][] board){
//        return checkWin(board, 1) || checkWin(board, 2) || getValidLocations(board).size() == 0;
//    }
//
//    //perft function
//    public long perft(int depth){
//        ArrayList<Integer> validLocations = getValidLocations(perftBoard);
//        long nodes = 0;
//        nodes++;
//        int player = 1;
//        if(depth%2 == 0){
//            player = 2;
//        }
//        if(depth == 0){
//            return 1;
//        }
//        for(int i = 0; i< validLocations.size(); i++){
//            int row = getNextOpenRow(perftBoard, validLocations.get(i));
//
//            dropAIPiece(perftBoard, row, validLocations.get(i), player);
//            if(!isTerminalNode(perftBoard)) {
//                nodes += perft(depth - 1);
//            }
//            removePiece(perftBoard, row, validLocations.get(i));
//        }
//        return nodes;
//    }
//
//    public void removePiece(int[][] board, int row, int column){
//        board[row][column] = 0;
//    }
//
//
//    /*public int perft(int[][] board, int depth, Boolean playerMove){
//        ArrayList<Integer> validLocations = getValidLocations(board);
//        if (isTerminalNode(board)) {
//            return perftVal;
//        } else if(depth == 0) {
//            return perftVal;
//        }
//        if(playerMove) {
//            for (int i = 0; i < validLocations.size(); i++) {
//                perftVal++;
//                int row = getNextOpenRow(board, validLocations.get(i));
//                int[][] tempBoard = new int[ROWCOUNT][COLUMNCOUNT];
//                for (int j = 0; j < ROWCOUNT; j++) {
//                    for (int k = 0; k < COLUMNCOUNT; k++) {
//                        tempBoard[j][k] = board[j][k];
//                    }
//                }
//                dropAIPiece(tempBoard, row, validLocations.get(i), 1);
//                perft(tempBoard, depth - 1, false);
//            }
//            return perftVal;
//        } else{
//            for (int i = 0; i < validLocations.size(); i++) {
//                perftVal++;
//                int row = getNextOpenRow(board, validLocations.get(i));
//                int[][] tempBoard = new int[ROWCOUNT][COLUMNCOUNT];
//                for (int j = 0; j < ROWCOUNT; j++) {
//                    for (int k = 0; k < COLUMNCOUNT; k++) {
//                        tempBoard[j][k] = board[j][k];
//                    }
//                }
//                dropAIPiece(tempBoard, row, validLocations.get(i), 2);
//                perft(tempBoard, depth - 1, true);
//            }
//            return perftVal;
//        }
//    }*/
//
//    //minimax function
//    public int minimax(int[][] board, int depth, Boolean maximizingPlayer){
//        ArrayList<Integer> validLocations = getValidLocations(board);
//        if (isTerminalNode(board)) {
//            if (checkWin(board, 1)) {
//                return Integer.MAX_VALUE;
//            } else if (checkWin(board, 2)) {
//                return Integer.MIN_VALUE;
//            } else {
//                return 0;
//            }
//        } else if(depth == 0) {
//            return scorePos(board, 1);
//        }
//
//        if(maximizingPlayer){
//            int value = Integer.MIN_VALUE;
//            int column = validLocations.get(new Random().nextInt(validLocations.size()));
//            for(int i = 0; i < validLocations.size(); i++){
//                int row = getNextOpenRow(board, validLocations.get(i));
//                int[][] tempBoard = new int[ROWCOUNT][COLUMNCOUNT];
//                for(int j = 0; j < ROWCOUNT; j++){
//                    for(int k = 0; k < COLUMNCOUNT; k++){
//                        tempBoard[j][k] = board[j][k];
//                    }
//                }
//                dropAIPiece(tempBoard, row, validLocations.get(i), 1);
//                int score = minimax(tempBoard, depth -1, false);
//                if(score > value){
//                    value = score;
//                    column = validLocations.get(i);
//                }
//            }
//            p.setColumn(column);
//            p.setScore(value);
//            return value;
//        }else{
//            int value = Integer.MAX_VALUE;
//            int column = validLocations.get(new Random().nextInt(validLocations.size()));
//            for(int i = 0; i < validLocations.size(); i++){
//                int row = getNextOpenRow(board, validLocations.get(i));
//                int[][] tempBoard = new int[ROWCOUNT][COLUMNCOUNT];
//                for(int j = 0; j < ROWCOUNT; j++){
//                    for(int k = 0; k < COLUMNCOUNT; k++){
//                        tempBoard[j][k] = board[j][k];
//                    }
//                }
//                dropAIPiece(tempBoard, row, validLocations.get(i),2);
//                int score = minimax(tempBoard, depth -1, true);
//                if(score < value){
//                    value = score;
//                    column = validLocations.get(i);
//                }
//            }
//            p.setColumn(column);
//            p.setScore(value);
//            return value;
//        }
//    }
////    public int minimax(int depth, int alpha, int beta, Boolean maximizingPlayer){
////        ArrayList<Integer> validLocations = getValidLocations(boardMatrix);
////        if (isTerminalNode(boardMatrix)) {
////            if (checkWin(boardMatrix, 1)) {
////                return 100000000;
////            } else if (checkWin(boardMatrix, 2)) {
////                return -100000000;
////            } else {
////                return 0;
////            }
////        } else if(depth == 0) {
////            return scorePos(boardMatrix, 1);
////        }
////
////        if(maximizingPlayer){
////            int value = Integer.MIN_VALUE;
////            int column = validLocations.get(new Random().nextInt(validLocations.size()-1));
////            for(int i = 0; i < validLocations.size(); i++){
////                int row = getNextOpenRow(boardMatrix, validLocations.get(i));
//////                int row = placePiece(validLocations.get(i), 1);
////                dropAIPiece(boardMatrix, row, validLocations.get(i),1);
////                int tempValue = minimax(depth -1, alpha, beta, false);
////                if(tempValue > value){
////                    value = tempValue;
////                    column = validLocations.get(i);
////                }
////                removePiece(boardMatrix, row, validLocations.get(i));
////                alpha = Integer.max(value, alpha);
////                if(alpha >= beta){
////                    i = 7;
////                }
////            }
////            p.setColumn(column);
////            p.setScore(value);
////            return value;
////        }else{
////            int value = Integer.MAX_VALUE;
////            int column = validLocations.get(new Random().nextInt(validLocations.size()-1));
////            for(int i = 0; i < validLocations.size(); i++){
////                int row = getNextOpenRow(boardMatrix, validLocations.get(i));
//////                int row = placePiece(validLocations.get(i), 2);
////                dropAIPiece(boardMatrix, row, validLocations.get(i),2);
////                int tempValue =  minimax(depth -1, alpha, beta, true);
////                if(tempValue < value){
////                    value = tempValue;
////                    column = validLocations.get(i);
////                }
////                removePiece(boardMatrix, row, validLocations.get(i));
////                beta = Integer.min(value, beta);
////                if(alpha >= beta){
////                    i = 7;
////                }
////            }
////            p.setColumn(column);
////            p.setScore(value);
////            return value;
////        }
////    }
//
//    private int placePiece(int column, int playerMove){
//        for(int i = 0; i < ROWCOUNT; i++){
//            if(boardMatrix[i][column] == 0){
//                boardMatrix[i][column] = playerMove;
//                return i;
//            }
//        }
//        return 0;
//    }
//
//
//
//    //function to get best move
//    /*public int getBestMove(int[][] board, int piece){
//        ArrayList<Integer> validLocations = getValidLocations(boardMatrix);
//        int bestScore = 0;
//        int column = validLocations.get(new Random().nextInt(validLocations.size()-1));
//        for(int i = 0; i < validLocations.size(); i++){
//            int row = getNextOpenRow(board, i);
//            int[][] tempBoard = new int[ROWCOUNT][COLUMNCOUNT];
//            for(int j = 0; j < ROWCOUNT; j++){
//                for(int k = 0; k < COLUMNCOUNT; k++){
//                    tempBoard[j][k] = boardMatrix[j][k];
//                }
//            }
//            dropAIPiece(tempBoard, row, i, piece);
//            int score = scorePos(tempBoard, piece);
//            if(score > bestScore){
//                bestScore = score;
//                column = i;
//            }
//        }
//        return column;
//    }*/
//
//    public Pair getPair(){
//        return p;
//    }
//    public int[][] getBoard(){
//        return boardMatrix;
//    }
//}
//
//
import java.util.ArrayList;
import java.util.Random;

public class Board {
    private int[][] boardMatrix;    //board matrix stores the current state of the connect 4 board
    private final int ROWCOUNT = 6;
    private final int COLUMNCOUNT = 7;
    private ColumnScore colScore = new ColumnScore(); //create object to store values from the minimax algorithm

    public Board(){
        //create the board that minimax will be calculated from
        boardMatrix = new int[ROWCOUNT][COLUMNCOUNT];
        for(int i = 0; i < ROWCOUNT; i++){
            for(int j = 0; j < COLUMNCOUNT; j++){
                boardMatrix[i][j] = 0;
            }
        }
    }

    public void printBoardMatrix(){
        for(int i = ROWCOUNT - 1; i >= 0; i--){
            for(int j = 0; j < COLUMNCOUNT; j++){
                if(boardMatrix[i][j] == 1){
                    System.out.print("\u001B[37m | " +("\u001B[31m"+(boardMatrix[i][j])));
                }
                else if(boardMatrix[i][j] == 2){
                    System.out.print("\u001B[37m | " +("\u001B[34m"+(boardMatrix[i][j])));
                }
                else{
                    System.out.print("\u001B[37m | " + ("\u001B[37m"+(boardMatrix[i][j])));
                }
            }
            System.out.println(" | ");
        }
        System.out.println("\u001B[37m" + " |___|___|___|___|___|___|___|");
    }

    //Pre-conditions: player move generated
    //Post-conditions: inputs the player move on the boardmatrix and perft board
    public void inputMove(int player, int move){
        placePiece(move, player);
    }


    //Pre-conditions: board has been created, column to place piece has been selected
    //Post-conditions: puts player piece into selected board position
    public int placePiece(int column, int playerMove){
        for(int i = 0; i < ROWCOUNT; i++){
            if(boardMatrix[i][column] == 0){
                boardMatrix[i][column] = playerMove;
                return i;
            }
        }
        return 0;
    }

    //Pre-conditions: board has pieces on it
    //Post-conditions: removes a player piece from the board
    public void removePiece(int row, int column){
        boardMatrix[row][column] = 0;
    }


    //Pre-conditions: board has been created, board state inputed
    //Post-conditions: board is evaluated for a win condition, return true if condition is found false if not found
    public Boolean checkWin(int playerPiece){
        //check rows
        for(int i = 0; i < ROWCOUNT; i++) {
            for (int j = 0; j < COLUMNCOUNT - 3; j++) {
                if (boardMatrix[i][j] == playerPiece && boardMatrix[i][j + 1] == playerPiece &&
                        boardMatrix[i][j + 2] == playerPiece && boardMatrix[i][j + 3] == playerPiece) {
                    return true;
                }
            }
        }

        //check columns
        for(int i = 0; i < ROWCOUNT - 3; i++) {
            for (int j = 0; j < COLUMNCOUNT; j++) {
                if (boardMatrix[i][j] == playerPiece && boardMatrix[i+1][j] == playerPiece &&
                        boardMatrix[i+2][j] == playerPiece && boardMatrix[i+3][j] == playerPiece) {
                    return true;
                }
            }
        }

        //check negative diagonal
        for(int i = 0; i < ROWCOUNT-3; i++) {
            for (int j = 3; j < COLUMNCOUNT; j++) {
                if (boardMatrix[i][j] == playerPiece && boardMatrix[i+1][j-1] == playerPiece &&
                        boardMatrix[i+2][j-2] == playerPiece && boardMatrix[i+3][j-3] == playerPiece) {
                    return true;
                }
            }
        }

        //check positive diagonal
        for(int i = 0; i < ROWCOUNT - 3; i++) {
            for (int j = 0; j < COLUMNCOUNT - 3; j++) {
                if (boardMatrix[i][j] == playerPiece && boardMatrix[i+1][j+1] == playerPiece &&
                        boardMatrix[i+2][j+2] == playerPiece && boardMatrix[i+3][j+3] == playerPiece) {
                    return true;
                }
            }
        }

        return false;  //return false if no win condition has been satisfied
    }

    //Pre-conditions: board has been created, board state inputed
    //Post-conditions: board is evaluated and value for board state is returned as an integer value
    public int evaluatePos(){
        int value = 0;

        //check the board horizontally for all possible arrangements of pieces and add weighting if boardstate is discovered
        for(int i = 0; i<ROWCOUNT; i++){
            for(int j = 0; j< COLUMNCOUNT - 3; j++){

                int myPieceCount = 0;
                int oppPieceCount = 0;
                int emptyCount = 0;
                for(int k = 0; k < 4; k++){
                    if(boardMatrix[i][j+k] == 1){
                        myPieceCount++;
                    }else if(boardMatrix[i][j+k] == 0){
                        emptyCount++;
                    }else if(boardMatrix[i][j+k] == 2){
                        oppPieceCount++;
                    }
                }
                value += valueCount(myPieceCount, oppPieceCount, emptyCount);
            }
        }

        //check the board vertically for all possible arrangements of pieces and add weighting if boardstate is discovered
        for(int i = 0; i< ROWCOUNT - 3; i++){
            for(int j = 0; j< COLUMNCOUNT; j++){

                int myPieceCount = 0;
                int oppPieceCount = 0;
                int emptyCount = 0;
                for(int k = 0; k < 4; k++){
                    if(boardMatrix[i+k][j] == 1){
                        myPieceCount++;
                    }else if(boardMatrix[i+k][j] == 0){
                        emptyCount++;
                    }else if(boardMatrix[i+k][j] == 2){
                        oppPieceCount++;
                    }
                }
                value += valueCount(myPieceCount, oppPieceCount, emptyCount);
            }
        }

        //check the boards negative diagonals for all possible arrangements of pieces and add weighting if boardstate is discovered
        for(int i = 0; i< ROWCOUNT - 3; i++){
            for(int j = 3; j < COLUMNCOUNT; j++){

                int myPieceCount = 0;
                int oppPieceCount = 0;
                int emptyCount = 0;
                for(int k = 0; k < 4; k++){
                    if(boardMatrix[i+k][j-k] == 1){
                        myPieceCount++;
                    }else if(boardMatrix[i+k][j-k] == 0){
                        emptyCount++;
                    }else if(boardMatrix[i+k][j-k] == 2){
                        oppPieceCount++;
                    }
                }
                value += valueCount(myPieceCount, oppPieceCount, emptyCount);
            }
        }

        //check the boards positive diagonals for all possible arrangements of pieces and add weighting if boardstate is discovered
        for(int i = 0; i< ROWCOUNT - 3; i++){
            for(int j = 0; j< COLUMNCOUNT - 3; j++){

                int myPieceCount = 0;
                int oppPieceCount = 0;
                int emptyCount = 0;
                for(int k = 0; k < 4; k++){
                    if(boardMatrix[i+k][j+k] == 1){
                        myPieceCount++;
                    }else if(boardMatrix[i+k][j+k] == 0){
                        emptyCount++;
                    }else if(boardMatrix[i+k][j+k] == 2){
                        oppPieceCount++;
                    }
                }
                value += valueCount(myPieceCount, oppPieceCount, emptyCount);
            }
        }

        //add a weighting if the boardstate contains peices in the centre column
        for(int i = 0; i < ROWCOUNT; i++){
            if(boardMatrix[i][3] == 1){
                value += 2;
            }
        }
        return value;
    }

    //Pre-conditions: evaluatePos has called the function
    //Post-conditions: accumulates values based on heuristic and outputs a value,
    //scores here can be adjusted to create better or worse AI
    public int valueCount(int myPieceCount, int oppPieceCount, int emptyCount){
        int value = 0;

        //heuristic 1: 1 empty location and 3 AI pieces in a row
        if(myPieceCount == 3 && emptyCount == 1) {
            value += 15;
            //heuristic 2: 2 empty locations and 2 AI pieces in a row
        }else if(myPieceCount == 2 && emptyCount == 2){
            value += 5;
        }

        //heuristic 1: 1 empty location and 3 opponent pieces in a row
        if(oppPieceCount == 3 && emptyCount == 1){
            value -= 10;
            //heuristic 1: 2 empty locations and 2 opponent pieces in a row
        }else if(oppPieceCount == 2 && emptyCount == 2){
            value -= 3;
        }
        return value;
    }

    //Pre-conditions: board state has been created
    //Post-conditions: evaluate board state and return a boolean if a end of game condition has been satisfied
    public Boolean endOfGame(){
        return checkWin(1) || checkWin(2) || getOpenLocations().size() == 0;
    }

    //Pre-conditions: board state has been created
    //Post-conditions: creates an array list of open locations to place a piece
    public ArrayList<Integer> getOpenLocations(){
        ArrayList<Integer> openLocations= new ArrayList<Integer>();
        for(int i = 0; i < COLUMNCOUNT; i++){
            if(boardMatrix[ROWCOUNT-1][i] == 0){
                openLocations.add(i);
            }
        }
        return openLocations;
    }

    public ArrayList<Integer> getValidLocations(int player){
        ArrayList<Integer> openLocations= new ArrayList<Integer>();
        for(int i = 0; i < COLUMNCOUNT; i++){
            if(boardMatrix[ROWCOUNT-1][i] == 0){
                openLocations.add(i);
            }
        }
        return openLocations;
    }

    public Boolean isValidMove(int move) {
        return move >= 0 && move < 7 && boardMatrix[ROWCOUNT-1][move] == 0;
    }

    public long perft(int depth, int player){
        ArrayList<Integer> openLocations = getValidLocations(player);
        int nodes = 0;
        nodes++;
        if(endOfGame()){
            return nodes;
        }else if(depth == 0){
            return 1; //return 1 for every leaf node
        }
        for (int i = 0; i < openLocations.size(); i++) {
            int row = placePiece(openLocations.get(i), player); //place a piece in open location on the perft board
            if(player == 1) {
                nodes += perft(depth - 1, 2); //call perft function if end of game condition has not been satisfied
            } else{
                nodes += perft(depth - 1, 1); //call perft function if end of game condition has not been satisfied
            }
            removePiece(row, openLocations.get(i)); //remove piece from the perft board.
        }
        return nodes;
    }


    //Pre-conditions: board state has been created
    //Post-conditions: returns a column and value which is the best position to
    //place the piece as determined by the evaluation function
    public int minimax(int depth, int alpha, int beta, Boolean maximizingPlayer){
        ArrayList<Integer> openLocations = getOpenLocations(); //create a current list of open locations to place a piece based on the boar state
        //check if current state is an end of game condition
        if (endOfGame()) {
            if (checkWin(1)) {
                return Integer.MAX_VALUE; //return large integer if board state returns player win
            } else if (checkWin(2)) {
                return Integer.MIN_VALUE; //return large negative integer if board state returns opponent win
            } else {
                return 0; //return 0 if state is a draw
            }
        } else if(depth == 0) {
            return evaluatePos(); //if leaf node is not a win condition return the evaluation of the board state at depth set
        }
        //if it is the AI players move
        if(maximizingPlayer){
            int value = Integer.MIN_VALUE;
            int column = openLocations.get(new Random().nextInt(openLocations.size()));  //set column to a random open location
            //loop through open locations where a piece could be placed which serve as the child nodes to the current node
            for(int i = 0; i < openLocations.size(); i++){
                int row = placePiece(openLocations.get(i), 1);  //place a piece in an open location
                int tempValue = minimax(depth -1, alpha, beta, false); //set temp value to the value of the recursion, change to minimising player
                //check if the value of the current child is greater then the stored value
                if(tempValue > value){
                    value = tempValue; //update the value with tempValue
                    column = openLocations.get(i); //set column to current location
                }
                removePiece(row, openLocations.get(i)); //finally remove the placed piece for future recursions
                //alpha-beta pruning
                alpha = Integer.max(value, alpha);
                if(alpha >= beta){
                    i = 7;
                }
            }
            //set value and column to the maximising column and value and return the maximising value
            colScore.setColumn(column);
            colScore.setScore(value);
            return value;
        }
        //else if it is the opponents move
        else {
            int value = Integer.MAX_VALUE;
            int column = openLocations.get(new Random().nextInt(openLocations.size())); //set column to a random open location
            //loop through open locations where a piece could be placed which serve as the child nodes to the current node
            for(int i = 0; i < openLocations.size(); i++){
                int row = placePiece(openLocations.get(i), 2);  //place a piece in an open location
                int tempValue = minimax(depth -1, alpha, beta, true); //set temp value to the value of the recursion, change to maximising player
                //check if the value of the current child is less then the stored value
                if(tempValue < value){
                    value = tempValue;  //update the value with tempValue
                    column = openLocations.get(i); //set column to current location
                }
                removePiece(row, openLocations.get(i)); //finally remove the placed piece for future recursions
                //alpha-beta pruning
                beta = Integer.min(value, beta);
                if(alpha >= beta){
                    i = 7;
                }
            }
            colScore.setColumn(column);
            colScore.setScore(value);
            return value;
        }
    }

    //getter for
    public ColumnScore getColumnScore(){
        return colScore;
    }
}